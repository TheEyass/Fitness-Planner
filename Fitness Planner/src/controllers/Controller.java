package controllers;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Muscle;
import model.Plan;
import model.User;
import model.Workout;
import repos.*;
import util.FXMLUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Controller {

    UserRepository userRepository = Repositories.getUserRepository();
    PlanRepository planRepository = Repositories.getPlanRepository();
    WorkoutRepository workoutRepository = Repositories.getWorkoutRepository();
    MuscleRepository muscleRepository = Repositories.getMuscleRepository();

    protected void redirect(Event event, String fxmlFile) {
        var dashboardParent = FXMLUtil.loadFxml(fxmlFile);
        var dashboardScene = new Scene((Parent) dashboardParent);

        var window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(dashboardScene);
        window.centerOnScreen();
        window.show();
    }

    public void loadTemplates(){
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
        workoutRepository.getWorkout("Bench Press").get().setReps(5);
        workoutRepository.getWorkout("Bench Press").get().setSets(5);


        workoutRepository.createWorkout("Squat");
        workoutRepository.getWorkout("Squat").get().addMuscle(muscleRepository.getMuscle("Quads").get());
        workoutRepository.getWorkout("Squat").get().addMuscle(muscleRepository.getMuscle("Hamstrings").get());
        workoutRepository.getWorkout("Squat").get().addMuscle(muscleRepository.getMuscle("Adductor").get());
        workoutRepository.getWorkout("Squat").get().addMuscle(muscleRepository.getMuscle("Glutes").get());
        workoutRepository.getWorkout("Squat").get().setReps(5);
        workoutRepository.getWorkout("Squat").get().setSets(5);

        workoutRepository.createWorkout("Overhead Press");
        workoutRepository.getWorkout("Overhead Press").get().addMuscle(muscleRepository.getMuscle("Pectorals").get());
        workoutRepository.getWorkout("Overhead Press").get().addMuscle(muscleRepository.getMuscle("Anterior Delt").get());
        workoutRepository.getWorkout("Overhead Press").get().addMuscle(muscleRepository.getMuscle("Laterals").get());
        workoutRepository.getWorkout("Overhead Press").get().addMuscle(muscleRepository.getMuscle("Tricep").get());
        workoutRepository.getWorkout("Overhead Press").get().addMuscle(muscleRepository.getMuscle("Serratus").get());
        workoutRepository.getWorkout("Overhead Press").get().setReps(5);
        workoutRepository.getWorkout("Overhead Press").get().setSets(5);


        workoutRepository.createWorkout("Barbell Row");
        workoutRepository.getWorkout("Barbell Row").get().addMuscle(muscleRepository.getMuscle("Teres").get());
        workoutRepository.getWorkout("Barbell Row").get().addMuscle(muscleRepository.getMuscle("Lats").get());
        workoutRepository.getWorkout("Barbell Row").get().setReps(5);
        workoutRepository.getWorkout("Barbell Row").get().setSets(5);


        planRepository.getPlanByName("StrongLifts 5x5").ifPresent(plan -> plan.addWorkout(workoutRepository.getWorkout("Barbell Row").get()));
        planRepository.getPlan(SL.getId()).ifPresent(plan -> plan.addWorkout(workoutRepository.getWorkout("Overhead Press").get()));
        planRepository.getPlan(SL.getId()).ifPresent(plan -> plan.addWorkout(workoutRepository.getWorkout("Bench Press").get()));
        SL.setDescription("Bruh!");
    }
}