# EmbedMongo connection helper for Specs2 tests
With specs2-embedmongo you can easily use embedmongo in your specs2 tests suites

You can add the [EmbedConnection](https://github.com/athieriot/specs2-embedmongo/tree/master/src/main/scala/com/github/athieriot/EmbedConnection.scala) trait to your tests classes and that will provide a standalone instance of a MongoDB server using this project:

 * https://github.com/michaelmosmann/embedmongo.flapdoodle.de

By default, the test run in a `isolated` context. This mean that an instance of mongo it going to be started before each test example (on the port 12345) and stopped it after each.

If you change to a `sequential` context, the instance of mongo it going to be started only once before the test suite and stopped it after that. If you want to clean the database after each example you can add the trait [CleanAfterExample](https://github.com/athieriot/specs2-embedmongo/tree/master/src/main/scala/com/github/athieriot/CleanAfterExample.scala).

You can change thow default values:

 * MongoDB port by overriding embedConnectionPort()
 * MongoDB version by overriding embedMongoDBVersion()

# What it looks like?

 - [Sample I](https://github.com/athieriot/specs2-embedmongo/tree/master/src/test/scala/com/github/athieriot/EmbedConnectionSpec.scala)

 - [Sample II](https://github.com/athieriot/specs2-embedmongo/tree/master/src/test/scala/com/github/athieriot/CleanAfterExampleSpec.scala)

# Add as dependency

Modify `project/Build.scala` and add

`"com.github.athieriot" %% "specs2-embedmongo" % "0.6.0"`


[![Bitdeli Badge](https://d2weczhvl823v0.cloudfront.net/athieriot/specs2-embedmongo/trend.png)](https://bitdeli.com/free "Bitdeli Badge")

