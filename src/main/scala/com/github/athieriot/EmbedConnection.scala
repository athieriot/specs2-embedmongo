package com.github.athieriot

import de.flapdoodle.embedmongo._
import config.MongodConfig
import distribution.Version
import org.specs2.specification.{AfterExample, BeforeExample}

trait EmbedConnection extends BeforeExample with AfterExample {

  //Override this method to personalize testing port
  def embedConnectionPort(): Int = { 12345 }

  //Override this method to personalize MongoDB version
  def embedMongoDBVersion(): Version = { Version.V2_1_1 }

  lazy val mongoDBRuntime: MongoDBRuntime = MongoDBRuntime. getDefaultInstance
  lazy val mongodExe: MongodExecutable = mongoDBRuntime.prepare(new MongodConfig(embedMongoDBVersion(), embedConnectionPort(), true))
  lazy val mongod: MongodProcess = mongodExe.start()

  def before() {
    mongod
  }

  def after() {
    mongod.stop()
    mongodExe.cleanup()
  }
}
