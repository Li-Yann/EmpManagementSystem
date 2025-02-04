
package EmployeeManagementSystem;


import java.sql.Connection;
import java.sql.DriverManager;

public class Connectivity {

    Connection con;

    // Make changes according to your database like username and password,keep url same
    Connectivity() {
        String url = "jdbc:mysql://localhost:3306/employeemanagementsystem";
        String username = "root";
        String password = "AdminUser";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
