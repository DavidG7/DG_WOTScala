package com.qa.entitytest

import com.qa.entity.CustomerOrder


/**
 * @author dgordon
 */
class CustomerOrderTest extends TestBase{
 
  def customerOrderTest{
     "A CustomerOrder Entity" should " be initialised with all the correct values" in
    {
      val cO = new CustomerOrder(1,100,"2015-11-1","Confirmed",1)
      cO.customerOrderID should be(1)
      cO.customerID should be (100)
      cO.customerOrderDate should be ("2015-11-1")
      cO.customerOrderStatus should be ("Confirmed")
      cO.employeeID should be (1)
    }
    
  }
  
  customerOrderTest
}