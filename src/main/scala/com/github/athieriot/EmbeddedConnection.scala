package com.github.athieriot

import de.flapdoodle.embedmongo._
import config.MongodConfig
import distribution.Version
import org.specs2.specification.{AfterExample, BeforeExample}

trait EmbeddedConnection extends BeforeExample with AfterExample {

  //Override this method to personalize testing port
  def embeddedConnectionPort(): Int = { 12345 }

  //Override this method to personalize MongoDB version
  def embeddedMongoDBVersion(): Version = { Version.V2_1_1 }

  var _mongodExe: MongodExecutable = null
  var _mongod: MongodProcess = null

  def before() {
    val runtime: MongoDBRuntime = MongoDBRuntime. getDefaultInstance
    _mongodExe = runtime.prepare(new MongodConfig(embeddedMongoDBVersion(), embeddedConnectionPort(), true))
    _mongod = _mongodExe.start()
  }

  def after() {
    _mongod.stop()
    _mongodExe.cleanup()
  }
}
