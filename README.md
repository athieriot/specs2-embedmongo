# EmbeddedMongo connection helper for Specs2 tests
With specs2-embeddedmongo you can easily use embeddedmongo in your specs2 tests suites

You can add the EmbeddedConnection trait to your tests classes and that will provide a standalone instance of a MongoDB server using this project:

 * https://github.com/michaelmosmann/embedmongo.flapdoodle.de

By default, it will open a connection (before the test suite) on the port 12345 and close it (after that)
You can change thow default values:

 * MongoDB port by overriding embeddedConnectionPort()
 * MongoDB version by overriding embeddedMongoDBVersion()

# What it looks like?

 - [Sample](https://github.com/athieriot/specs2-embeddedmongo/tree/master/src/test/scala/org/at/ModelTest.scala)
