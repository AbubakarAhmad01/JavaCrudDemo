# Java Console CRUD Application

This is a simple **Java Console Application** that performs basic **CRUD operations (Create, Read, Update, Delete)** on a MySQL database using **JDBC**.

> This project is designed for beginners to understand JDBC, database connectivity, and CRUD functionality in a clean, menu-driven format.

---

## 🧰 Tech Stack

- **Java** (JDK 8+)
- **JDBC**
- **MySQL**
- **IntelliJ IDEA** (or any IDE)
- **Logger** (`java.util.logging`)
- **Console-based user input (Scanner)`**

---

## 🚀 Features

- 🔹 Add a new user (name + email)
- 🔹 View all users
- 🔹 Update user by ID
- 🔹 Delete user by ID
- 🔹 Console-based user menu
- 🔹 Robust error handling with `Logger`

---

## 🛠️ Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/java-crud-console.git
cd java-crud-console


==================================================================================================

2. Set Up MySQL
Create a database and table:

CREATE DATABASE testdb;
USE testdb;

CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100)
);


3. Update DB Credentials in Code
In CrudApp.java, update:

java
Copy
Edit

static final String URL = "jdbc:mysql://localhost:3306/testdb";
static final String USER = "root";
static final String PASS = "your_mysql_password"; // 🔁 Change this


4. Run the Application
Open in IntelliJ IDEA or your preferred IDE

Add MySQL JDBC Driver to your classpath (via Maven or manually)

Run the main() method


---------------------------------------------

📂 Project Structure

java-crud-console/
├── CrudApp.java
├── README.md
└── .gitignore

🔐 Sample Menu
pgsql
Copy
Edit

=== User CRUD Menu ===
1. Create User
2. View All Users
3. Update User
4. Delete User
5. Exit


📌 Notes
Secure PreparedStatement is used to prevent SQL injection.

Logger is used instead of printStackTrace() for clean logging.

You can easily extend this to include validation or a GUI.

🙌 Contributing
Feel free to fork this repository and submit a pull request if you'd like to add features (like validation, GUI, file export, etc.).


📜 License
This project is licensed under the MIT License.











