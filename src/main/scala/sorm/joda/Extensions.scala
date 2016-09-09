package sorm.joda

import java.time._

object Extensions {

  implicit class DateTimeToJava(val self: LocalDateTime) extends AnyVal {
    def toJavaSql = java.sql.Timestamp.valueOf(self)
  }

  implicit class LocalDateToJava(val self: LocalDate) extends AnyVal {
    def toJavaSql = java.sql.Date.valueOf(self)
  }

  implicit class LocalTimeToJava(val self: LocalTime) extends AnyVal {
    def toJavaSql = java.sql.Time.valueOf(self)
  }


  implicit class DateToJoda(val self: java.sql.Date) extends AnyVal {
    def toJava8 = self.toLocalDate
  }

  implicit class TimeToJoda(val self: java.sql.Time) extends AnyVal {
    def toJava8 = self.toLocalTime
  }

  implicit class TimestampToJoda(val self: java.sql.Timestamp) extends AnyVal {
    def toJava8 = self.toLocalDateTime
  }


}