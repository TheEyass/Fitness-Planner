package repos;

import model.Workout;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class SelectedWorkout {
    private Set<Workout> workoutSelected = new HashSet<>();

    public void setWorkout(Workout workout){
        workoutSelected.add(workout);
    }

    public void clearWorkout(){
        workoutSelected.clear();
    }

    public Optional<Workout> getWorkout(){
        return workoutSelected.stream().findAny();
    }

}
