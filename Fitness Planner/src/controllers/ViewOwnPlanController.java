package controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import model.Muscle;
import model.Plan;
import model.User;
import model.Workout;
import repos.PlanRepository;
import repos.Repositories;
import repos.UserRepository;
import session.SessionManager;

import java.util.ArrayList;
import java.util.Optional;

public class ViewOwnPlanController extends Controller {

    PlanRepository planRepository = Repositories.getPlanRepository();
    SessionManager sessionManager = SessionManager.getInstance();
    UserRepository userRepository = Repositories.getUserRepository();

    private Plan plan = new Plan("St", "nr", "gr", "if", "ufde");

    @FXML
    private Text backText;

    @FXML
    private Text planName;

    @FXML
    private TableView<Workout> workoutTable;

    @FXML
    private TableColumn<String, Workout> nameColumn;

    @FXML
    private TableColumn<Integer, Workout> repColumn;

    @FXML
    private TableColumn<Integer, Workout> setColumn;

    @FXML
    private TableColumn<String, Workout> noteColumn;

    @FXML
    private TableView<Muscle> muscleWorkedTable;

    @FXML
    private TableColumn<String, Muscle> musclesWorked;

    @FXML
    private TableColumn<String, Muscle> muscleLocation;

    @FXML
    private TableColumn<Double, Workout> weightColumn;

    public void initialize() {



        final var activeSession = sessionManager.getActiveSession();

        String username = activeSession.get().getUserUsername();

        User u = userRepository.getUser(username).get();

        this.plan = u.getAdheredToPlan();

        planName.setText(plan.getPlanName());




        ArrayList<Workout> noRepeatedWorkouts = new ArrayList<>();

        for (Workout workout : plan.getAllWorkouts()) {
            if (!noRepeatedWorkouts.contains(workout)) {
                noRepeatedWorkouts.add(workout);
            }
        }

        ArrayList<Muscle> noRepeatedMuscles = new ArrayList<>();

        for (Muscle m : plan.getAllMuscles()) {
            if (!noRepeatedMuscles.contains(m)) {
                noRepeatedMuscles.add(m);
            }
        }

        muscleWorkedTable.setItems(FXCollections.observableArrayList(noRepeatedMuscles));
        musclesWorked.setCellValueFactory(new PropertyValueFactory<String, Muscle>("muscleName"));
        muscleLocation.setCellValueFactory(new PropertyValueFactory<String, Muscle>("muscleArea"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<String, Workout>("name"));
        noteColumn.setCellValueFactory(new PropertyValueFactory<String, Workout>("notes"));
        repColumn.setCellValueFactory(new PropertyValueFactory<Integer, Workout>("reps"));
        setColumn.setCellValueFactory(new PropertyValueFactory<Integer, Workout>("sets"));
        weightColumn.setCellValueFactory(new PropertyValueFactory<Double, Workout>("weight"));
        weightColumn.isEditable();

        workoutTable.setItems(FXCollections.observableArrayList(noRepeatedWorkouts));
    }

    @FXML
    public void onBackButton(MouseEvent event){
        redirect(event, "workoutmenu");
    }
}
