package transitapp.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import transitapp.Cardholder;

public class enterAction implements EventHandler<ActionEvent> {
    private Cardholder ch;
    enterAction(Cardholder ch){
    	this.ch=ch;
    }
    public void handle(ActionEvent e) {
    	ch.Enter(curr_stop, today, ts)
    }


}