package app.db;

import app.model.Complaint;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ComplaintDAO {
    private static final List<Complaint> complaints = new ArrayList<>();
    private static final AtomicInteger idCounter = new AtomicInteger(0);

    static {
        // In-memory complaint data
        complaints.add(new Complaint(idCounter.incrementAndGet(), 1, "Internet is slow", "Open",
                LocalDateTime.now().minusDays(1)));
        complaints.add(new Complaint(idCounter.incrementAndGet(), 2, "No connection", "Open", LocalDateTime.now()));
    }

    public boolean addComplaint(int customerId, String details) {
        Complaint newComplaint = new Complaint(idCounter.incrementAndGet(), customerId, details, "Open",
                LocalDateTime.now());
        return complaints.add(newComplaint);
    }

    public List<Complaint> getAllComplaints() {
        complaints.sort(
                (c1, c2) -> ((LocalDateTime) c2.getDateFiled()).compareTo((ChronoLocalDateTime<?>) c1.getDateFiled()));
        return complaints;
    }

    public boolean resolveComplaint(int complaintId) {
        for (Complaint complaint : complaints) {
            if ((int) complaint.getComplaintId() == complaintId) {
                complaint.setStatus("Resolved");
                return true;
            }
        }
        return false;
    }
}
