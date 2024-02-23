package transitapp.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class PopUp {

    private Font txt_font = new Font("Times New Roman", 18);

    public void popUp(String title, String message){
        Stage stage = new Stage();
        stage.setTitle(title);

        VBox pane = new VBox(10);
        pane.setAlignment(Pos.CENTER);

        Label lbl = new Label(message);
        lbl.setTextAlignment(TextAlignment.CENTER);
        lbl.setFont(txt_font);

        Button ok_btn = new Button("OK");
        ok_btn.setFont(txt_font);

        ok_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.close();
            }
        });

        pane.getChildren().add(lbl);
        pane.getChildren().add(ok_btn);

        stage.setScene(new Scene(pane, 300, 100));
        stage.setResizable(false);
        stage.show();
    }

}
