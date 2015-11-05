package com.qa.Data
import com.qa.Entities.Employee
import com.mongodb.casbah.Imports._
import com.qa.MongoData.MongoDataTest

/**
 * @author dgordon
 */
object DummyData {
  
  def main(args: Array[String]){
 
   /* val mongoClient = MongoClient("localhost", 27017)
    val db = mongoClient("WOTS")
    val coll = db("Employee")
    val temp:Array[Employee] = new Array[Employee](3)
    val allDocs = coll.find()
    var count:Int = 0
    println( allDocs )
     for(doc <- allDocs) {
       count+.1
       //val employee = new Employee((doc.get("_id"),doc.get("employeeName"),doc.get("employeeUserName"),doc.get("employeePassword"),doc.get("accessLevl"))
       val employee = new Employee(Integer.parseInt(doc.get("_id").toString().substring(0,1)),doc.get("employeeName").toString(),doc.get("employeeUserName").toString(),
           doc.get("employeePassword").toString(),Integer.parseInt(doc.get("accessLevel").toString().substring(0,1)))
       temp(count) = employee
     }
     println(temp(0).getEmployeeName());*/
    
     val mongo = new MongoDataTest
     println(mongo.employeeMongoData()(0).getEmployeeName())
  }
}