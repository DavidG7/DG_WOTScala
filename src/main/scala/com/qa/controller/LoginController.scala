package com.qa.controller

import com.qa.entity.Employee
import com.qa.connector.MongoConnector

/**
 * @author dgordon
 */

/** Controller uses data from view to validate user against employees found in mongo collection**/

object LoginController {
  
  val mongo = new MongoConnector
  val employees = mongo.getMongoData(new Employee)

  
  
  /*INCORRECT RESULT, SCALA TEST REVEALS ERROR WHEN VALIDATING INCORRECT DETAILS, PASSES WHEN USERNAME
    AND PASSWORD MATCH*/
  /**Tail recursive method that validates username and password received from LoginView against passwords
   * and usernames of employees found in the mongo collection
   */
  def validateLogin(username:String, password:String):Boolean = {
    
    var count = 0
  
    
    def validateIndividual(employee:Employee):Boolean = {

      if(employee.employeeUserName.equals(username)&& employee.employeePassword.equals(password)){
        true
      }else{      
      
        count = count+ 1
        validateIndividual(employees(count))
        false
      }
     
        
    }
    
    
    
    validateIndividual(employees(count))

  }
}