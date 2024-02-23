package transitapp.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class AdminPanel {
    public Pane createAP(MainWindow main){
    	main.getStage().setTitle("Transit App: " + this.getClass().getSimpleName());

       /*
        Button revenue_btn = new Button("Calculate Revenue");
        Button log_btn = new Button("Show Logs");
        */
        Button end_btn = new Button("End Shift");


        
        VBox pane = new VBox();
/*
   

        revenue_btn.setFont(new Font("Times New Roman", 18));
        log_btn.setFont(new Font("Times New Roman", 18));
        */
        end_btn.setFont(new Font("Times New Roman", 18));
        /*
        revenue_btn.setOnAction(new EventHandler<ActionEvent>() {
            }
        });

        
        log_btn.setOnAction(new EventHandler<ActionEvent>() {
            }
        });
         
        
         end_btn.setOnAction(new EventHandler<ActionEvent>() {
             new Admin().endShift();
         }
     });
        */
 

        /*
        pane.getChildren().add(revenue_btn);
        VBox.setMargin(revenue_btn, new Insets(5, 5, 5,5));
        
        pane.getChildren().add(log_btn);
        VBox.setMargin(log_btn, new Insets(5, 5, 5,5));
        */
        
        pane.getChildren().add(end_btn);
        VBox.setMargin(end_btn, new Insets(5, 5, 5,5));
        
        
        return pane;
    }
}
