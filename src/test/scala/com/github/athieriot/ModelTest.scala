package com.github.athieriot

import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import org.specs2.mutable.Specification
import com.mongodb.casbah.Imports._
import org.bson.types.ObjectId
import com.novus.salat.global._
import com.novus.salat._
import com.novus.salat.dao._

@RunWith(classOf[JUnitRunner])
class ModelTest extends Specification with EmbedConnection {

  override def embedConnectionPort() = { 12345 }

  "Embed database" should {
    "be able to save a Model I" in {
      Model.save(Model(name = "test"))
      Model.count() must be_==(1)
    }

    "be able to save a Model II" in {
      Model.save(Model(name = "test"))
      Model.count() must be be_== (1)
    }

    "be able to save a Model III" in {
      Model.save(Model(name = "test"))
      Model.count() must be be_== (1)
    }

    "be able to save a Model IV" in {
      Model.save(Model(name = "test"))
      Model.count() must be be_== (1)
    }

    "be able to save a Model V" in {
      Model.save(Model(name = "test"))
      Model.count() must be be_== (1)
    }
  }
}

