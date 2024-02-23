package transitapp.gui;

import javafx.scene.layout.Pane;

public class NewTransitSystem {

    private Pane view;

    NewTransitSystem(MainWindow main){
        Pane p = new Pane();
        this.view = p;
    }

    public Pane getView() {
        return this.view;
    }
}
