package app.db;

import app.model.Customer;
import app.model.ServicePlan;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomerDAO {
    private final PlanDAO planDAO = new PlanDAO();
    private static final List<Customer> customers = new ArrayList<>();
    private static final AtomicInteger idCounter = new AtomicInteger(0);

    public CustomerDAO() {
        if (customers.isEmpty()) {
            // In-memory customer data
            customers.add(new Customer(idCounter.incrementAndGet(), "John Doe", "555-1234", planDAO.getPlanById(1)));
            customers.add(new Customer(idCounter.incrementAndGet(), "Jane Smith", "555-5678", planDAO.getPlanById(2)));
        }
    }

    public List<Customer> getAllCustomers() {
        return customers;
    }

    public boolean addCustomer(String name, String phone, Integer planId) {
        ServicePlan plan = planId != null ? planDAO.getPlanById(planId) : null;
        Customer newCustomer = new Customer(idCounter.incrementAndGet(), name, phone, plan);
        return customers.add(newCustomer);
    }

    public boolean updateCustomerPlan(int customerId, int planId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId() == customerId) {
                ServicePlan newPlan = planDAO.getPlanById(planId);
                customer.setPlan(newPlan);
                return true;
            }
        }
        return false;
    }
}
