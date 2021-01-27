package model;

import javafx.collections.FXCollections;

import java.lang.reflect.Array;
import java.util.*;

public class Plan {

    private UUID id;
    private String planName;
    private String planSkillLevel;
    private String focus;
    private String length;
    private String toolsRequired;
    private ArrayList<Workout> workouts;


    public Plan(String planName, String planSkillLevel, String focus, String length, String toolsRequired){
        this.id = UUID.randomUUID();
        this.planName = planName;
        this.planSkillLevel = planSkillLevel;
        this.focus = focus;
        this.length = length;
        this.toolsRequired = toolsRequired;
        this.workouts = new ArrayList<>();
    }

    public Plan(UUID id, String planName, String planSkillLevel, String focus, String length, String toolsRequired){
        this.id = UUID.randomUUID();
        this.planName = planName;
        this.planSkillLevel = planSkillLevel;
        this.focus = focus;
        this.length = length;
        this.toolsRequired = toolsRequired;
        this.workouts = new ArrayList<>();
    }

    public void addWorkout(Workout workout){
        workouts.add(workout);
    }

    public void removeWorkout(Workout workout){
        workouts.remove(workout.getName());
    }

    public ArrayList<Workout> getWorkouts() {
        return workouts;
    }

    public ArrayList<Workout> getAllWorkouts(){
        if (workouts.isEmpty()){
            Workout workout = new Workout("Workout");
            workouts.add(workout);
        }

        return workouts;
    }

    public UUID getId(){return id;}

    public String getFocus() {
        return focus;
    }

    public String getLength() {
        return length;
    }

    public String getPlanName() {
        return planName;
    }

    public String getPlanSkillLevel() {
        return planSkillLevel;
    }

    public String getToolsRequired() {
        return toolsRequired;
    }

    public void setFocus(String focus) {
        this.focus = focus;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public void setPlanSkillLevel(String planSkillLevel) {
        this.planSkillLevel = planSkillLevel;
    }

    public void setToolsRequired(String toolsRequired) {
        this.toolsRequired = toolsRequired;
    }
}
