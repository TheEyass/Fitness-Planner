package repos;

public class Repositories {

    private static UserRepository USER_REPOSITORY = new UserRepository();
    private static PlanRepository PLAN_REPOSITORY = new PlanRepository();
    private static WorkoutRepository WORKOUT_REPOSITORY = new WorkoutRepository();
    private static SelectedPlan SELECTED_PLAN = new SelectedPlan();
    private static SelectedWorkout SELECTED_WORKOUT = new SelectedWorkout();

    private Repositories(){}

    public static UserRepository getUserRepository(){ return USER_REPOSITORY; }

    public static PlanRepository getPlanRepository(){ return PLAN_REPOSITORY; }

    public static WorkoutRepository getWorkoutRepository(){ return WORKOUT_REPOSITORY; }

    public static SelectedPlan getSelectedPlan(){ return SELECTED_PLAN; }

    public static SelectedWorkout getSelectedWorkout(){ return SELECTED_WORKOUT; }
}
