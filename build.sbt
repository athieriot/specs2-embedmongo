name := "specs2-embedmongo"

organization := "com.github.athieriot"
description := "Specs2 helper to configure a EmbedMongo based instance"
version := "0.8-SNAPSHOT"
scalaVersion := "2.10.7"
crossScalaVersions := Seq("2.10.7", "2.11.12", "2.12.4")

libraryDependencies <++= scalaVersion(sv => Seq(
  "de.flapdoodle.embed" % "de.flapdoodle.embed.mongo" % "2.0.0",
  "org.specs2" %% "specs2-core" % "3.9.5",
  "org.mongodb" %% "casbah-core" % "3.1.1" % "provided",
  "com.github.salat" %% "salat" % "1.11.2" % "test",
  "junit" % "junit" % "4.11" % "test"
))

scalacOptions in Test ++= Seq("-Yrangepos")

parallelExecution in Test := false

publishMavenStyle := true
publishArtifact in Test := false
pomIncludeRepository := { _ => false }
pomExtra := <url>http://github.com/athieriot/specs2-embedmongo</url>
  <licenses>
    <license>
      <name>Apache 2.0</name>
      <url>http://www.opensource.org/licenses/Apache-2.0</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>git@github.com:athieriot/specs2-embedmongo.git</url>
    <connection>scm:git:git@github.com:athieriot/specs2-embedmongo.git</connection>
  </scm>
  <developers>
    <developer>
      <id>athieriot</id>
      <name>Aurélien Thieriot</name>
      <url>http://athieriot.github.com/resume</url>
    </developer>
  </developers>

publishTo <<= version { version: String =>
  val nexus = "https://oss.sonatype.org/"
  if (version.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "service/local/staging/deploy/maven2")
}
