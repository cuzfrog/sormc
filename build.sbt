import sbt.Credentials
import sbt.Keys._

resolvers ++= Seq(
  "bintray-cuzfrog-maven" at "http://dl.bintray.com/cuzfrog/maven",
  "Artima Maven Repository" at "http://repo.artima.com/releases"
)

shellPrompt in ThisBuild := { state => Project.extract(state).currentRef.project + "> " }

crossScalaVersions := Seq("2.11.8", "2.12.1")

lazy val commonSettings = Seq(
  organization := "com.github.cuzfrog",
  version := "1.1.0",
  scalaVersion := "2.11.8",
  logBuffered in Test := false,
  scalacOptions in Compile ++= Seq("-unchecked", "-feature", "-deprecation",
    "-language:postfixOps", "-language:implicitConversions",
    "-language:higherKinds", "-language:existentials"),
  libraryDependencies ++= Seq(
    "junit" % "junit" % "4.12" % "test",
    "com.novocode" % "junit-interface" % "0.11" % "test->default"
  )
)

lazy val root = (project in file("."))
  .settings(commonSettings: _*)
  .settings(
    name := "sormc",
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-compiler" % scalaVersion.value % "compile",
      "com.typesafe.scala-logging" %% "scala-logging" % "3.5.0",
      "com.google.guava" % "guava" % "13.0.1",
      "com.mchange" % "c3p0" % "0.9.5.2",
      "com.h2database" % "h2" % "1.4.191" % "test"
    ),
    publishTo := Some("My Bintray" at "https://api.bintray.com/maven/cuzfrog/maven/sormc/;publish=1"),
    credentials += Credentials("Bintray API Realm", "api.bintray.com", "BINTRAY_USER", "BINTRAY_PASS"),
    compile in Compile <<= (compile in Compile) dependsOn versionReadme,
    versionReadme := {
      val contents = IO.read(file("README.md"))
      val regex ="""(?<=libraryDependencies \+= "com\.github\.cuzfrog" %% "sormc" % ")[\d\w\-\.]+(?=")"""
      val newContents = contents.replaceAll(regex, version.value)
      IO.write(file("README.md"), newContents)
    }
  )

reColors := Seq("magenta")

lazy val versionReadme = TaskKey[Unit]("version-readme", "Update version in README.MD")


