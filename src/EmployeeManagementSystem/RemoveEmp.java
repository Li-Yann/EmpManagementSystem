package EmployeeManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

public class RemoveEmp extends JFrame implements ActionListener {

    JButton btnSearch, btnDelete, btnBack;
    JTextField search;
    JLabel empId, empNum, lblName, lblNat, lblEmail, lblPhone;
    JLabel lblEmployeeName, lblEmployeeNat, lblEmployeeEmail, lblEmployeePhone;
    JLabel lblDesignation, lblQualification, lblAddress, lblJoinDate;
    JLabel lblDesg, qual, addr, jDate;

    RemoveEmp() {
        setLayout(null);
        setBounds(200, 50, 1150, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("DELETE RECORD");
        title.setBounds(360, 20, 1200, 60);
        title.setFont(new Font("Serif", Font.PLAIN, 40));
        add(title);

        JLabel searchId = new JLabel("Search Id");
        searchId.setBounds(320, 140, 140, 30);
        searchId.setFont(new Font("TimesNewRoman", Font.PLAIN, 25));
        add(searchId);

        search = new JTextField(10);
        search.setBounds(440, 140, 100, 30);
        add(search);

        btnSearch = new JButton("Search");
        btnSearch.setBounds(550, 140, 100, 30);
        btnSearch.setFocusable(false);
        add(btnSearch);
        btnSearch.addActionListener(this);

        btnBack = new JButton("Back");
        btnBack.setBounds(660, 140, 100, 30);
        btnBack.setFocusable(false);
        add(btnBack);
        btnBack.addActionListener(this);

        empId = new JLabel("Employee Id : ");
        empId.setBounds(100, 200, 130, 30);
        empId.setFont(new Font("Serif", Font.BOLD, 20));
        empId.setVisible(false);
        add(empId);
        empNum = new JLabel();
        empNum.setBounds(230, 200, 30, 30);
        empNum.setFont(new Font("Serif", Font.BOLD, 20));
        add(empNum);

        lblName = new JLabel("Name: ");
        lblName.setBounds(100, 250, 100, 30);
        lblName.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblName);
        lblEmployeeName = new JLabel();
        lblEmployeeName.setBounds(230, 250, 300, 30);
        lblEmployeeName.setFont(new Font("Serif", Font.PLAIN, 20));
        add(lblEmployeeName);

        lblNat = new JLabel("Nationality: ");
        lblNat.setBounds(100, 300, 120, 30);
        lblNat.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblNat);
        lblEmployeeNat = new JLabel();
        lblEmployeeNat.setBounds(230, 300, 300, 30);
        lblEmployeeNat.setFont(new Font("Serif", Font.PLAIN, 20));
        add(lblEmployeeNat);

        lblEmail = new JLabel("Email: ");
        lblEmail.setBounds(100, 350, 100, 30);
        lblEmail.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblEmail);
        lblEmployeeEmail = new JLabel();
        lblEmployeeEmail.setBounds(230, 350, 300, 30);
        lblEmployeeEmail.setFont(new Font("Serif", Font.PLAIN, 20));
        add(lblEmployeeEmail);

        lblPhone = new JLabel("Phone: ");
        lblPhone.setBounds(100, 400, 100, 30);
        lblPhone.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblPhone);
        lblEmployeePhone = new JLabel();
        lblEmployeePhone.setBounds(230, 400, 300, 30);
        lblEmployeePhone.setFont(new Font("Serif", Font.PLAIN, 20));
        add(lblEmployeePhone);

        lblDesignation = new JLabel("Designation:");
        lblDesignation.setBounds(630, 250, 180, 30);
        lblDesignation.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblDesignation);
        lblDesg = new JLabel();
        lblDesg.setBounds(800, 250, 300, 30);
        lblDesg.setFont(new Font("Serif", Font.PLAIN, 20));
        add(lblDesg);

        lblQualification = new JLabel("Qualification: ");
        lblQualification.setBounds(630, 300, 150, 30);
        lblQualification.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblQualification);
        qual = new JLabel();
        qual.setBounds(800, 300, 100, 30);
        qual.setFont(new Font("Serif", Font.PLAIN, 20));
        add(qual);

        lblJoinDate = new JLabel("Join Date: ");
        lblJoinDate.setBounds(630, 350, 100, 30);
        lblJoinDate.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblJoinDate);
        jDate = new JLabel();
        jDate.setBounds(800, 350, 100, 30);
        jDate.setFont(new Font("Serif", Font.PLAIN, 20));
        add(jDate);

        lblAddress = new JLabel("Address: ");
        lblAddress.setBounds(630, 400, 100, 30);
        lblAddress.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblAddress);
        addr = new JLabel();
        addr.setBounds(800, 400, 160, 30);
        addr.setFont(new Font("Serif", Font.PLAIN, 20));
        add(addr);

        btnDelete = new JButton("Delete");
        btnDelete.setBounds(490, 450, 100, 30);
        btnDelete.setFocusable(false);
        btnDelete.setVisible(false);
        add(btnDelete);
        btnDelete.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSearch) {
            int id = Integer.parseInt(search.getText());
            searchEmployeeById(id);
        } else if (e.getSource() == btnDelete) {
            int id = Integer.parseInt(empNum.getText());
            deleteEmployee(id);
        } else {
            setVisible(false);
            new Home();
        }
    }

    public void searchEmployeeById(int id) {
        try {
            String query = "SELECT * FROM EmployeeData WHERE id=" + id;
            Connectivity connectivity = new Connectivity();
            Statement statement = connectivity.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if (!resultSet.next()) {
                JOptionPane.showMessageDialog(this, "Employee with ID " + id + " not found.",
                        "Employee Not Found", JOptionPane.ERROR_MESSAGE);
                btnDelete.setVisible(false);  // Hide delete button if employee is not found
            } else {
                empId.setVisible(true);
                empNum.setText(resultSet.getString("id"));
                lblEmployeeName.setText(resultSet.getString("name"));
                lblEmployeeNat.setText(resultSet.getString("nationality"));
                lblEmployeeEmail.setText(resultSet.getString("email"));
                lblEmployeePhone.setText(resultSet.getString("phone"));
                lblDesg.setText(resultSet.getString("designation"));
                qual.setText(resultSet.getString("qualification"));
                addr.setText(resultSet.getString("address"));
                jDate.setText(resultSet.getString("Joining_date"));

                btnDelete.setVisible(true);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void deleteEmployee(int id) {
        int confirmation = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete this employee?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);

        if (confirmation == JOptionPane.YES_OPTION) {
            try {
                String query = "DELETE FROM EmployeeData WHERE id=" + id;
                Connectivity connectivity = new Connectivity();
                Statement statement = connectivity.con.createStatement();
                int rowsAffected = statement.executeUpdate(query);

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Employee with ID " + id + " deleted successfully.",
                            "Deletion Success", JOptionPane.INFORMATION_MESSAGE);
                    empNum.setText("");
                    search.setText("");
                    lblEmployeeName.setText("");
                    lblEmployeeNat.setText("");
                    lblEmployeeEmail.setText("");
                    lblEmployeePhone.setText("");
                    lblDesg.setText("");
                    qual.setText("");
                    addr.setText("");
                    jDate.setText("");
                    btnDelete.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to delete the employee.",
                            "Deletion Failed", JOptionPane.ERROR_MESSAGE);
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
