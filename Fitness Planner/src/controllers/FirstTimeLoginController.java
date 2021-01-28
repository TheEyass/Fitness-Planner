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
import repos.Repositories;
import repos.UserRepository;

import java.util.UUID;

public class FirstTimeLoginController extends Controller {

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
        Muscle AbsPrimary = new Muscle("Abs: Primary", "Abs");
        Muscle AbsSecondary = new Muscle("Abs: Secondary", "Abs");
        Muscle AdductorPrimary = new Muscle("Adductor: Primary", "Hips");
        Muscle AdductorSecondary = new Muscle("Adductor: Secondary", "Hips");
        Muscle AnteriorDeltPrimary = new Muscle("Anterior Delt: Primary", "Shoulders");
        Muscle AnteriorDeltSecondary = new Muscle("Anterior Delt: Secondary", "Shoulders");
        Muscle BicepPrimary = new Muscle("Bicep: Primary", "Arms");
        Muscle BicepSecondary = new Muscle("Bicep: Secondary", "Arms");
        Muscle CalvesPrimary = new Muscle("Calves: Primary", "Legs");
        Muscle CalvesSecondary = new Muscle("Calves: Secondary", "Legs");
        Muscle FlexorPrimary = new Muscle("Flexor: Primary", "Hips");
        Muscle FlexorSecondary = new Muscle("Flexor: Secondary", "Hips");
        Muscle ForearmsPrimary = new Muscle("Forearms: Primary", "Arms");
        Muscle ForearmsSecondary = new Muscle("Forearms: Secondary", "Arms");
        Muscle GlutesPrimary = new Muscle("Glutes: Primary", "Legs");
        Muscle GlutesSecondary = new Muscle("Glutes: Secondary", "Legs");
        Muscle GluteusMediusPrimary = new Muscle("Gluteus Medius: Primary", "Legs");
        Muscle GluteusMediusSecondary = new Muscle("Gluteus Medius: Secondary", "Legs");
        Muscle HamstringPrimary = new Muscle("Hamstrings: Primary", "Legs");
        Muscle HamstringSecondary = new Muscle("Hamstrings: Secondary", "Legs");
        Muscle InfraspinatusPrimary = new Muscle("Infraspinatus: Primary", "Back");
        Muscle InfraspinatusSecondary = new Muscle("Infraspinatus: Secondary", "Back");
        Muscle ShoulderLatsPrimary = new Muscle("Lats: Primary", "Back");
        Muscle ShoulderLatsSecondary = new Muscle("Lats: Secondary", "Back");
        Muscle LateralsPrimary = new Muscle("Laterals: Primary", "Shoulder");
        Muscle LateralsSecondary = new Muscle("Laterals: Secondary", "Shoulder");
        Muscle ErectorSpinaePrimary = new Muscle("Erector Spinae: Primary", "Back");
        Muscle ErectorSpinaeSecondary = new Muscle("Erector Spinae: Secondary", "Back");
        Muscle ObliquesPrimary = new Muscle("Obliques: Primary", "Abs");
        Muscle ObliquesSecondary = new Muscle("Obliques: Secondary", "Abs");
        Muscle PecsPrimary = new Muscle("Pectorals: Primary", "Chest");
        Muscle PecsSecondary = new Muscle("Pectorals: Secondary", "Chest");
        Muscle PosteriorDeltsPrimary = new Muscle("Posterior Delts: Primary", "Shoulders");
        Muscle PosteriorDeltsSecondary = new Muscle("Posterior Delts: Secondary", "Shoulders");
        Muscle QuadsPrimary = new Muscle("Quads: Primary", "Legs");
        Muscle QuadsSecondary = new Muscle("Quads: Secondary", "Legs");
        Muscle SartoriusPrimary = new Muscle("Sartorius: Primary", "Hips");
        Muscle SartoriusSecondary = new Muscle("Sartorius: Secondary", "Hips");
        Muscle SerratusPrimary = new Muscle("Serratus: Primary", "Abs");
        Muscle SerratusSecondary = new Muscle("Serratus: Secondary", "Abs");
        Muscle TensorPrimary = new Muscle("Tensor: Primary", "Hips");
        Muscle TensorSecondary = new Muscle("Tensor: Secondary", "Hips");
        Muscle TeresPrimary = new Muscle("Teres: Primary", "Back");
        Muscle TeresSecondary = new Muscle("Teres; Secondary", "Back");
        Muscle TibialisPrimary = new Muscle("Tibialis: Primary", "Leg");
        Muscle TibialisSecondary = new Muscle("Tibialis: Secondary", "Leg");
        Muscle TricepPrimary = new Muscle("Tricep: Primary", "Arms");
        Muscle TricepSecondary = new Muscle("Tricep: Secondary", "Arms");


        Workout BenchPress = new Workout("Bench Press");
        BenchPress.addMuscle(PecsPrimary);
        BenchPress.addMuscle(TricepSecondary);
        BenchPress.addMuscle(AnteriorDeltSecondary);


        Workout Squat = new Workout("Squat");
        Squat.addMuscle(QuadsPrimary);
        Squat.addMuscle(HamstringPrimary);
        Squat.addMuscle(AdductorSecondary);
        Squat.addMuscle(GlutesSecondary);

        Workout OHP = new Workout("Overhead Press");
        OHP.addMuscle(PecsSecondary);
        OHP.addMuscle(AnteriorDeltPrimary);
        OHP.addMuscle(ShoulderLatsSecondary);
        OHP.addMuscle(TricepSecondary);
        OHP.addMuscle(SerratusSecondary);

        Workout BarbellRow = new Workout("Barbell Row");
        BarbellRow.addMuscle(TeresPrimary);
        BarbellRow.addMuscle(LateralsPrimary);


        final var SL = planRepository.createPlan(UUID.randomUUID(), "StrongLifts 5x5", "Beginner", "Strength", "Three months minimum", "Barbell");
        int bruh = SL.getAllWorkouts().size();
        planRepository.getPlanByName("StrongLifts 5x5").ifPresent(plan -> plan.addWorkout(BarbellRow));
        System.out.println(SL.getAllWorkouts().get(bruh-1).getMusclesworked());
        SL.addWorkout(OHP);
        bruh = SL.getAllWorkouts().size();
        System.out.println(bruh);
        System.out.println(SL.getAllWorkouts().get(bruh-1).getMusclesworked());
        SL.setDescription("Bruh!");
        userRepository.createUser("eyass", "Eyass", 20);
    }
}
