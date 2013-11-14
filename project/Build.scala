import sbt._
import sbt.Keys._

object ProjectBuild extends Build {

  lazy val buildVersion =  "0.5.1"

  lazy val root = Project(id = "specs2-embedmongo", base = file("."), settings = Project.defaultSettings).settings(
    organization := "com.github.athieriot",
    description := "Specs2 helper to configure a EmbedMongo based instance",
    version := buildVersion,

    crossScalaVersions := Seq("2.9.2", "2.10.1"),
    scalaVersion <<= crossScalaVersions { (vs: Seq[String]) => vs.head },

    resolvers += "Typesafe Releases" at "http://repo.typesafe.com/typesafe/releases/",
    resolvers += "Typesafe Snapshots" at "http://repo.typesafe.com/typesafe/snapshots/",
    resolvers += "Novus Snapshots" at "http://repo.novus.com/snapshots/",
    resolvers += "Sonatype snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/",
    resolvers += "Sonatype releases" at "https://oss.sonatype.org/content/repositories/releases/",

    libraryDependencies += "de.flapdoodle.embed" % "de.flapdoodle.embed.mongo" % "1.33",
    libraryDependencies += "org.specs2" %% "specs2" % "1.12.3",
    libraryDependencies += "com.novus" %% "salat-core" % "1.9.4" % "test",

    publishMavenStyle := true,
    publishArtifact in Test := false,
    pomIncludeRepository := { _ => false },
    pomExtra := (
      <url>http://github.com/athieriot/specs2-embedmongo</url>
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
    ),
    publishTo <<= version { version: String =>
      val nexus = "https://oss.sonatype.org/"
      if (version.trim.endsWith("SNAPSHOT"))
        Some("snapshots" at nexus + "content/repositories/snapshots")
      else
        Some("releases" at nexus + "service/local/staging/deploy/maven2")
    }
  )
}
