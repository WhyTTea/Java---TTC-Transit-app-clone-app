package transitapp.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Main window of the program
 */
public class MainWindow extends Application{

    private int width = 400;
    private int height = 400;

    private Scene scene;
    private Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        initGUI(this.stage);
    }

    private void initGUI(Stage stage){
        BorderPane canvas = new BorderPane();
        canvas.setCenter((new Welcome(this)).getView());
        assignScene(new Scene(canvas, width, height));

        stage.setScene(this.scene);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
    }

    public void perform(Pane pane){
        this.stage.centerOnScreen();
        this.scene.setRoot(pane);
    }

    // Getter Methods

    public Stage getStage() {
        return this.stage;
    }

    public Scene getScene() {
        return this.scene;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    // Setter Methods

    public void assignScene(Scene scene) {
        this.scene = scene;
    }

    public void setHeight(int height) {
        this.height = height;
        if (this.stage != null) this.stage.setHeight(this.height);
    }

    public void setWidth(int width) {
        this.width = width;
        if (this.stage != null) this.stage.setWidth(this.width);
    }
}
