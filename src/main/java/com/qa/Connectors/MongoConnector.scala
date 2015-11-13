package com.qa.Connectors

import com.mongodb.casbah.MongoClient
import com.qa.Entities.Employee
import com.qa.Entities.Employee
import com.qa.Entities.Employee
import java.util.logging.Logger
import com.qa.Entities.Product
import java.lang.Double
import com.mongodb.casbah.commons.MongoDBObject





/**
 * @author dgordon
 */
class MongoConnector {

  val mongoClient = MongoClient("localhost", 27017)
  val db = mongoClient("WOTS")
  
  
  
   def getMongoData[T](document:T):Array[T] = {
    
    if(document.isInstanceOf[Employee]){
        employeeMongoData().asInstanceOf[Array[T]]
     }else if(document.isInstanceOf[Product]){
        productMongoData().asInstanceOf[Array[T]]
     }else{
       productMongoData().asInstanceOf[Array[T]]
     }
    
  }
  
  
       //**Returns all products in MongoDB**/
      def productMongoData() : Array[Product]  = {
        val coll = db("Product")
        val temp = new Array[Product](coll.count())
        val allDocs = coll.find()
        var count = 0
      
        for(doc <- allDocs) {
           val product = new Product(Double.parseDouble(doc.get("_id").toString()), doc.get("productName").toString(), doc.get("productDescription").toString(),  doc.get("category").toString(),
             Double.parseDouble(doc.get("price").toString()),doc.get("rating").toString(),Double.parseDouble(doc.get("stockLevel").toString()), false,false,false)
           temp(count) = product
           count = count + 1
        }
        temp
      }
    
     //**Returns all Employees in MongoDB**/
      def employeeMongoData() : Array[Employee]  = {
        val coll = db("Employee")
        val temp = new Array[Employee](coll.count())
        val allDocs = coll.find()
        var count = 0
    
        for(doc <- allDocs) {
       
          val employee = new Employee(Integer.parseInt(doc.get("_id").toString().substring(0,1)),doc.get("employeeName").toString(),doc.get("employeeUserName").toString(),
            doc.get("employeePassword").toString(),Integer.parseInt(doc.get("accessLevel").toString().substring(0,1)))
          temp(count) = employee
          count = count + 1
        }
        temp
      }
   
   /**Updates Product Mongo Table when Cus. Orders are picked or when stock is removed due to damage**/
    def updateProductStock(productID:Int, newStock:Double){
      
       val coll = db("Product")
      val query = MongoDBObject("_id"-> productID)
      val update = MongoDBObject(
       "$set" -> MongoDBObject("stockLevel" -> newStock))
      coll.findAndModify(query,update)

    }
  

 
    
}