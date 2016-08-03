organization := "com.github.cuzfrog"
name := "sormc"
version := "1.0.2"
scalaVersion := "2.11.8"


lazy val root = (project in file("."))
resolvers ++= Seq(
  "Local Maven Repository" at """file:///"""+Path.userHome.absolutePath+"""\.m2\repository""",
  "bintray-cuzfrog-maven" at "http://dl.bintray.com/cuzfrog/maven",
  "Artima Maven Repository" at "http://repo.artima.com/releases"
)

libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-compiler" % "2.11.8",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.1.0",
  "com.google.guava" % "guava" % "13.0.1",
  "org.joda" % "joda-convert" % "1.2",
  "joda-time" % "joda-time" % "2.9.4",
  "com.mchange" % "c3p0" % "0.9.5.2"
)

reColors := Seq("magenta")