package com.qa.textui;


import java.util.Scanner
import com.qa.entity.Employee
import com.qa.connector.MongoConnector
import com.qa.controller.LoginController

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
    loginBridge(LoginController.validateLogin(username, password))
 }
  
  
  
 /**If user is validated go to Menu, else redbuild login with false 'firstTime' parameter**/
    def loginBridge(validated:Boolean) {

    validated match {
      case true => Menu.buildMenu(mongo)
      case false  => Login.buildLogin(false)
      case _  =>  
    }
  }
 }