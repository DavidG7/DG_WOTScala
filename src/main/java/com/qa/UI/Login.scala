/*package com.qa.UI

import java.util.Scanner
import com.qa.Entities.Employee
import com.qa.Connectors.MongoConnector

/**
 * @author dgordon

 */
/**Login UI **/
object Login {
 
  val mongo = new MongoConnector
  val employees = mongo.employeeMongoData()
  val scan  = new Scanner(System.in)
  buildLogin(true)
  
  /** firstTime is used to differentiate between first time login, and failed login**/
  def buildLogin(firstTime:Boolean) {
     Gnome.printGnome()
    if(firstTime){
      println()
      println()
      println("WELCOME TO NBGARDENS WAREHOUSE ORDER TRACKING SYSTEM")
      println()
      println("Please Login")
    }else{
     buildLoginAfterFailure()
    }
    
    def buildLoginAfterFailure(){
      println("")
      println("Ensure correct credintials before retrying")
      buildLogin(true)
    }
    
    println("Username:")
    val username = scan.nextLine()
    println("Password:")
    val password = scan.nextLine()
    loginBridge(validateLogin(username, password))
 }
  
  
/* Validates user by recursively comparing the entered credintials 
 * with each employee using the validateIndividual function  
 */
 def validateLogin(username:String, password:String):Boolean = {
    
    var count = 0
  
    
    def validateIndividual(employee:Employee):Boolean = {
    
       println()
      if(employee.getEmployeeUserName().equals(username)&& employee.getEmployeePassword().equals(password)){
        true
      }else{      

        count = count+1
        if(count < employees.size){
          
          
          validateIndividual(employees(count))
         
        }
        false
      }
        
    }
    
    
    
    validateIndividual(employees(count))
  }
  
 /**If user is validated go to Menu, else redbuild login with false 'firstTime' parameter**/
    def loginBridge(validated:Boolean) {

    validated match {
      case true => Menu.buildMenu(mongo)
      case false  => Login.buildLogin(false)
      case _  =>  
    }
  }
 }*/