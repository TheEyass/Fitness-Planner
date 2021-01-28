package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import model.Muscle;
import model.Plan;
import repos.PlanRepository;
import repos.Repositories;
import repos.SelectedPlan;
import model.Workout;

import java.util.HashMap;
import java.util.UUID;

public class ViewPlanController extends Controller{

    SelectedPlan selectedPlan = Repositories.getSelectedPlan();
    PlanRepository planRepository = Repositories.getPlanRepository();

    private Plan plan;

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
    private Text descText;

    @FXML
    private Rectangle backButton;

    public void initialize(){
        planRepository.getAllPlans();
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
        Muscle HamstringSecondary= new Muscle("Hamstrings: Secondary", "Legs");
        Muscle InfraspinatusPrimary = new Muscle("Infraspinatus: Primary", "Back");
        Muscle InfraspinatusSecondary = new Muscle("Infraspinatus: Secondary", "Back");
        Muscle ShoulderLatsPrimary = new Muscle("Lats: Primary", "Back");
        Muscle ShoulderLatsSecondary = new Muscle("Lats: Secondary","Back");
        Muscle LateralsPrimary = new Muscle("Laterals: Primary", "Shoulder");
        Muscle LateralsSecondary = new Muscle("Laterals: Secondary", "Shoulder");
        Muscle ErectorSpinaePrimary = new Muscle("Erector Spinae: Primary", "Back");
        Muscle ErectorSpinaeSecondary = new Muscle("Erector Spinae: Secondary", "Back");
        Muscle ObliquesPrimary = new Muscle("Obliques: Primary", "Abs");
        Muscle ObliquesSecondary = new Muscle("Obliques: Secondary", "Abs");
        Muscle PecsPrimary = new Muscle("Pectorals: Primary", "Chest");
        Muscle PecsSecondary = new Muscle("Pectorals: Secondary", "Chest");
        Muscle PosteriorDeltsPrimary= new Muscle("Posterior Delts: Primary", "Shoulders");
        Muscle PosteriorDeltsSecondary= new Muscle("Posterior Delts: Secondary", "Shoulders");
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



        this.plan = selectedPlan.getPlan().get();

        planName.setText(plan.getPlanName());
        if (plan.getDescription() == null){
            plan.setDescription("This plan has no description yet!");
            descText.setText(plan.getDescription());
        } else {
            descText.setText(plan.getDescription());
        }

        final var workouts = plan.getAllWorkouts();

        int size = plan.getAllWorkouts().size();
        int musclesSize = plan.getAllWorkouts().get(size-1).getMusclesworked().size();


        muscleWorkedTable.setItems(FXCollections.observableArrayList(plan.getWorkouts().get(size-1).getMusclesworked()));
        musclesWorked.setCellValueFactory(new PropertyValueFactory<String, Muscle>("muscleName"));
        muscleLocation.setCellValueFactory(new PropertyValueFactory<String, Muscle>("muscleArea"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<String, Workout>("name"));
        noteColumn.setCellValueFactory(new PropertyValueFactory<String, Workout>("notes"));
        repColumn.setCellValueFactory(new PropertyValueFactory<Integer, Workout>("reps"));
        setColumn.setCellValueFactory(new PropertyValueFactory<Integer, Workout>("sets"));

        workoutTable.setItems(FXCollections.observableArrayList(plan.getAllWorkouts()));
    }

    @FXML
    public void onBackButton(MouseEvent event){
        redirect(event, "workoutmenu");
    }

}
