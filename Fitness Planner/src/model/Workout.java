package model;

import java.util.ArrayList;

public class Workout {

    public String name;
    public Integer reps;
    public Integer sets;
    public Double weight;
    public String notes;
    public ArrayList<Muscle> musclesworked;

    public Workout(String name){
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
        this.notes = notes;
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

    public String getNotes() {
        return notes;
    }
}
