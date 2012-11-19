package com.github.athieriot

import de.flapdoodle.embed.mongo._
import config.MongodConfig
import distribution.Version
import org.specs2.specification.BeforeAfterExample

trait EmbedConnection extends BeforeAfterExample {

  //Override this method to personalize testing port
  def embedConnectionPort(): Int = { 12345 }

  //Override this method to personalize MongoDB version
  def embedMongoDBVersion(): Version = { Version.V2_2_1 }

  lazy val runtime: MongodStarter = MongodStarter.getDefaultInstance
  lazy val mongodExe: MongodExecutable = runtime.prepare(new MongodConfig(embedMongoDBVersion(), embedConnectionPort(), true))
  lazy val mongod: MongodProcess = mongodExe.start()

  def before() {
    mongod
  }

  def after() {
    mongod.stop()
    mongodExe.cleanup()
  }
}
