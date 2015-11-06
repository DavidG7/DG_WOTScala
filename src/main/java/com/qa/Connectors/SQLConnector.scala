package com.qa.Connectors

/**
 * @author dgordon
 */
import java.sql.DriverManager
import java.sql.Connection
import com.qa.Entities.CustomerOrder
 
/**
 * A Scala JDBC connection example by Alvin Alexander,
 * <a href="http://alvinalexander.com" title="http://alvinalexander.com">http://alvinalexander.com</a>
 */
class SQLConnector[E] {
 
  def getTableInfo(table:String) : Array[E] = {
    // connect to the database named "mysql" on the localhost
    val driver = "com.mysql.jdbc.Driver"
    val url = "jdbc:mysql://localhost/wots"
    val username = "root"
    val password = "password"
 
    // there's probably a better way to do this
    var connection:Connection = null
 
    try {
      // make the connection
      Class.forName(driver)
      connection = DriverManager.getConnection(url, username, password)
 
      // create the statement, and run the select query
      val statement = connection.createStatement()
      val resultSet = statement.executeQuery("SELECT * FROM customerOrder")
      var count = 0;
     
    
      while ( resultSet.next() ) {
        count.+(1)
      }
       val customerOrders = new Array[CustomerOrder](count)
       count = 0
      while ( resultSet.next() ) {
        
        customerOrders(count) = new CustomerOrder(resultSet.getString("customerOrderID").toInt, resultSet.getString("customerID").toInt, 
            resultSet.getString("customerOrderStatus"), resultSet.getString("customerOrderDate"), resultSet.getString("customerOrderTotal").toDouble)
        count.+(1)
      }
       
  
    } catch {
      case e => e.printStackTrace
    }
    connection.close()
    customerOrders
  }
 
}