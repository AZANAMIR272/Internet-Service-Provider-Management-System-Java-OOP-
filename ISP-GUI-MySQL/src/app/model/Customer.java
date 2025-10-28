package app.model;

public class Customer {
    private int customerId;
    private String name;
    private String phone;
    private ServicePlan plan;

    public Customer(int customerId, String name, String phone, ServicePlan plan) {
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
        this.plan = plan;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public ServicePlan getPlan() {
        return plan;
    }

    public void setPlan(ServicePlan plan) {
        this.plan = plan;
    }

    @Override
    public String toString() {
        return customerId + " | " + name + " | " + phone + " | Plan: " + (plan != null ? plan.getName() : "None");
    }
}
