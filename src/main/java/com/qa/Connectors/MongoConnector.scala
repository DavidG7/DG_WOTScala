package com.qa.Connectors

import com.mongodb.casbah.MongoClient
import com.qa.Entities.Employee
import com.qa.Entities.Employee
import com.qa.Entities.Employee



/**
 * @author dgordon
 */
class MongoConnector {
  val mongoClient = MongoClient("localhost", 27017)
  val db = mongoClient("WOTS")
  
    def employeeMongoData() : Array[Employee]  = {
    val coll = db("Employee")
    val temp:Array[Employee] = new Array[Employee](coll.count())
    val allDocs = coll.find()
    var count:Int = 0
    println( allDocs )
     for(doc <- allDocs) {
       count+.1
       val employee = new Employee(Integer.parseInt(doc.get("_id").toString().substring(0,1)),doc.get("employeeName").toString(),doc.get("employeeUserName").toString(),
           doc.get("employeePassword").toString(),Integer.parseInt(doc.get("accessLevel").toString().substring(0,1)))
       temp(count) = employee
     }
    temp
  }
}