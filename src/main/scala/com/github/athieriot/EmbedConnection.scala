package com.github.athieriot

import scala.collection.JavaConversions._
import de.flapdoodle.embed._
import process.runtime.Network
import mongo._
import config._
import distribution._
import org.specs2.specification._
import org.specs2.mutable.SpecificationLike
import com.mongodb.MongoClient
import com.mongodb.ServerAddress
import org.specs2.control.LazyParameter
import org.specs2.execute.Result
import org.specs2.execute.Executable
import org.specs2.execute.Isolable

trait EmbedConnection extends AfterExample with FragmentsBuilder {
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
    .build;

  lazy val runtime = MongodStarter.getDefaultInstance

  lazy val mongodExecutable = runtime.prepare(mongodConfig)

  lazy val mongoClient = new MongoClient(new ServerAddress(network.getServerAddress(), network.getPort()));

  override def map(fs: => Fragments) = startMongo ^ fs ^ stoptMongo

  private def startMongo() = {
    Example("Start Mongo", { mongodExecutable.start; success })
  }

  private def stoptMongo() = {
    Example("Stop Mongo", { mongodExecutable.stop; success })
  }

  def after() {
    mongoClient.getDatabaseNames().map { mongoClient.getDB(_) }.foreach { _.dropDatabase() }
  }
}
