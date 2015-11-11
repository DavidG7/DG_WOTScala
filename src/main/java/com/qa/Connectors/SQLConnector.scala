package com.qa.Connectors

/**
 * @author dgordon
 */
import java.sql.DriverManager
import java.sql.Connection
import com.qa.Entities.CustomerOrder
import com.qa.Entities.CustomerOrderLine
import com.mysql.jdbc.ResultSetImpl
import java.sql.ResultSet

 
/**
 * A Scala JDBC connection example by Alvin Alexander,
 * <a href="http://alvinalexander.com" title="http://alvinalexander.com">http://alvinalexander.com</a>
 */
class SQLConnector {
     // connect to the database named "mysql" on the localhost
    val driver = "com.mysql.jdbc.Driver"
    val url = "jdbc:mysql://localhost/wots"
    val username = "root"
    val password = "password"

   
 
    var connection:Connection = null
    
    
    
    
  def getCustomerOrderTableInfo() : Array[CustomerOrder] = {
      try {
      // make the connection
      Class.forName(driver)
      connection = DriverManager.getConnection(url, username, password)
    }catch {
      case e => e.printStackTrace
       
    }
      val statement = connection.createStatement()
      val resultSet = statement.executeQuery("SELECT * FROM customerorder")
      var count = 0;
      val customerOrders = new Array[CustomerOrder](5)
      while ( resultSet.next() ) {
        customerOrders(count) = new CustomerOrder(resultSet.getString("customerOrderID").toInt, resultSet.getString("customerID").toInt, resultSet.getString("customerOrderDate"),
            resultSet.getString("customerOrderStatus"), resultSet.getString("employeeID").toInt)
        count = count+1
      }
     connection.close()
    customerOrders
  }
  
  
  
     
  def getCustomerOrderLineTableInfo() : Array[CustomerOrderLine] = {
      try {
      // make the connection
      Class.forName(driver)
      connection = DriverManager.getConnection(url, username, password)
    }catch {
      case e => e.printStackTrace
       
    }
      val statement = connection.createStatement()
      val resultSet = statement.executeQuery("SELECT * FROM customerorderline")
      var count = 0;
      val customerOrderLines = new Array[CustomerOrderLine](8)
      while ( resultSet.next() ) {
         customerOrderLines(count) = new CustomerOrderLine(resultSet.getString("customerOrderID").toInt, resultSet.getString("productID").toInt,
            resultSet.getString("quantity").toInt)
        count = count+1
      }
    connection.close()
    customerOrderLines
  }
  
      
  def updateCustomerOrderTable (customerID: Int, state:String, employeeID: Int){

      try {
      // make the connection
      Class.forName(driver)
      connection = DriverManager.getConnection(url, username, password)
    }catch {
      case e => e.printStackTrace
       
    }
      /*val statement = connection.createStatement()
      statement.executeQuery("UPDATE customerorder SET employeeID = 1, customerOrderStatus = " + "Accepted" + " WHERE customerOrderID = 1")*/
      val query = "UPDATE customerorder SET employeeID = " + employeeID +", customerOrderStatus = " + "'" + state + "'"   + 
      "  WHERE customerOrderID = " + customerID;
      val preparedStmt = connection.prepareStatement(query);
   
      // execute the java preparedstatement
      preparedStmt.executeUpdate();
      connection.close()

  }
  
}