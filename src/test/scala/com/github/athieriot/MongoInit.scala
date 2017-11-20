package com.github.athieriot

import com.mongodb.client.MongoCollection
import com.mongodb.{MongoClient, ServerAddress}
import org.bson.Document

trait MongoInit { self: EmbedConnection =>

  def dbCollection: MongoCollection[Document] = {
    val client = new MongoClient(new ServerAddress(network.getServerAddress, network.getPort))
    client.getDatabase("test").getCollection("model")
  }

  def testObject: Document = {
    val obj = new Document()
    obj.put("name", "test")
    obj
  }

}
