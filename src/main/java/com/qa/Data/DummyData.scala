package com.qa.Data
import com.qa.Entities.Employee
import com.mongodb.casbah.Imports._

/**
 * @author dgordon
 */
object DummyData {
  
  def main(args: Array[String]){
    //val mongoClient = MongoClient("localhost", 27017)
    val employee = new Employee(1, "Jim Styne", "js7" , "I like gnonmes!", 1)
    println(employee.getEmployeeName());
    
  }
}