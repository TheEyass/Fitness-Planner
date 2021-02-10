package controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.Muscle;
import model.Plan;
import model.User;
import model.Workout;
import repos.MuscleRepository;
import repos.Repositories;
import repos.UserRepository;
import session.SessionManager;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class FirstTimeLoginController extends Controller {

    UserRepository userRepository = Repositories.getUserRepository();
    MuscleRepository muscleRepository = Repositories.getMuscleRepository();
    SessionManager sessionManager = SessionManager.getInstance();

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button registerButton;

    @FXML
    private Button loginButton;

    @FXML
    private Button forgotPasswordButton;

    @FXML
    void redirectRegister(MouseEvent event) {
        redirect(event, "register");
    }

    @FXML
    void onLogin(MouseEvent event) {
        String usernameText = usernameField.getText();

        sessionManager.setActiveSession(usernameText);


        Plan p = new Plan("No plan selected!", "x", "x", "x", "x");
        Workout w = new Workout("Please create or use a plan!");
        p.addWorkout(w);

        User u = userRepository.getUser(sessionManager.getActiveSession().get().getUserUsername()).get();

        u.setAdheredToPlan(p);

        if (userRepository.getUser(usernameText).isPresent()) {
            redirect(event, "mainmenu");
        } else {
            usernameField.clear();
            usernameField.setPromptText("Wrong username!");
        }
    }

    public void initialize() {
        loadTemplates();

        userRepository.createUser("eyass", "Eyass", 20);
    }
}
