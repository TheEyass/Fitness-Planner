package repos;

import model.Plan;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class SelectedPlan {
    private Set<Plan> planSelected = new HashSet<>();

    public void setPlan(Plan plan){
        planSelected.add(plan);
    }

    public void clearPlan(){
        planSelected.clear();
    }

    public Optional<Plan> getPlan(){
        return planSelected.stream().findAny();
    }

}
