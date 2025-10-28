package app.ui;

import app.db.*;
import app.model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class MainFrame extends JFrame {
    private final PlanDAO planDAO = new PlanDAO();
    private final CustomerDAO customerDAO = new CustomerDAO();
    private final ComplaintDAO complaintDAO = new ComplaintDAO();

    private JTable tblCustomers;
    private JTable tblComplaints;
    private DefaultTableModel customersModel;
    private DefaultTableModel complaintsModel;
    private JComboBox<ServicePlan> planCombo;

    public MainFrame(User user) {
        setTitle("ISP System - Dashboard (" + user.getUsername() + ")");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        initUI();
        loadData();
    }

    private void initUI() {
        JTabbedPane tabs = new JTabbedPane();

        JPanel customersPanel = new JPanel(new BorderLayout(8, 8));
        customersModel = new DefaultTableModel(new Object[] { "ID", "Name", "Phone", "Plan" }, 0);
        tblCustomers = new JTable(customersModel);
        customersPanel.add(new JScrollPane(tblCustomers), BorderLayout.CENTER);

        JPanel custBottom = new JPanel();
        JTextField txtName = new JTextField(12);
        JTextField txtPhone = new JTextField(10);
        planCombo = new JComboBox<>();
        JButton btnAdd = new JButton("Add Customer");
        btnAdd.addActionListener(_ -> {
            String name = txtName.getText().trim();
            String phone = txtPhone.getText().trim();
            ServicePlan p = (ServicePlan) planCombo.getSelectedItem();
            Integer pid = p == null ? null : p.getPlanId();
            if (!name.isEmpty()) {
                if (customerDAO.addCustomer(name, phone, pid)) {
                    JOptionPane.showMessageDialog(this, "Customer added");
                    loadCustomers();
                } else
                    JOptionPane.showMessageDialog(this, "Error adding customer");
            }
        });

        custBottom.add(new JLabel("Name:"));
        custBottom.add(txtName);
        custBottom.add(new JLabel("Phone:"));
        custBottom.add(txtPhone);
        custBottom.add(new JLabel("Plan:"));
        custBottom.add(planCombo);
        custBottom.add(btnAdd);
        customersPanel.add(custBottom, BorderLayout.SOUTH);

        JPanel complaintsPanel = new JPanel(new BorderLayout(8, 8));
        complaintsModel = new DefaultTableModel(new Object[] { "ID", "CustomerID", "Details", "Status", "Date" }, 0);
        tblComplaints = new JTable(complaintsModel);
        complaintsPanel.add(new JScrollPane(tblComplaints), BorderLayout.CENTER);

        JPanel compBottom = new JPanel();
        JTextField txtCustId = new JTextField(5);
        JTextField txtDetails = new JTextField(30);
        JButton btnFile = new JButton("File Complaint");
        btnFile.addActionListener(_ -> {
            try {
                int cid = Integer.parseInt(txtCustId.getText().trim());
                String d = txtDetails.getText().trim();
                if (complaintDAO.addComplaint(cid, d)) {
                    JOptionPane.showMessageDialog(this, "Complaint filed");
                    loadComplaints();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Enter valid customer id");
            }
        });

        JButton btnResolve = new JButton("Resolve Selected");
        btnResolve.addActionListener(_ -> {
            int row = tblComplaints.getSelectedRow();
            if (row >= 0) {
                int compId = Integer.parseInt(complaintsModel.getValueAt(row, 0).toString());
                if (complaintDAO.resolveComplaint(compId)) {
                    JOptionPane.showMessageDialog(this, "Complaint resolved");
                    loadComplaints();
                }
            }
        });

        compBottom.add(new JLabel("Customer ID:"));
        compBottom.add(txtCustId);
        compBottom.add(new JLabel("Details:"));
        compBottom.add(txtDetails);
        compBottom.add(btnFile);
        compBottom.add(btnResolve);
        complaintsPanel.add(compBottom, BorderLayout.SOUTH);

        tabs.add("Customers", customersPanel);
        tabs.add("Complaints", complaintsPanel);

        add(tabs, BorderLayout.CENTER);
    }

    private void loadData() {
        loadPlans();
        loadCustomers();
        loadComplaints();
    }

    private void loadPlans() {
        planCombo.removeAllItems();
        List<ServicePlan> plans = planDAO.getAllPlans();
        for (ServicePlan p : plans)
            planCombo.addItem(p);
    }

    private void loadCustomers() {
        customersModel.setRowCount(0);
        List<Customer> list = customerDAO.getAllCustomers();
        for (Customer c : list)
            customersModel.addRow(new Object[] {
                    c.getCustomerId(), c.getName(), c.getPhone(), c.getPlan() != null ? c.getPlan().getName() : "None"
            });
    }

    private void loadComplaints() {
        complaintsModel.setRowCount(0);
        List<Complaint> list = complaintDAO.getAllComplaints();
        for (Complaint co : list) {
            complaintsModel.addRow(new Object[] {
                    co.getComplaintId(),
                    co.getCustomerId(),
                    co.getDetails(),
                    co.getStatus(),
                    co.getDateFiled()
            });
        }
    }
}
