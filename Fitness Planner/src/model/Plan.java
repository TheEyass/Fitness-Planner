package model;

import javafx.collections.FXCollections;

import java.lang.reflect.Array;
import java.util.*;

public class Plan {

    public UUID id;
    public String planName;
    public String planSkillLevel;
    public String focus;
    public String length;
    public String toolsRequired;
    public String description;
    public ArrayList<Workout> workouts;
    public ArrayList<Workout> monday;
    public ArrayList<Workout> tuesday;
    public ArrayList<Workout> wednesday;
    public ArrayList<Workout> thursday;
    public ArrayList<Workout> friday;
    public ArrayList<Workout> saturday;
    public ArrayList<Workout> sunday;


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
        this.id = id;
        this.planName = planName;
        this.planSkillLevel = planSkillLevel;
        this.focus = focus;
        this.length = length;
        this.toolsRequired = toolsRequired;
        this.workouts = new ArrayList<>();
        this.description = description;
    }

    public void addWorkout(Workout workout){
        workouts.add(workout);
    }

    public void removeWorkout(Workout workout){
        workouts.remove(workout);
    }

    public ArrayList<Workout> getWorkouts() {
        return workouts;
    }

    public Optional<Workout> getWorkoutByName(String name){
        return workouts.stream().filter(workout -> workout.getName().equals(name)).findAny();
    }

    public ArrayList<Workout> getAllWorkouts() {
        if (workouts.isEmpty()) {
            Workout workout = new Workout(UUID.randomUUID(), "WOW!");
            workouts.add(workout);
            return workouts;
        } else {
            return workouts;
        }
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

    public UUID getPlanId(){
        return id;
    }

    public String getPlanSkillLevel() {
        return planSkillLevel;
    }

    public String getToolsRequired() {
        return toolsRequired;
    }

    public String getDescription() {
        return description;
    }


    public ArrayList<Muscle> getAllMuscles(){
        ArrayList<Muscle> muscles = new ArrayList<>();
        for (int i = 0; i < workouts.size(); i++) {
            Workout workout = workouts.get(i);
            muscles.addAll(workout.getMusclesworked());
        }
        return muscles;
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

    public void setDescription(String description) {
        this.description = description;
    }

}
