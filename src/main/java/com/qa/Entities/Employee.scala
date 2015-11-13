package com.qa.Entities
import scalafx.beans.property.StringProperty
import scalafx.beans.property.IntegerProperty


/**
 * @author dgordon

 */
/** Employee Entity**/
class Employee(employeeID:Int, employeeName:String, employeeUserName:String, employeePassword:String, accessLevel:Int){

  def this() = this(0,null,null,null,0)
  
  def getEmployeeID() :Int = {
    employeeID
  }
  
  def getEmployeeName() :String = {
    employeeName
  }
   
  def getEmployeeUserName() :String = {
    employeeUserName
  }
    
  def getEmployeePassword() :String = {
    employeePassword
  }
     
  def getAccessLevel() :Int = {
    accessLevel
  }
  
}
  
  
