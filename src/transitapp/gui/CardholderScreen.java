package transitapp.gui;

import javafx.scene.layout.Pane;

public class CardholderScreen {

    private Pane view;

    CardholderScreen(MainWindow main){
        Pane p = new Pane();
        this.view = p;
    }

    public Pane getView() {
        return this.view;
    }
}
