package com.qa.entity


/**
 * @author dgordon

 */
/**  Class to model Employee **/
class Employee(val employeeID:Int, val employeeName:String, val employeeUserName:String, val employeePassword:String, val accessLevel:Int){

  /** Empty constructor used when defining which generic type to use **/
  def this() = this(0,null,null,null,0)
  
  
  
}
  
  
