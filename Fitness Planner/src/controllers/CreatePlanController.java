package controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import model.Muscle;
import model.Plan;
import model.Workout;
import repos.MuscleRepository;
import repos.PlanRepository;
import repos.Repositories;
import repos.WorkoutRepository;

import javax.swing.table.TableColumnModel;
import java.util.ArrayList;
import java.util.UUID;

public class CreatePlanController extends Controller{

    PlanRepository planRepository = Repositories.getPlanRepository();
    WorkoutRepository workoutRepository = Repositories.getWorkoutRepository();
    MuscleRepository muscleRepository = Repositories.getMuscleRepository();

    @FXML
    private TextField planNameField;

    @FXML
    private TableView<Workout> workoutsTable;

    @FXML
    private TableColumn<String, Workout> workouts;

    @FXML
    private TableView workoutTable;

    @FXML
    private TableColumn<String, Workout> nameColumn;

    @FXML
    private TableColumn<Integer, Workout> repColumn;

    @FXML
    private TableColumn<Integer, Workout> setColumn;

    @FXML
    private TableColumn<String, Workout> noteColumn;

    @FXML
    private Text addWorkout;

    @FXML
    private TableView<Muscle> noTrainedMuscles;

    @FXML
    private TableColumn<String, Muscle> noTrainedMusclesColumn;

    ArrayList<Workout> workoutsAdded = new ArrayList<>();
    ArrayList<Workout> noRepeatAddedWorkouts = new ArrayList<>();
    ArrayList<Muscle> musclesWorked = new ArrayList<>();
    ArrayList<Muscle> noMusclesWorked = new ArrayList<>();

    public void initialize(){
        workoutTable.setItems(FXCollections.observableArrayList(workoutsAdded));

        for (Workout w : workoutRepository.getAllWorkouts()){
            if (!workoutsAdded.contains(w)){
                noRepeatAddedWorkouts.add(w);
            }
        }


        for (Muscle m : muscleRepository.getAllMuscles()){
            if (!musclesWorked.contains(m)){
                noMusclesWorked.add(m);
            }
        }

        workoutsTable.setItems(FXCollections.observableArrayList(noRepeatAddedWorkouts));

        nameColumn.setCellValueFactory(new PropertyValueFactory<String, Workout>("name"));
        noteColumn.setCellValueFactory(new PropertyValueFactory<String, Workout>("notes"));
        repColumn.setCellValueFactory(new PropertyValueFactory<Integer, Workout>("reps"));
        setColumn.setCellValueFactory(new PropertyValueFactory<Integer, Workout>("sets"));

        workouts.setCellValueFactory(new PropertyValueFactory<String, Workout>("name"));

        noTrainedMuscles.setItems(FXCollections.observableArrayList(noMusclesWorked));
        noTrainedMusclesColumn.setCellValueFactory(new PropertyValueFactory<String, Muscle>("muscleName"));


    }

    public void onWorkoutAdded(MouseEvent event){
        Workout w = workoutsTable.getSelectionModel().getSelectedItem();
        workoutsAdded.add(w);

        musclesWorked.addAll(w.getMusclesworked());

        noRepeatAddedWorkouts.clear();

        for (Workout wo : workoutRepository.getAllWorkouts()){
            if (!workoutsAdded.contains(wo)){
                noRepeatAddedWorkouts.add(wo);
            }
        }

        workoutTable.setItems(FXCollections.observableArrayList(workoutsAdded));
        workoutsTable.setItems(FXCollections.observableArrayList(noRepeatAddedWorkouts));

        noMusclesWorked.clear();
        
        for (Muscle m : muscleRepository.getAllMuscles()){
            if (!musclesWorked.contains(m)){
                noMusclesWorked.add(m);
            }
        }

        noTrainedMuscles.setItems(FXCollections.observableArrayList(noMusclesWorked));

        noTrainedMuscles.refresh();
        workoutsTable.refresh();
        workoutTable.refresh();
        System.out.println(workoutsAdded);
        System.out.println(noMusclesWorked);
        System.out.println(noRepeatAddedWorkouts);
        System.out.println(musclesWorked);
    }

    public void createPlan(MouseEvent event){
        Plan p = new Plan(planNameField.getText(), "", "", "", "");
        if (workoutsAdded.size() > 0) {
            for (int i = 0; i < workoutsAdded.size(); i++){
                p.addWorkout(workoutsAdded.get(i));
            }
            planRepository.addPlan(p);
            redirect(event, "workoutmenu");

        } else  {
            System.out.println("Bruh!");
        }
    }
}
