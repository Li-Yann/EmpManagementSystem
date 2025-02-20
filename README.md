# Employee Management System

This Employee Management System is a desktop application built using Java Swing, designed to simplify the management and tracking of employee details. It provides features like adding, updating, deleting, and viewing employee information in an easy-to-use graphical interface.

## Features

- **Add Employee:** Allows the user to add new employee details including name, designation, department, and contact info.
- **View Employees:** Displays a list of all employees in the system.
- **Update Employee:** Allows the user to modify existing employee information.
- **Delete Employee:** Enables the deletion of employee records from the system.
- **Employee Search:** Search functionality based on employee name or other criteria.
- **User-friendly Interface:** Built using Java Swing for an intuitive, easy-to-navigate interface.
- **Data Validation:** Ensures that all fields are filled out correctly before submitting.

## Tech Stack

- **Java** (for application logic)
- **Swing** (for GUI design)
- **JDBC** (for database connectivity, if applicable)
- **MySQL** / **SQLite** (for storing employee data, optional)
- **Calendar JAR** (for integrating calendar functionality into the application)

## Requirements

Before running the application, ensure you have the following installed on your system:

- **Java Development Kit (JDK)** 8 or later
- **IDE** like IntelliJ IDEA or Eclipse (optional)
- **Database** like MySQL or SQLite (optional, if using database connectivity)
- **Calendar JAR File** (to be included in your project)

**Common Issues:**
- If the calendar does not appear or shows an error, check that the JAR is correctly added to your project's build path.
- Ensure that any necessary import statements for the calendar JAR are included at the top of your Java files, e.g.:

    ```java
    import com.toedter.calendar.JDateChooser;
    ```

## Database Setup

```
create database employeemanagementsystem;
use  employeemanagementsystem;

create table login(
username varchar(50),
password varchar(50)
);

insert into login(username,password)  values('admin','useradmin');
```

```
CREATE TABLE EmployeeData (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    date_of_birth DATE,
    gender VARCHAR(10),
    nationality VARCHAR(50),
    designation VARCHAR(50),
    joining_date DATE,
    address VARCHAR(255),
    email VARCHAR(100),
    phone VARCHAR(20),
    qualification VARCHAR(100),
    department VARCHAR(50),
    job_type VARCHAR(50)
);
```



## Screenshots

<img src="src/icons/front.png" alt="Front" width="800" height="600">

## Login UI
<img src="src/icons/login.png" alt="Front" width="500" height="300">

## Home Page
<img src="src/icons/menu.png" alt="Front" width="800" height="600">

## Add Employee
<img src="src/icons/add.png" alt="Front" width="800" height="600">

## View Employees
<img src="src/icons/view.png" alt="Front" width="800" height="400">

## Update Data
<img src="src/icons/upd.png" alt="Front" width="800" height="400">

## Delete Data
<img src="src/icons/delete.png" alt="Front" width="600" height="400">




