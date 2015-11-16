package com.qa.view

import scalafx.scene.Scene
import scalafx.scene.layout.HBox
import scalafx.scene.layout.VBox
import scalafx.scene.control.Button
import com.qa.controller.CustomerOrderController
import scalafx.scene.text.Text
import scalafx.scene.paint.LinearGradient
import scalafx.scene.paint.Stop
import scalafx.scene.paint.Stops
import scalafx.scene.paint.Color
import scalafx.geometry.Insets
import scalafx.scene.image.Image
import scalafx.scene.image.ImageView
import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.control._
import com.qa.driver.GUIDriver





/**
 
* @author dgordon
 */
object ProductView {
   
   val vbox =  new VBox {
        
          children = ProductDescription.buildProductDescription() 
        
   }
   
  def buildProduct(): Scene ={
 
   

    val scene = new Scene{
   
      
      content = new HBox{
   
        children = Seq(new VBox {
          children = Seq(ProductTable.buildTable(),
          new Button{
              text = "Menu"
              margin=Insets(100,10,10,25)
              style = "-fx-font-size: 12pt"
              onAction = handle{
                 GUIDriver.stage.scene_=(MenuView.buildMenu())
              }
            })
        },vbox
         
        )
      }
      content 
     
    }
    
   scene
  }
  
  
  def refreshProductDescription(){
    vbox.children.clear()
    vbox.children = ProductDescription.buildProductDescription()
  }
}