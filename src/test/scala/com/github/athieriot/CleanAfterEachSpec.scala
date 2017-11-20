package com.github.athieriot

import org.specs2.mutable.Specification

class CleanAfterEachSpec extends Specification with EmbedConnection with CleanAfterEach with MongoInit {
  sequential

  "Embed database" should {
    "be able to save a Model I" in {
      this.dbCollection.insertOne(this.testObject)
      this.dbCollection.count() must be_== (1)
    }

    "be able to save a Model II" in {
      this.dbCollection.insertOne(this.testObject)
      this.dbCollection.count() must be be_== (1)
    }

    "be able to save a Model III" in {
      this.dbCollection.insertOne(this.testObject)
      this.dbCollection.count() must be be_== (1)
    }

    "be able to save a Model IV" in {
      this.dbCollection.insertOne(this.testObject)
      this.dbCollection.count() must be be_== (1)
    }

    "be able to save a Model V" in {
      this.dbCollection.insertOne(this.testObject)
      this.dbCollection.count() must be be_== (1)
    }
  }
}