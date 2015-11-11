package com.qa.Connectors

import java.util.Scanner
import java.io.Console
import com.qa.Entities.Employee
import com.qa.Utility.NumberFormatter
import com.qa.Utility.NumberFormatter
import com.qa.Utility.State
import com.qa.UI.Gnome
import com.sun.javafx.scene.control.skin.ButtonBarSkin.Spacer
import com.qa.Utility.Formatting
import com.qa.Utility.Help
import scala.collection.mutable.Stack
import com.qa.UI.Login
import scala.collection.mutable.LinkedList
import scala.collection.mutable.MutableList
import com.qa.UI.Menu
import com.qa.UI.ProductUI
import com.mongodb.casbah.commons.Logger
import java.util.logging.Level

/**
 * @author dgordon
 */

/**
 * @author dgordon
 */
object Driver {
   Gnome.printGnome()
 
   
  def main(args: Array[String]){

     //val mongoLogger = Logger.apply(Level.SEVERE)
//mongoLogger.setLevel(Level.SEVERE); // e.g. or Log.WARNING, etc.
    // val root = (Logge)LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
    // root.setLevel(Level.INFO);
     Login
       //val mongo = new MongoConnector
       //val products = mongo.productMongoData()
      // ProductUI.buildProducts(products)
   
  }
  
}