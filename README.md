

# 🌐 Internet Service Provider (ISP) Management System  
A desktop-based ISP Management System built using **Java Swing**, **MySQL**, and **JDBC**.  
This system allows administrators to manage customers, service plans, and complaints through a clean graphical user interface.

---
<img width="451" height="582" alt="image" src="https://github.com/user-attachments/assets/744e6088-0fde-4be7-bb3c-71f8a73114cf" />

<img width="451" height="572" alt="image" src="https://github.com/user-attachments/assets/1734bd2c-ffa7-4667-ba60-15a32e28d584" />


## ✨ Features

| Module | Description |
|--------|-------------|
| **Login System** | Secure login for Admin users |
| **Customer Management** | Add new customers and assign service plans |
| **Service Plans** | Predefined plans fetched from MySQL database |
| **Complaint Management** | File and resolve complaints for customers |
| **GUI Dashboard** | Simple, intuitive Swing-based interface |
| **MySQL Integration** | Uses JDBC to store & retrieve data |

---

## 🏛️ System Architecture

```

Java (Swing GUI)
│
│ JDBC
▼
MySQL Database

```

---

## 🧱 Project Structure

```

ISP-GUI-MySQL/
│
├── src/app/
│   ├── Main.java                 // Application Entry Point
│   │
│   ├── db/                       // Database Access Layer (DAO)
│   │   ├── DBConnection.java
│   │   ├── UserDAO.java
│   │   ├── PlanDAO.java
│   │   ├── CustomerDAO.java
│   │   └── ComplaintDAO.java
│   │
│   ├── model/                    // Data Models (Objects)
│   │   ├── User.java
│   │   ├── ServicePlan.java
│   │   ├── Customer.java
│   │   └── Complaint.java
│   │
│   └── ui/                       // Graphical User Interface
│       ├── LoginFrame.java
│       └── MainFrame.java
│
└── isp_schema.sql                // Database Creation Script

````

---

4. Verify tables created:

   * `users`
   * `customers`
   * `complaints`
   * `service_plans`

### 🔑 Default Login

| Username | Password   | Role  |
| -------- | ---------- | ----- |
| `admin`  | `admin123` | Admin |

---

## ⚙️ Configuration

Open:

```
src/app/db/DBConnection.java
```

Modify the credentials:

```java
private static final String USER = "root";     // your MySQL username
private static final String PASS = "your_password"; // your MySQL password
```

---

## ▶ Running the Application

### Using an IDE (NetBeans / IntelliJ / Eclipse)

1. Open project
2. Add **MySQL JDBC Driver**
3. Run `Main.java`

### Creating Runnable JAR (Optional)

```
File → Project Structure → Artifacts → Add → JAR → With Dependencies → Build
```

---




---

## 🚀 Future Enhancements

* BCrypt password hashing (security upgrade)
* Multi-role accounts (Admin / Support / Customer)
* Invoice & billing module
* Detailed network data usage tracking
* PDF invoice export

---

## 👨‍💻 Developed By

**Azan & Safwan**
Software Engineering Department
Sir Syed University of Engineering & Technology

---

## ⭐ Contribution & Support

If you like this project, give it a **star ⭐** on GitHub.
For improvements, feel free to submit a **pull request**.






> **"Push to GitHub"** 🚀
```
