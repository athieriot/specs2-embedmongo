package com.github.athieriot

import com.mongodb.{MongoClient, ServerAddress}
import org.specs2.specification.AfterEach

import scala.collection.JavaConversions._

trait CleanAfterEach extends AfterEach { self: EmbedConnection =>

  lazy val mongoClient = new MongoClient(new ServerAddress(network.getServerAddress, network.getPort))

  def after() {
    mongoClient.listDatabaseNames().toList.map(name => mongoClient.getDatabase(name)).foreach(_.drop())
  }

}