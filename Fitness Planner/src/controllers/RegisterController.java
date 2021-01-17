package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.User;
import repos.Repositories;
import repos.UserRepository;

public class RegisterController extends Controller{

    UserRepository userRepository = Repositories.getUserRepository();

    @FXML
    private TextField usernameField;

    @FXML
    private TextField displayNameField;

    @FXML
    private TextField ageField;

    @FXML
    private Button registerButton;

    @FXML
    void redirectLogin(MouseEvent event){
        redirect(event, "login");
    }

    @FXML
    void onRegisterClicked(MouseEvent event){
        userRepository.createUser(usernameField.getText(), displayNameField.getText(), Integer.parseInt(ageField.getText()));
        userRepository.getAll();
    }
}
