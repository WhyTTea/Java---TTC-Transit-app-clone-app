package transitapp.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import transitapp.Cardholder;

public class CardUser {
	 public Pane createCH(MainWindow main){
	    	main.getStage().setTitle("Transit App: " + this.getClass().getSimpleName());

	        Label ch_lbl = new Label("Card Holder:");
	        Label firstName_lbl = new Label("First Name:");
	        TextField first = new TextField();
	        Label lastName_lbl = new Label("First Name:");
	        TextField last = new TextField();
	        Label email_lbl = new Label("Email:");
	        TextField email = new TextField();
	        
	        Button enter_btn = new Button("Enter");
	        Button exit_btn=new Button("Exit");


	        BorderPane Pane = new BorderPane();
	        GridPane chosingPanel = new GridPane();

	        ch_lbl.setFont(new Font("Times New Roman", 15));
	        firstName_lbl.setFont(new Font("Times New Roman", 10));
	        lastName_lbl.setFont(new Font("Times New Roman", 10));
	        email_lbl.setFont(new Font("Times New Roman", 10));
	        
	        enter_btn.setFont(new Font("Times New Roman", 10));
	        exit_btn.setFont(new Font("Times New Roman", 10));
	        

	        enter_btn.setOnAction(new EventHandler<ActionEvent>() {
	        	
	        	String f = first.getText();
	        	String l = last.getText();
	        	String e = email.getText();
	        	
	        	Cardholder ch = new Cardholder(f,l,e,null);
	        	public void enter() { 
	        	    
	        	
	            @Override
	            public void handle(ActionEvent actionEvent) {
	                main.perform(new AdminPanel().createAP(main));
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
