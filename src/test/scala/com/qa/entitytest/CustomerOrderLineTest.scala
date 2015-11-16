package com.qa.entitytest

import com.qa.entity.CustomerOrderLine

/**
 * @author dgordon
 */
class CustomerOrderLineTest extends TestBase{
  
   def customerOrderLineTest{
     "A CustomerOrderLine Entity" should " be initialised with all the correct values" in
    {
      val cOLine = new CustomerOrderLine(1,4,5)
      cOLine.customerOrderID should be(1)
      cOLine.productID should be (4)
      cOLine.quantity should be (5)
    }
    
  }
   
   customerOrderLineTest
}