package model;

public class Muscle {

    public String muscleName;
    public String muscleArea;

    public Muscle(String muscleName, String muscleArea){
        this.muscleName = muscleName;
        this.muscleArea = muscleArea;
    }

    public String getMuscleArea() {
        return muscleArea;
    }

    public String getMuscleName() {
        return muscleName;
    }

    public void setMuscleArea(String muscleArea) {
        this.muscleArea = muscleArea;
    }

    public void setMuscleName(String muscleName) {
        this.muscleName = muscleName;
    }

    @Override
    public String toString() {
        return muscleName + ": " +muscleArea + "\n";
    }
}
