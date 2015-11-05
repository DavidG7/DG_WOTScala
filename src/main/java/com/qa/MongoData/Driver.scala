package com.qa.MongoData

/**
 * @author dgordon
 */

/**
 * @author dgordon
 */
object Driver {
  
  def main(args: Array[String]){
     val mongo = new MongoDataTest
     println(mongo.employeeMongoData()(0).getEmployeeName())
  }
}