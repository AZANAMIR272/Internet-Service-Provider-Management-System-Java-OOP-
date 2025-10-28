package app.model;

import java.time.LocalDateTime;

public class Complaint {
    private int id;
    private int customerId;
    private String details;
    private String status;
    private LocalDateTime dateFiled;

    public Complaint(int id, int customerId, String details, String status, LocalDateTime dateFiled) {
        this.id = id;
        this.customerId = customerId;
        this.details = details;
        this.status = status;
        this.dateFiled = dateFiled;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Complaint#" + id + " | Cust:" + customerId + " | " + details + " | " + status + " | " + dateFiled;
    }

    public Object getComplaintId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getComplaintId'");
    }

    public Object getCustomerId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCustomerId'");
    }

    public Object getDetails() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDetails'");
    }

    public Object getStatus() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStatus'");
    }

    public Object getDateFiled() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDateFiled'");
    }
}
