package repos;

import model.Muscle;
import model.Plan;

import java.util.*;

public class MuscleRepository {

    private final Set<Muscle> muscles = new HashSet<>();

    protected MuscleRepository() {
    }

    public Muscle createMuscle(String muscleName, String muscleArea) {
        final var muscle = new Muscle(muscleName, muscleArea);
        muscles.add(muscle);
        return muscle;
    }


    public Set<Muscle> getAllMuscles() {
        return Collections.unmodifiableSet(muscles);
    }

    public Optional<Muscle> getMuscle(String name) {
        return muscles.stream().filter(muscle -> muscle.getMuscleName().equals(name)).findAny();
    }
}
