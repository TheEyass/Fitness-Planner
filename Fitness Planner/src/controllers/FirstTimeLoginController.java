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

import java.util.UUID;

public class FirstTimeLoginController extends Controller {

    UserRepository userRepository = Repositories.getUserRepository();
    MuscleRepository muscleRepository = Repositories.getMuscleRepository();

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
        if (userRepository.getUser(usernameText).isPresent()) {
            redirect(event, "mainmenu");
        } else {
            usernameField.clear();
            usernameField.setPromptText("Wrong username!");
        }
    }

    public void initialize() {
        final var SL = planRepository.createPlan(UUID.randomUUID(), "StrongLifts 5x5", "Beginner", "Strength", "Three months minimum", "Barbell");

        muscleRepository.createMuscle("Abs", "Abs");
        muscleRepository.createMuscle("Adductor", "Hips");
        muscleRepository.createMuscle("Anterior Delt", "Shoulders");
        muscleRepository.createMuscle("Bicep", "Arms");
        muscleRepository.createMuscle("Calves" , "Legs");
        muscleRepository.createMuscle("Flexor", "Hips");
        muscleRepository.createMuscle("Forearms", "Arms");
        muscleRepository.createMuscle("Glutes", "Legs");
        muscleRepository.createMuscle("Hamstrings", "Legs");
        muscleRepository.createMuscle("Infraspinatus", "Back");
        muscleRepository.createMuscle("Lats", "Back");
        muscleRepository.createMuscle("Laterals", "Shoulder");
        muscleRepository.createMuscle("Erector Spinae", "Back");
        muscleRepository.createMuscle("Obliques" , "Abs");
        muscleRepository.createMuscle("Pectorals", "Chest");
        muscleRepository.createMuscle("Posterior Delts", "Shoulders");
        muscleRepository.createMuscle("Quads", "Legs");
        muscleRepository.createMuscle("Sartorius", "Hips");
        muscleRepository.createMuscle("Serratus", "Abs");
        muscleRepository.createMuscle("Tensor", "Hips");
        muscleRepository.createMuscle("Teres", "Back");
        muscleRepository.createMuscle("Tibialis", "Leg");
        muscleRepository.createMuscle("Tricep", "Arms");


        planRepository.getPlan(SL.getId()).get().addWorkout(workoutRepository.createWorkout("Bench Press"));
        workoutRepository.getWorkout("Bench Press").get().addMuscle(muscleRepository.getMuscle("Pectorals").get());
        workoutRepository.getWorkout("Bench Press").get().addMuscle(muscleRepository.getMuscle("Tricep").get());
        workoutRepository.getWorkout("Bench Press").get().addMuscle(muscleRepository.getMuscle("Anterior Delt").get());


        Workout Squat = new Workout("Squat");
        Squat.addMuscle(muscleRepository.getMuscle("Quads").get());
        Squat.addMuscle(muscleRepository.getMuscle("Hamstrings").get());
        Squat.addMuscle(muscleRepository.getMuscle("Adductor").get());
        Squat.addMuscle(muscleRepository.getMuscle("Glutes").get());

        Workout OHP = new Workout("Overhead Press");
        OHP.addMuscle(muscleRepository.getMuscle("Pectorals").get());
        OHP.addMuscle(muscleRepository.getMuscle("Anterior Delt").get());
        OHP.addMuscle(muscleRepository.getMuscle("Laterals").get());
        OHP.addMuscle(muscleRepository.getMuscle("Tricep").get());
        OHP.addMuscle(muscleRepository.getMuscle("Serratus").get());

        Workout BarbellRow = new Workout("Barbell Row");
        BarbellRow.addMuscle(muscleRepository.getMuscle("Teres").get());
        BarbellRow.addMuscle(muscleRepository.getMuscle("Lats").get());


        planRepository.getPlanByName("StrongLifts 5x5").ifPresent(plan -> plan.addWorkout(BarbellRow));
        planRepository.getPlan(SL.getId()).ifPresent(plan -> plan.addWorkout(OHP));
        planRepository.getPlan(SL.getId()).ifPresent(plan -> plan.addWorkout(workoutRepository.getWorkout("Bench Press").get()));
        SL.setDescription("Bruh!");

        userRepository.createUser("eyass", "Eyass", 20);
    }
}
