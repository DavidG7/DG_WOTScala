package com.qa.entitytest

import com.qa.entity.Product

/**
 * @author dgordon
 */
class ProductTest extends TestBase {
  
  def productTest{
     "A Product Entity" should " be initialised with all the correct values" in
    {
      val prod = new Product(1,"Red Gnome","A Small red gnome", "GNOME", 12, "4/5", 177, false,false,false)
      prod.productID should be (1)
      prod.productName should be ("Red Gnome")
      prod.productDescription should be ("A Small red gnome")
      prod.category should be ("GNOME")
      prod.price should be (12)
      prod.rating should be ("4/5")
      prod.stockLevel should be (177)
      prod.porousware should be (false)
      prod.discontinued should be (false)
      prod.onOffer should be (false)
    }
    
  }
  
  productTest
}