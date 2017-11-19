package com.github.athieriot

import de.flapdoodle.embed._
import process.runtime.Network
import mongo._
import config._
import distribution._
import org.specs2.specification.core._
import org.specs2.mutable.{Specification, SpecificationLike}
import org.specs2.main.Arguments

trait EmbedConnection extends Specification { self: SpecificationLike =>
  isolated

  override def sequential: Arguments = args(isolated = false, sequential = true)

  override def isolated: Arguments = args(isolated = true, sequential = false)

  //Override this method to personalize testing port
  def embedConnectionPort: Int = { 12345 }

  //Override this method to personalize MongoDB version
  def embedMongoDBVersion: Version.Main = { Version.Main.PRODUCTION }

  lazy val network = new Net(embedConnectionPort, Network.localhostIsIPv6)

  lazy val mongodConfig: IMongodConfig = new MongodConfigBuilder()
    .version(embedMongoDBVersion)
    .net(network)
    .build

  lazy val runtime: MongodStarter = MongodStarter.getDefaultInstance

  lazy val mongodExecutable: MongodExecutable = runtime.prepare(mongodConfig)

  override def map(fs: => Fragments) = startMongo ^ fs ^ stoptMongo

  private def startMongo() = {
    step(mongodExecutable.start)
  }

  private def stoptMongo() = {
    step(mongodExecutable.stop())
  }
}
