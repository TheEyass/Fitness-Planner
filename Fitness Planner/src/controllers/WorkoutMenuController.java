package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import model.Muscle;
import model.Plan;
import model.Workout;
import repos.PlanRepository;
import repos.Repositories;
import repos.SelectedPlan;

import java.util.UUID;

public class WorkoutMenuController extends Controller {

    private final PlanRepository planRepository = Repositories.getPlanRepository();
    private final SelectedPlan selectedPlan = Repositories.getSelectedPlan();
    private final ObservableList<Plan> plans = FXCollections.observableArrayList(planRepository.getAllPlans());

    @FXML
    private Text backText;

    @FXML
    private Text viewText;

    @FXML
    private Text editText;

    @FXML
    private Text deleteText;

    @FXML
    private Text createText;

    @FXML
    private Rectangle backButton;

    @FXML
    private Rectangle viewButton;

    @FXML
    private Rectangle editButton;

    @FXML
    private Rectangle deleteButton;

    @FXML
    private Rectangle createButton;

    @FXML
    private TableView<Plan> planTableView;

    @FXML
    private TableColumn<String, Plan> nameColumn;

    @FXML
    private TableColumn<String, Plan> skillColumn;

    @FXML
    private TableColumn<String, Plan> focusColumn;

    @FXML
    private TableColumn<String, Plan> lengthColumn;

    @FXML
    private TableColumn<String, Plan> toolsColumn;

    public void initialize(){
        planTableView.setItems(FXCollections.observableArrayList(planRepository.getAllPlans()));

        nameColumn.setCellValueFactory(new PropertyValueFactory<String, Plan>("planName"));
        skillColumn.setCellValueFactory(new PropertyValueFactory<String, Plan>("planSkillLevel"));
        focusColumn.setCellValueFactory(new PropertyValueFactory<String, Plan>("focus"));
        lengthColumn.setCellValueFactory(new PropertyValueFactory<String, Plan>("length"));
        toolsColumn.setCellValueFactory(new PropertyValueFactory<String, Plan>("toolsRequired"));

        planTableView.setEditable(true);

        planRepository.getPlanByName("StrongLifts 5x5").get().getAllWorkouts().get(1).getMusclesworked();
        planRepository.getPlanByName("StrongLifts 5x5").ifPresent(plan -> System.out.println(plan.getAllWorkouts().get(1).getMusclesworked()));

    }

    public void setWorkout(){
        selectedPlan.clearPlan();
        ObservableList<Plan> selectedRows;


       selectedRows = planTableView.getSelectionModel().getSelectedItems();
          for (Plan plan : selectedRows){
            selectedPlan.setPlan(plan);
        }
    }

    @FXML
    public void onBackButton(MouseEvent event){
        redirect(event, "mainmenu");
    }

    @FXML
    public void onViewButton(MouseEvent event){
        setWorkout();
        redirect(event, "viewplanmenu");
    }

    @FXML
    public void onEditButton(MouseEvent event){
        //redirect();
    }

    @FXML
    public void onCreateButton(MouseEvent event){
        //redirect();
    }

    @FXML
    public void onDeleteButton(MouseEvent event){
        //redirect();
    }
}
