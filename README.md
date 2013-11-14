# EmbedMongo connection helper for Specs2 tests
With specs2-embedmongo you can easily use embedmongo in your specs2 tests suites

You can add the EmbedConnection trait to your tests classes and that will provide a standalone instance of a MongoDB server using this project:

 * https://github.com/michaelmosmann/embedmongo.flapdoodle.de

By default, it will open a connection (before the test suite) on the port 12345 and close it (after that)
You can change thow default values:

 * MongoDB port by overriding embedConnectionPort()
 * MongoDB version by overriding embedMongoDBVersion()

# What it looks like?

 - [Sample](https://github.com/athieriot/specs2-embedmongo/tree/master/src/test/scala/com/github/athieriot/ModelTest.scala)

# Add as dependency

Modify `project/Build.scala` and add

`"com.github.athieriot" %% "specs2-embedmongo" % "0.5.1"`

[![Bitdeli Badge](https://d2weczhvl823v0.cloudfront.net/athieriot/embedded-mongo/trend.png)](https://bitdeli.com/free "Bitdeli Badge")
