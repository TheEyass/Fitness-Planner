package controllers;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.User;
import util.FXMLUtil;

import java.util.HashMap;
import java.util.Map;

public class Controller {

    protected void redirect(Event event, String fxmlFile) {
        var dashboardParent = FXMLUtil.loadFxml(fxmlFile);
        var dashboardScene = new Scene((Parent) dashboardParent);

        var window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(dashboardScene);
        window.centerOnScreen();
        window.show();
    }


}