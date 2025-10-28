package app.db;

import app.model.ServicePlan;
import java.util.ArrayList;
import java.util.List;

public class PlanDAO {
    private static final List<ServicePlan> plans = new ArrayList<>();
    static {
        // In-memory plan data
        plans.add(new ServicePlan(1, "Basic 10Mbps", 29.99));
        plans.add(new ServicePlan(2, "Standard 50Mbps", 49.99));
        plans.add(new ServicePlan(3, "Premium 100Mbps", 79.99));
    }

    public List<ServicePlan> getAllPlans() {
        return plans;
    }

    public ServicePlan getPlanById(int id) {
        return plans.stream()
                .filter(p -> p.getPlanId() == id)
                .findFirst().orElse(null);
    }
}
