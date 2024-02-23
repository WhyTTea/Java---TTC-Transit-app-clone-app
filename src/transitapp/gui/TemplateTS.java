package transitapp.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import transitapp.Cardholder;
import transitapp.Main_Frame;
import transitapp.transit_system.Template;

import java.io.IOException;

public class TemplateTS {

    private MainWindow main;
    private Pane view;
    private HBox h_view = new HBox(20);
    private static TextArea console = createConsole();

    private Font lbl_font = new Font("Times New Roman", 16);
    private Font txt_font = new Font("Times New Roman", 14);

    /**
     * Default constructor
     * Creates a main menu view with the cardholder login
     * screen on the right side
     */
    TemplateTS(MainWindow main) {
        this.main = main;
        initMenu();
        h_view.getChildren().add(new CardholderLogin(main).getView());
        finishMenu();
    }

    /**
     * Custom main menu screen
     * Displays rightSide pane on the right side
     * of the menu
     */
    TemplateTS(MainWindow main, Pane rightSide) {
        this.main = main;
        initMenu();
        h_view.getChildren().add(rightSide);
        finishMenu();
    }

    public Pane getView() {
        return this.view;
    }

    private static TextArea createConsole(){
        TextArea console = new TextArea("Logs will be printed here...\n");
        console.maxWidth(1150);
        console.minHeight(250);
        console.setFont(new Font("Times New Roman", 14));

        return console;
    }

    public void clearConsole(){
        console.clear();
    }

    public void updateConsole(String update){
        console.appendText(update + "\n");
    }

    private void initMenu(){
        main.getStage().setTitle("Transit App: Transit System");
        main.setHeight(720);
        main.setWidth(1150);

        Image map_im = new Image(getClass().getResourceAsStream("Map.png"));

        // Left side setup
        ImageView map_iv = new ImageView(map_im);
        map_iv.fitHeightProperty().setValue(450);
        map_iv.fitWidthProperty().setValue(850);

        VBox map_v = new VBox();
        map_v.setPadding(new Insets(10));
        map_v.getChildren().add(map_iv);

        h_view.getChildren().add(map_v);
    }

    private void finishMenu(){
        VBox view = new VBox(20);
        view.getChildren().add(h_view);
        view.getChildren().add(console);

        this.view = view;
    }

}

class CardholderLogin{

    private Pane view;

    private Font lbl_font = new Font("Times New Roman", 16);
    private Font txt_font = new Font("Times New Roman", 14);

    private String user_name, user_lastname, user_email, user_card;

    CardholderLogin(MainWindow main){
        // Right side setup
        Label cardholder_lbl = new Label("Cardholder");
        TextField name = new TextField();
        TextField lastname = new TextField();
        TextField email = new TextField();
        TextField card_n = new TextField();
        Button enter = new Button("Enter");

        cardholder_lbl.setFont(lbl_font);
        cardholder_lbl.setTextAlignment(TextAlignment.CENTER);
        name.setMinSize(200, 30);
        name.setFont(txt_font);
        name.setPromptText("Name");
        lastname.setMinSize(200, 30);
        lastname.setFont(txt_font);
        lastname.setPromptText("Lastname");
        email.setMinSize(200, 30);
        email.setFont(txt_font);
        email.setPromptText("Email");
        card_n.setMinSize(200, 30);
        card_n.setFont(txt_font);
        card_n.setPromptText("Card Number");
        enter.setMinSize(200, 30);
        enter.setFont(txt_font);

        VBox cardholder_v = new VBox(10);
        cardholder_v.setPadding(new Insets(10,0,0,0));
        cardholder_v.setAlignment(Pos.TOP_CENTER);
        cardholder_v.getChildren().add(cardholder_lbl);
        cardholder_v.getChildren().add(name);
        cardholder_v.getChildren().add(lastname);
        cardholder_v.getChildren().add(email);
        cardholder_v.getChildren().add(card_n);
        cardholder_v.getChildren().add(enter);

        this.view = cardholder_v;

        enter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                user_name = name.getText();
                user_lastname = lastname.getText();
                user_email = email.getText();
                user_card = card_n.getText();

                if (user_name.isEmpty() || user_lastname.isEmpty() || user_email.isEmpty() || user_card.isEmpty()){
                    (new PopUp()).popUp("Error",
                            "Input information is not valid!\nPlease, check input fields!");
                } else {
                    CardholderMenu cMenu = new CardholderMenu(main);
                    cMenu.setCardholder(Main_Frame.checkUser(name, lastname, email, user_card));
                    TemplateTS template = new TemplateTS(main, new CardholderMenu(main).getView());
                    main.perform(template.getView());
                    template.clearConsole();
                    template.updateConsole("User: " + user_name + " - log in");

                    (new PopUp()).popUp("Login", "Welcome " + user_name + "!");
                }
            }
        });
    }

    public Pane getView() {
        return this.view;
    }
}

class CardholderMenu{

    private Pane view;
    private Cardholder cardholder;

    private Font lbl_font = new Font("Times New Roman", 16);
    private Font txt_font = new Font("Times New Roman", 14);

    CardholderMenu(MainWindow main){
        // Right side setup
        Label cardholder_lbl = new Label("Cardholder");
        TextField name = new TextField();
        TextField lastname = new TextField();
        TextField email = new TextField();
        TextField card_n = new TextField();
        Button enter = new Button("Enter");

        cardholder_lbl.setFont(lbl_font);
        cardholder_lbl.setTextAlignment(TextAlignment.CENTER);
        name.setMinSize(200, 30);
        name.setFont(txt_font);
        name.setPromptText("Name");
        lastname.setMinSize(200, 30);
        lastname.setFont(txt_font);
        lastname.setPromptText("Lastname");
        email.setMinSize(200, 30);
        email.setFont(txt_font);
        email.setPromptText("Email");
        card_n.setMinSize(200, 30);
        card_n.setFont(txt_font);
        card_n.setPromptText("Card Number");
        enter.setMinSize(200, 30);
        enter.setFont(txt_font);

        VBox cardholder_v = new VBox(10);
        cardholder_v.setPadding(new Insets(10,0,0,0));
        cardholder_v.setAlignment(Pos.TOP_CENTER);
        cardholder_v.getChildren().add(cardholder_lbl);
        cardholder_v.getChildren().add(name);
        cardholder_v.getChildren().add(lastname);
        cardholder_v.getChildren().add(email);
        cardholder_v.getChildren().add(card_n);
        cardholder_v.getChildren().add(enter);

        this.view = cardholder_v;

        enter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                TemplateTS p = new TemplateTS(main, view);
                p.updateConsole("Some text");
                main.perform(p.getView());
            }
        });
    }

    public Pane getView() {
        return this.view;
    }

    public void setCardholder(Cardholder cardholder) {
        this.cardholder = cardholder;
    }
}
