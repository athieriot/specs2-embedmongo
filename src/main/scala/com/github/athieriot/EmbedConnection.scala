package com.github.athieriot

import de.flapdoodle.embed._
import process.runtime.Network
import mongo._
import config._
import distribution._
import org.specs2.specification._
import org.specs2.mutable.SpecificationLike

trait EmbedConnection extends FragmentsBuilder {
  self: SpecificationLike =>
  sequential

  //Override this method to personalize testing port
  def embedConnectionPort(): Int = { 12345 }

  //Override this method to personalize MongoDB version
  def embedMongoDBVersion(): Version.Main = { Version.Main.PRODUCTION }

  lazy val network = new Net(embedConnectionPort, Network.localhostIsIPv6)

  lazy val mongodConfig = new MongodConfigBuilder()
    .version(embedMongoDBVersion)
    .net(network)
    .build

  lazy val runtime = MongodStarter.getDefaultInstance

  lazy val mongodExecutable = runtime.prepare(mongodConfig)

  override def map(fs: => Fragments) = startMongo ^ fs ^ stoptMongo

  private def startMongo() = {
    Example("Start Mongo", { mongodExecutable.start; success })
  }

  private def stoptMongo() = {
    Example("Stop Mongo", { mongodExecutable.stop; success })
  }
}
