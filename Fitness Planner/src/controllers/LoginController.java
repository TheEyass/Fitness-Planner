package controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.Muscle;
import model.User;
import model.Workout;
import repos.Repositories;
import repos.UserRepository;
import session.SessionManager;

import java.util.UUID;

public class LoginController extends Controller{

    UserRepository userRepository = Repositories.getUserRepository();
    SessionManager sessionManager = SessionManager.getInstance();

    @FXML
    private TextField usernameField;

    @FXML
    private Button registerButton;

    @FXML
    private Button loginButton;

    @FXML
    void redirectRegister(MouseEvent event){
        redirect(event,"register");
    }

    @FXML
    void onLogin(MouseEvent event){
        String usernameText = usernameField.getText();

        sessionManager.setActiveSession(usernameText);
        if (userRepository.getUser(usernameText).isPresent()){
            redirect(event, "mainmenu");
        } else {
            usernameField.clear();
            usernameField.setPromptText("Wrong username!");
        }
    }

    @FXML
    public void initialize(){
        userRepository.getAll();

    }
}
