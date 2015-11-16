package com.qa.View

/**
 * @author dgordon
 */
import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.control._
import scalafx.scene.layout.VBox
import scalafx.application.JFXApp
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.control.Button
import scalafx.scene.control.Label
import scalafx.scene.layout.VBox
import scalafx.scene.Scene
import com.qa.View.LoginView


object MenuView extends JFXApp {
    

 
  def buildMenu(): Scene ={
 

    val scene = new Scene{

      content = new VBox{
        padding = Insets(100)
        
        children = Seq(new Label{
          text = "Menu"
          style = "-fx-font-size: 24pt"
        

        }
        
        
        ,new VBox {
          children = Seq(
            new Button{
              text = "Customer Orders"
               margin=Insets(10,10,10,0)
              style = "-fx-font-size: 12pt"
              onAction = handle{
                   ViewMain.stage.scene_=(CustomerOrderView.buildCustomerOrder())
                
              }
            },
         
             new Button{
              text = "Products"
              margin=Insets(10,10,10,0)
              style = "-fx-font-size: 12pt"
              onAction = handle{
                 ViewMain.stage.scene_=(ProductView.buildProduct())
                
              }
            },
            new Button{
              text = "Log Out"
              style = "-fx-font-size: 12pt"
               margin=Insets(10,10,10,0)
              onAction = handle{
               ViewMain.stage.scene_=(LoginView.buildLogin())
              }
            }
          )
        }
        )
      }
      content 
    }
   scene
  }
}