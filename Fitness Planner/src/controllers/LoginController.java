package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.User;
import repos.Repositories;
import repos.UserRepository;

public class LoginController extends Controller{

    UserRepository userRepository = Repositories.getUserRepository();

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
    void redirectRegister(MouseEvent event){
        redirect(event,"register");
    }

    @FXML
    void onLogin(MouseEvent event){
        String usernameText = usernameField.getText();
        if (userRepository.getUser(usernameText) != null){
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
