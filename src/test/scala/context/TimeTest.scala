package context

import java.time.LocalDateTime

import org.junit.Test


// Declare a model:
case class Artist(name: String, genres: Set[Genre], saveTime: LocalDateTime)

case class Genre(name: String)

// Initialize SORM, automatically generating schema:
import sorm._

object Db extends Instance(
  entities = Set(Entity[Artist](), Entity[Genre]()),
  url = "jdbc:h2:mem:test"
)


class TimeTest {


  @Test
  def timeTest(): Unit = {

    // Store values in the db:
    val metal = Db.save(Genre("Metal"))
    val rock = Db.save(Genre("Rock"))
    Db.save(Artist("Metallica", Set(metal, rock), LocalDateTime.now()))
    Db.save(Artist("Dire Straits", Set(rock), LocalDateTime.now()))

    // Retrieve values from the db:
    // Option[Artist with Persisted]:
    val metallica = Db.query[Artist].whereEqual("name", "Metallica").fetchOne()
    // Stream[Artist with Persisted]:
    val rockArtists = Db.query[Artist].whereEqual("genres.item.name", "Rock").fetch()

    Thread.sleep(300)

    metallica.foreach(println)
    rockArtists.foreach(println)
    println(LocalDateTime.now())
  }
}
