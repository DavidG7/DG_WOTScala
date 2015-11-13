package com.qa.Utility

import com.qa.Entities.Employee
import com.qa.Connectors.MongoConnector

/**
 * @author dgordon
 */
object LoginVerifier {
  

  
  def validateLogin(username:String, password:String, employees:Array[Employee]):Boolean = {
    
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
}