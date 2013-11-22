package com.github.athieriot

import scala.collection.JavaConversions._
import com.mongodb.{ MongoClient, ServerAddress }
import org.specs2.specification.AfterExample

trait CleanAfterExample extends AfterExample {
  self: EmbedConnection =>

  lazy val mongoClient = new MongoClient(new ServerAddress(network.getServerAddress(), network.getPort()));

  def after() {
    mongoClient.getDatabaseNames().map { mongoClient.getDB(_) }.foreach { _.dropDatabase() }
  }

}