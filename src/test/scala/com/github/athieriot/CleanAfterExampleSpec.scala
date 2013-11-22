package com.github.athieriot

import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import org.specs2.mutable.Specification

@RunWith(classOf[JUnitRunner])
class CleanAfterExampleSpec extends Specification with EmbedConnection with CleanAfterExample {

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