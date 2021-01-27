package repos;

import model.Plan;
import model.Workout;

import java.util.*;

public class PlanRepository {


    private final Set<Plan> plans = new HashSet<>();

    protected PlanRepository() {
    }

    public Plan createPlan(UUID id, String planName, String planSkillLevel, String focus, String length, String toolsRequired) {
        final var plan = new Plan(id, planName, planSkillLevel, focus, length, toolsRequired);
        plans.add(plan);
        return plan;
    }


    public Set<Plan> getAllPlans() {
        return Collections.unmodifiableSet(plans);
    }

    public Optional<Plan> getPlan(UUID id) {
        return plans.stream().filter(plan -> plan.getPlanName().equals(id)).findAny();
    }

    public boolean deletePlan(String name) {
        return plans.removeIf(plan -> plan.getPlanName().equals(name)); // Returns true if successful at removing
    }

}
