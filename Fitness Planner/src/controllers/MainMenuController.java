package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import model.Plan;

import javax.swing.text.TableView;

public class MainMenuController extends Controller{

    @FXML
    private Text programText;

    @FXML
    private Text workoutText;

    @FXML
    private Text foodText;




    @FXML
    void onWorkoutsMenu(MouseEvent event){
        redirect(event, "workoutmenu");
    }

    @FXML
    void onWorkoutsLedger(MouseEvent event){
        redirect(event, "viewownplanmenu");
    }

    @FXML
    void onNutritionLedger(MouseEvent event){
        redirect(event, "workoutmenu");
    }
}
