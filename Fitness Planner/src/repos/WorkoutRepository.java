package repos;

import model.User;
import model.Workout;

import java.util.*;

import static java.util.Objects.requireNonNull;

public class WorkoutRepository {

    private final Set<Workout> workoutsStorage = new HashSet<>();

    protected WorkoutRepository() {
    }

    public Workout createWorkout(String name) {
        final var workout = new Workout(UUID.randomUUID(), name);
        workoutsStorage.add(workout);
        return workout;
    }

    public Set<Workout> getAllWorkouts() {
        return Collections.unmodifiableSet(workoutsStorage);
    }

    public Optional<Workout> getWorkout(String name) {
        return workoutsStorage.stream().filter(workout -> workout.getName().equals(name)).findAny();
    }

    public boolean deleteWorkout(String name) {
        return workoutsStorage.removeIf(workout -> workout.getName().equals(name)); // Returns true if successful at removing
    }
}