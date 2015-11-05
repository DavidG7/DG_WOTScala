package com.qa.Entities
import scalafx.beans.property.StringProperty
import scalafx.beans.property.IntegerProperty


/**
 * @author dgordon
 */
class Employee(employeeID:Int, employeeName:String, employeeUserName:String, employeePassword:String, accessLevel:Int){
  
  val employeeID_ = new StringProperty(this, "employeeID_", employeeID.toString())
  val employeeName_ = new StringProperty(this, "employeeName_", employeeName)
  val accessLevel_ = new StringProperty(this, "accessLevel_", accessLevel.toString())
  
  
  
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
  
  
