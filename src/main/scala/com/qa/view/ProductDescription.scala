package com.qa.view

import scalafx.scene.control.Label
import scalafx.geometry.Insets
import com.qa.controller.ProdController
import scalafx.scene.control.TextField
import scalafx.scene.Node
import scalafx.scene.control.Button
import scalafx.Includes._

/**
 * @author dgordon
 */
object ProductDescription {
  
      
      def buildProductDescription():Seq[Node] = {
        
        val brokenStock = new TextField{
          text = "0"
          margin= Insets(1,1,1,40)
        }
        
        val sequence = Seq(new Label{
          text = "Product ID: " + ProdController.getProductById(ProdController.activeProductID).productID
          style = "-fx-font-size: 12pt"
           margin= Insets(25,1,1,40)
        },
        new Label{
          text = "Product Name: " + ProdController.getProductById(ProdController.activeProductID).productName
          style = "-fx-font-size: 12pt"
           margin= Insets(1,1,1,40)
        },
        new Label{
          text = "Product Category: " + ProdController.getProductById(ProdController.activeProductID).category
          style = "-fx-font-size: 12pt"
           margin= Insets(1,1,1,40)
        },
        new Label{
          text = "Product Description: " + ProdController.getProductById(ProdController.activeProductID).productDescription
          style = "-fx-font-size: 12pt"
           margin= Insets(1,1,1,40)
        },
        new Label{
          text = "Product Stock Level: " + ProdController.getProductById(ProdController.activeProductID).stockLevel.toInt
          style = "-fx-font-size: 12pt"
           margin= Insets(1,1,1,40)
        },
        new Label{
          text = "Product Price: £"  + ProdController.getProductById(ProdController.activeProductID).price.toInt
          style = "-fx-font-size: 12pt" 
           margin= Insets(1,1,1,40)
        },
        new Label{
          text = "Product Porousware: " + ProdController.getProductById(ProdController.activeProductID).porousware
          style = "-fx-font-size: 12pt"
           margin= Insets(1,1,1,40)
        },
        new Label{
          text = "Product On Offer: " +  ProdController.getProductById(ProdController.activeProductID).onOffer
          style = "-fx-font-size: 12pt"
           margin= Insets(1,1,1,40)
        },
        new Label{
          text = "Enter number of damaged goods to remove" 
          style = "-fx-font-size: 12pt"
          margin= Insets(250,1,1,40)
        },
         brokenStock,
         
         new Button{
              text = "Remove damaged goods"
              margin=Insets(10,10,10,40)
              style = "-fx-font-size: 12pt"
              onAction = handle{
                 val numOfBrokenStock = brokenStock.text.getValue
                ProdController.removeStock(numOfBrokenStock)
                
              }
            }
        )
        sequence
       
      }
}