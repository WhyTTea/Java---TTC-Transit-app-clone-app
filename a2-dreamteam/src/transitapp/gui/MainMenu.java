package transitapp.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

/**
 * Main menu of the program
 */
public class MainMenu {

    private Pane view;

    MainMenu(MainWindow main){
        main.getStage().setTitle("Transit App: " + this.getClass().getSimpleName());

        Label menu_lbl = new Label("Main Menu");
        Button new_btn = new Button("Create a new Transit System");
        Button template_btn = new Button("Use a template of a Transit System");
        Button features_btn = new Button("Features");

        VBox menu = new VBox(20);
        menu.setAlignment(Pos.CENTER);

        menu_lbl.setFont(new Font("Times New Roman", 24));
        menu_lbl.setTextAlignment(TextAlignment.CENTER);

        new_btn.setFont(new Font("Times New Roman", 18));
        //start_btn.setStyle("-fx-focus-color: transparent;");
        new_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                main.perform(new NewTransitSystem(main).getView());
            }
        });

        template_btn.setFont(new Font("Times New Roman", 18));
        //template_btn.setStyle("-fx-focus-color: transparent;");
        template_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                main.perform(new TemplateTS(main).getView());
            }
        });

        features_btn.setStyle("-fx-background-radius: 20em");
        features_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //TODO: Open features.txt
            }
        });

        menu.getChildren().add(features_btn);
        menu.getChildren().add(menu_lbl);
        menu.getChildren().add(new_btn);
        menu.getChildren().add(template_btn);

        HBox hBox = new HBox();
        hBox.getChildren().add(features_btn);
        hBox.setAlignment(Pos.CENTER_RIGHT);

        BorderPane mainMenu = new BorderPane();
        mainMenu.setPadding(new Insets(20));

        mainMenu.setTop(hBox);
        mainMenu.setCenter(menu);

        this.view = mainMenu;
    }

    public Pane getView() {
        return this.view;
    }
}
