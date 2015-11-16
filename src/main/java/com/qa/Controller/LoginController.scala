package com.qa.Controller

import com.qa.Entities.Employee
import com.qa.Connectors.MongoConnector

/**
 * @author dgordon
 */
object LoginController {
  
  val mongo = new MongoConnector
  val employees = mongo.getMongoData(new Employee)

  
  def validateLogin(username:String, password:String):Boolean = {
    
    var count = 0
  
    
    def validateIndividual(employee:Employee):Boolean = {

      if(employee.getEmployeeUserName().equals(username)&& employee.getEmployeePassword().equals(password)){
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