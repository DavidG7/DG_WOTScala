package com.qa.Connectors

/**
 * @author dgordon
 */
import java.sql.DriverManager
import java.sql.Connection
import com.qa.Entities.CustomerOrder
import com.mysql.jdbc.ResultSetImpl
import java.sql.ResultSet

 
/**
 * A Scala JDBC connection example by Alvin Alexander,
 * <a href="http://alvinalexander.com" title="http://alvinalexander.com">http://alvinalexander.com</a>
 */
class SQLConnector {
 
  def getTableInfo() : Array[CustomerOrder] = {
    // connect to the database named "mysql" on the localhost
    val driver = "com.mysql.jdbc.Driver"
    val url = "jdbc:mysql://localhost/wots"
    val username = "root"
    val password = "password"

   
 
    var connection:Connection = null
    
 
    try {
      // make the connection
      Class.forName(driver)
      connection = DriverManager.getConnection(url, username, password)
    }catch {
      case e => e.printStackTrace
       
    }
      
      val statement = connection.createStatement()
      val resultSet = statement.executeQuery("SELECT * FROM customerOrder")
      var count = 0;
      
      
      
      val customerOrders = new Array[CustomerOrder](5)
     
      while ( resultSet.next() ) {
 
        
        customerOrders(count) = new CustomerOrder(resultSet.getString("customerOrderID").toInt, resultSet.getString("customerID").toInt, 
            resultSet.getString("customerOrderStatus"), resultSet.getString("customerOrderDate"), resultSet.getString("customerOrderTotal").toDouble)
     
        count = count+1
        
      
      }
       
    connection.close()
    customerOrders
  }
}