package controllers;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Muscle;
import model.Plan;
import model.User;
import model.Workout;
import repos.PlanRepository;
import repos.Repositories;
import repos.UserRepository;
import repos.WorkoutRepository;
import util.FXMLUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Controller {

    UserRepository userRepository = Repositories.getUserRepository();
    PlanRepository planRepository = Repositories.getPlanRepository();
    WorkoutRepository workoutRepository = Repositories.getWorkoutRepository();

    protected void redirect(Event event, String fxmlFile) {
        var dashboardParent = FXMLUtil.loadFxml(fxmlFile);
        var dashboardScene = new Scene((Parent) dashboardParent);

        var window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(dashboardScene);
        window.centerOnScreen();
        window.show();
    }
}