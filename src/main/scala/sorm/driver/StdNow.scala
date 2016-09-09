package sorm.driver

import java.time.LocalDateTime
import sorm.jdbc.{JdbcConnection, Statement}

trait StdNow { self: StdConnection =>
  def now() : LocalDateTime
    = connection
        .executeQuery(Statement("SELECT NOW()"))()
        .head.head
        .asInstanceOf[LocalDateTime]

}
