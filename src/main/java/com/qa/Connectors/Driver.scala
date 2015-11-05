package com.qa.Connectors

import java.util.Scanner
import java.io.Console


/**
 * @author dgordon
 */

/**
 * @author dgordon
 */
object Driver {
  
  def main(args: Array[String]){
    // val mongo = new MongoConnector
     //println(mongo.employeeMongoData()(0).getEmployeeName())
     BuildApplication()
  }
  
  def BuildApplication() {
    println("/** Welcome to NBGardens Warehouse Order Tracking System **/")
    println()
    println("Please Login")
    println("Username:")
    val scan  = new Scanner(System.in)
    val username = scan.nextLine()
    println("Password:")
    val password = scan.nextLine()
    menu(validate (username,password))
    
  }
  
  def validate(username:String, password:String):Boolean = {
    val validated = false
    val mongo = new MongoConnector
    val employees = mongo.employeeMongoData()
    validated
  }
  
  
  def menu(validated:Boolean) {
    
  }
}