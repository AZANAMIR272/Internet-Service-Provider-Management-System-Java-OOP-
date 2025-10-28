package app.model;

public class ServicePlan {
    private int planId;
    private String name;
    private double price;

    public ServicePlan(int planId, String name, double price) {
        this.planId = planId;
        this.name = name;
        this.price = price;
    }
    public int getPlanId(){ return planId; }
    public String getName(){ return name; }
    public double getPrice(){ return price; }

    @Override
    public String toString() { return planId + " - " + name + " (Rs " + price + ")"; }
}
