

package com.qa.controllertest

import com.qa.controller.LoginController
import com.qa.entitytest.TestBase
/**
 * @author dgordon
 **/

class LoginControllerTest extends TestBase{
  
  def validateLoginTest{
    "Calling validateLogin" should "return true if the credintials given match that of an employee at position 0" in
    {
      // Instantiate class and run test
      LoginController.validateLogin("JS117", "Gnomes4LIFE!")
    }
    
    "Calling validateLogin" should "return true if the credintials given match that of an employee at NOT position 0" in
    {
      // Instantiate class and run test
      LoginController.validateLogin("BBGun", "PutYourBackIntoIt")
    }
    
      "Calling validateLogin" should "return false if the credintials given do not match that of any employee" in
    {
      // Instantiate class and run test
      LoginController.validateLogin("XXX", "XXXX")
    }
  }
   
  //run tests
  validateLoginTest
}
