package transitapp.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

/**
 * Welcome screen that is shown
 * when the app just started
 */
public class Welcome {

    private Pane view;

    Welcome(MainWindow main){
        main.getStage().setTitle("Transit App: " +  this.getClass().getSimpleName());

        Label transit_app_lbl = new Label("Welcome to the \"Transit App\"!");
        Label developers_lbl = new Label("Made by:\nLu Dai\nStanislav Kalynych\nYuriy Teodorovych\nGalym Anuarbek");
        Button start_btn = new Button("Start!");

        VBox welcome = new VBox(20);
        welcome.setAlignment(Pos.CENTER);

        transit_app_lbl.setFont(new Font("Times New Roman", 24));

        developers_lbl.setFont(new Font("Times New Roman", 16));
        developers_lbl.setTextFill(Color.GRAY);
        developers_lbl.setTextAlignment(TextAlignment.CENTER);

        start_btn.setFont(new Font("Times New Roman", 18));
        //start_btn.setStyle("-fx-focus-color: transparent;");
        start_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                main.perform(new MainMenu(main).getView());
            }
        });

        welcome.getChildren().add(transit_app_lbl);
        welcome.getChildren().add(developers_lbl);
        welcome.getChildren().add(start_btn);

        this.view = welcome;
    }

    public Pane getView() {
        return this.view;
    }
}