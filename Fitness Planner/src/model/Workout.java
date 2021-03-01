package model;

import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;
import java.util.UUID;

public class Workout {

    public UUID id;
    public String name;
    public Integer reps;
    public Integer sets;
    public Double weight;
    public SimpleStringProperty notes;
    public ArrayList<Muscle> musclesworked;

    public Workout(UUID id, String name){
        id = UUID.randomUUID();
        this.name = name;
        this.reps = reps;
        this.sets = sets;
        this.weight = weight;
        this.notes = notes;
        this.musclesworked = new ArrayList<>();
    }

    public void addMuscle(Muscle muscle){
        musclesworked.add(muscle);
    }

    public void setMusclesworked(ArrayList<Muscle> musclesworked) {
        this.musclesworked = musclesworked;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNotes(String notes) {
        this.notes = new SimpleStringProperty(notes);
    }

    public void setReps(Integer reps) {
        this.reps = reps;
    }

    public void setSets(Integer sets) {
        this.sets = sets;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getSets() {
        return sets;
    }

    public ArrayList<Muscle> getMusclesworked() {
        return musclesworked;
    }

    public Double getWeight() {
        return weight;
    }

    public Integer getReps() {
        return reps;
    }

    public String getName() {
        return name;
    }

    public SimpleStringProperty getNotes() {
        return notes;
    }

    public UUID getId() {
        return id;
    }
}
