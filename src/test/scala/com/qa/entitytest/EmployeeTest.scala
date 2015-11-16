package com.qa.entitytest

import com.qa.entity.Employee

/**
 * @author dgordon
 */
class EmployeeTest extends TestBase{
   def employeeTest{
     "A Employee Entity" should " be initialised with all the correct values" in
    {
      val emp = new Employee(1,"Harry Styles","HS117","Gnomes4LIFE!",1)
      emp.employeeID should be (1)
      emp.employeeName should be ("Harry Styles")
      emp.employeeUserName should be ("HS117")
      emp.employeePassword should be ("Gnomes4LIFE!")
      emp.accessLevel should be (1)
    }
    
  }
   employeeTest
}