package com.qa.Connectors

import java.util.Scanner
import java.io.Console
import com.qa.Entities.Employee


/**
 * @author dgordon
 */

/**
 * @author dgordon
 */
object Driver {
   val mongo = new MongoConnector
   val employees = mongo.employeeMongoData()
    
  def main(args: Array[String]){
     buildLanding(true)
  }
  
  def buildLanding(firstTime:Boolean) {
    if(firstTime){
      println("/** Welcome to NBGardens Warehouse Order Tracking System **/")
      println()
      println("Please Login")
    }else{
      println("")
      println("Login Unsuccessfull")
      println("Ensure correct credintials before retrying")
    }
    println("Username:")
    val scan  = new Scanner(System.in)
    val username = scan.nextLine()
    println("Password:")
    val password = scan.nextLine()
    loginBridge(validate (username,password))
 }
  
  def validate(username:String, password:String):Boolean = {
    
    val count = 0
  
    
    def validateIndividual(employee:Employee):Boolean = {
     
      if(employee.getEmployeeUserName().equals(username)&& employee.getEmployeePassword().equals(password)){
        true
      }else{
        if(count < employees.size && employees.size >1){
          println(count)
          validateIndividual(employees(count.+(1)))
        }
        false
      }
        
    }
    
    validateIndividual(employees(0))
  }
  
  
  def loginBridge(validated:Boolean) {
    validated match {
      case true  => menu()
      case false  => buildLanding(false)
      case _  =>  
    }
  }
  
  
  def menu(){
    println("Welcome" + employees(0).getEmployeeName())
    println("/**MENU**/")
    println("(1) Customer Orders ")
    //println("Welcome" + employees(0).getEmployeeName())
    
  }
}