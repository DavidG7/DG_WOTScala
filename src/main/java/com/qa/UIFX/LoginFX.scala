package com.qa.UIFX

/**
 * @author dgordon
 */
import scalafx.Includes._
import scalafx.application.{JFXApp, Platform}
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.control.ButtonBar.ButtonData
import scalafx.scene.control._
import scalafx.scene.image.{Image, ImageView}
import scalafx.scene.layout.{GridPane, VBox}
import com.qa.Entities.Employee
import com.qa.Entities.Employee
import scalafx.Includes.handle
import scalafx.Includes.observableList2ObservableBuffer
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.beans.property.StringProperty.sfxStringProperty2jfx
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.control.Button
import scalafx.scene.control.Label
import scalafx.scene.control.PasswordField
import scalafx.scene.control.TextField
import scalafx.scene.effect.DropShadow
import scalafx.scene.image.Image
import scalafx.scene.image.Image.sfxImage2jfx
import scalafx.scene.layout.HBox
import scalafx.scene.layout.VBox
import scalafx.scene.paint.Color.DarkGreen
import scalafx.scene.paint.Color.PaleGreen
import scalafx.scene.paint.Color.SeaGreen
import scalafx.scene.paint.LinearGradient
import scalafx.scene.paint.Stops
import javafx.scene.shape.Rectangle
import com.sun.prism.paint.ImagePattern
import com.qa.Connectors.MongoConnector
import com.qa.Utility.LoginVerifier
import com.qa.UIFX.Table

object LoginFX extends JFXApp {
    
  val mongo = new MongoConnector
  val employees = mongo.employeeMongoData()
  
  stage = new PrimaryStage {
    title = "Warehouse Order Tracking Application"
    
    
    scene = new Scene{
      val userField = new TextField{
          text = "JS117"
          promptText = "Username"
          margin=Insets(10)
        }
      
      var passField = new PasswordField{
          text = "Gnomes4LIFE!"
          promptText = "Password"
          margin=Insets(10)
        }
      
      content = new VBox{
        padding = Insets(100)
        
        children = Seq(new Label{
          text = "Welcome to NBGardens!"
          style = "-fx-font-size: 24pt"
           margin= Insets(1,1,1,25)
        }
        
        
        ,userField,passField,new HBox {
          children = Seq(
            new Button{
              text = "Log In"
              margin=Insets(10,10,10,250)
              style = "-fx-font-size: 12pt"
              onAction = handle{
                val user = userField.text.getValue
                val pass = passField.text.getValue
                if(LoginVerifier.validateLogin(user, pass, employees)){
                  
                  Table.build()
                }
              }
            },
            new Button{
              text = "Exit"
              style = "-fx-font-size: 12pt"
              margin=Insets(10)
              onAction = handle{
                System exit(0)
              }
            }
          )
        }
        )
      }
      content 
    }
  }
}