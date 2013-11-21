package com.github.athieriot

import com.mongodb.casbah.Imports._
import org.bson.types.ObjectId
import com.novus.salat.global._
import com.novus.salat._
import com.novus.salat.dao._

case class Model(id: ObjectId = new ObjectId, name: String)

object Model extends SalatDAO[Model, ObjectId](collection = MongoConnection("localhost", 12345)("test")("model")) {}