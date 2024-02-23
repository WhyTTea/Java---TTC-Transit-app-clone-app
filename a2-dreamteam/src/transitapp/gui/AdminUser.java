package transitapp.gui;

import javafx.scene.control.TextField;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import transitapp.Admin;
import javafx.scene.layout.GridPane;


public class AdminUser {
    public Pane createAdmin(MainWindow main){
    	main.getStage().setTitle("Transit App: " + this.getClass().getSimpleName());

        Label admin_lbl = new Label("Admin:");
        Label firstName_lbl = new Label("First Name:");
        TextField first = new TextField();
        Label lastName_lbl = new Label("First Name:");
        TextField last = new TextField();
        Button start_btn = new Button("Start Shift");


        BorderPane Pane = new BorderPane();
        GridPane chosingPanel = new GridPane();

        admin_lbl.setFont(new Font("Times New Roman", 15));
        firstName_lbl.setFont(new Font("Times New Roman", 10));
        lastName_lbl.setFont(new Font("Times New Roman", 10));
        
        start_btn.setFont(new Font("Times New Roman", 15));
        start_btn.setOnAction(new EventHandler<ActionEvent>() {
        	
		        	String f = first.getText();
		        	String l = last.getText();
		        	Admin admin = new Admin(f,l);
		        	public void startShift() { 
		        		admin.startShift();
		        	}
		        	
		            @Override
		            public void handle(ActionEvent actionEvent) {
		                main.perform(new AdminPanel().createAP(main));
		                this.startShift();
		            }
		        
		        });

        
        Pane.setRight(chosingPanel);
       
        chosingPanel.add(admin_lbl,0,0,0,0);
       // GridPane.setMargin(admin_lbl, new Insets(5, 5, 5,5));
        
        chosingPanel.add(firstName_lbl,0,1,0,0);
       // GridPane.setMargin(admin_btn, new Insets(5, 5, 5,5));
        /*
        first.setPromptText("Enter your first name.");
        first.setPrefColumnCount(10);
        first.getText();
        chosingPanel.setConstraints(first, 0, 0);
        grid.getChildren().add(name);
        */
        chosingPanel.add(first,1,0);
        
        
        chosingPanel.add(lastName_lbl,0,2,0,0);
        //VBox.setMargin(cardHolder_btn, new Insets(5, 5, 5,5));
        
        chosingPanel.add(last, 1, 2);
        
        return Pane;
    }

}
