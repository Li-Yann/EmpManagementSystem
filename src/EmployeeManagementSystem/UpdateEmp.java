package EmployeeManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.toedter.calendar.JDateChooser;

public class UpdateEmp extends JFrame implements ActionListener {

    JLabel fullName, dob, gender, nationality, designation, joinDate, address, email,
            phoneNo, qualification, department, jobType, empId, empNum;
    JTextField txtName, txtNat, txtDes, txtAdd, txtEmail, txtPh, txtQual, txtDept;
    JRadioButton male, female;
    JDateChooser dateChooser, dateJoin;
    JComboBox job;
    JButton submit, clear, back;
    int id;


    UpdateEmp(int id) {
        this.id = id;

        setLayout(null);
        setBounds(200, 50, 1150, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        JLabel title = new JLabel("Update Employee Record");
        title.setBounds(380, 20, 1200, 60);
        title.setFont(new Font("Serif", Font.PLAIN, 40));
        add(title);

        empId = new JLabel("Employee Id : ");
        empId.setBounds(100, 60, 130, 30);
        empId.setFont(new Font("Serif", Font.BOLD, 20));
        add(empId);
        empNum = new JLabel();
        empNum.setBounds(230, 60, 30, 30);
        empNum.setFont(new Font("Serif", Font.BOLD, 20));
        add(empNum);

        fullName = new JLabel("Full Name");
        fullName.setBounds(100, 120, 90, 30);
        fullName.setFont(new Font("Serif", Font.BOLD, 20));
        add(fullName);
        txtName = new JTextField(10);
        txtName.setBounds(270, 120, 200, 30);
        txtName.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(txtName);

        dob = new JLabel("Date of Birth");
        dob.setBounds(100, 180, 120, 30);
        dob.setFont(new Font("Serif", Font.BOLD, 20));
        add(dob);
        dateChooser = new JDateChooser();
        dateChooser.setBounds(270, 180, 200, 30);
        add(dateChooser);

        gender = new JLabel("Gender");
        gender.setBounds(100, 240, 120, 30);
        gender.setFont(new Font("Serif", Font.BOLD, 20));
        add(gender);
        male = new JRadioButton("Male");
        male.setBounds(270, 240, 90, 30);
        male.setFont(new Font("Serif", Font.BOLD, 20));
        male.setFocusable(false);
        male.setBackground(Color.LIGHT_GRAY);
        add(male);
        female = new JRadioButton("Female");
        female.setBounds(370, 240, 90, 30);
        female.setFont(new Font("Serif", Font.BOLD, 20));
        female.setFocusable(false);
        female.setBackground(Color.LIGHT_GRAY);
        add(female);
        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);

        nationality = new JLabel("Nationality");
        nationality.setBounds(100, 300, 120, 30);
        nationality.setFont(new Font("Serif", Font.BOLD, 20));
        add(nationality);
        txtNat = new JTextField(10);
        txtNat.setBounds(270, 300, 200, 30);
        txtNat.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(txtNat);

        designation = new JLabel("Designation");
        designation.setBounds(100, 360, 120, 30);
        designation.setFont(new Font("Serif", Font.BOLD, 20));
        add(designation);
        txtDes = new JTextField(10);
        txtDes.setBounds(270, 360, 200, 30);
        txtDes.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(txtDes);

        joinDate = new JLabel("Joining Date");
        joinDate.setBounds(100, 420, 120, 30);
        joinDate.setFont(new Font("Serif", Font.BOLD, 20));
        add(joinDate);
        dateJoin = new JDateChooser();
        dateJoin.setBounds(270, 420, 200, 30);
        add(dateJoin);

        address = new JLabel("Address");
        address.setBounds(650, 120, 120, 30);
        address.setFont(new Font("Serif", Font.BOLD, 20));
        add(address);
        txtAdd = new JTextField(10);
        txtAdd.setBounds(790, 120, 200, 30);
        txtAdd.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(txtAdd);

        email = new JLabel("Email");
        email.setBounds(650, 180, 120, 30);
        email.setFont(new Font("Serif", Font.BOLD, 20));
        add(email);
        txtEmail = new JTextField(10);
        txtEmail.setBounds(790, 180, 200, 30);
        txtEmail.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(txtEmail);

        phoneNo = new JLabel("Phone No");
        phoneNo.setBounds(650, 240, 120, 30);
        phoneNo.setFont(new Font("Serif", Font.BOLD, 20));
        add(phoneNo);
        txtPh = new JTextField(10);
        txtPh.setBounds(790, 240, 200, 30);
        txtPh.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(txtPh);

        qualification = new JLabel("Qualification");
        qualification.setBounds(650, 300, 120, 30);
        qualification.setFont(new Font("Serif", Font.BOLD, 20));
        add(qualification);
        txtQual = new JTextField(10);
        txtQual.setBounds(790, 300, 200, 30);
        txtQual.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(txtQual);

        department = new JLabel("Department");
        department.setBounds(650, 360, 120, 30);
        department.setFont(new Font("Serif", Font.BOLD, 20));
        add(department);
        txtDept = new JTextField(10);
        txtDept.setBounds(790, 360, 200, 30);
        txtDept.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(txtDept);

        jobType = new JLabel("Job Type");
        jobType.setBounds(650, 420, 120, 30);
        jobType.setFont(new Font("Serif", Font.BOLD, 20));
        add(jobType);
        String[] types = {"Full Time", "Part Time", "Contract"};
        job = new JComboBox<>(types);
        job.setBounds(790, 420, 200, 30);
        add(job);

        submit = new JButton("Update");
        submit.setFocusable(false);
        submit.setBounds(380, 520, 100, 50);
        submit.setForeground(Color.BLACK);
        submit.setBackground(Color.WHITE);
        add(submit);
        submit.addActionListener(this);

        clear = new JButton("Clear");
        clear.setFocusable(false);
        clear.setBounds(510, 520, 100, 50);
        clear.setForeground(Color.BLACK);
        clear.setBackground(Color.WHITE);
        add(clear);
        clear.addActionListener(this);

        back = new JButton("Back");
        back.setFocusable(false);
        back.setBounds(640, 520, 100, 50);
        back.setForeground(Color.BLACK);
        back.setBackground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        oldData();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            int check = JOptionPane.showConfirmDialog(null, "Are you sure you want to update?",
                    "Update Information", JOptionPane.YES_NO_OPTION);
            if (check == 0) {
                String name = txtName.getText();
                String nat = txtNat.getText();
                String des = txtDes.getText();
                String addr = txtAdd.getText();
                String email = txtEmail.getText();
                String phone = txtPh.getText();
                String qual = txtQual.getText();
                String dept = txtDept.getText();
                String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
                String date = ((JTextField) dateJoin.getDateEditor().getUiComponent()).getText();
                String gen = male.isSelected() ? "Male" : "Female";
                String type = (String) job.getSelectedItem();

                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Full Name is required!", "Validation Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (dob.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Date of Birth is required!", "Validation Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (!male.isSelected() && !female.isSelected()) {
                    JOptionPane.showMessageDialog(this, "Gender is required!", "Validation Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (nat.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Nationality is required!", "Validation Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (des.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Designation is required!", "Validation Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (date.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Joining Date is required!", "Validation Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (addr.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Address is required!", "Validation Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (email.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Email is required!", "Validation Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (email.equals("@gmail.com")) {
                    JOptionPane.showMessageDialog(this, "Invalid email address!", "Validation Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if ((!email.contains("@gmail.com"))) {
                    JOptionPane.showMessageDialog(this, "@gmail is required!", "Validation Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (phone.length() < 10 || (!phone.matches("[0-9]+"))) {
                    JOptionPane.showMessageDialog(this, "Phone Number must be 10 digits!", "Validation Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (qual.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Qualification is required!", "Validation Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (dept.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Department is required!", "Validation Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (type == null || type.equals("Select a Job Type")) {
                    JOptionPane.showMessageDialog(this, "Please select a valid job type!", "Validation Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Connectivity connectivity = new Connectivity();
                String query = "UPDATE EmployeeData SET " +
                        "name = ?, date_of_birth = STR_TO_DATE(?, '%b %d,%Y'),gender = ?, nationality = ?,designation = ?," +
                        "joining_date = STR_TO_DATE(?, '%b %d,%Y'),address = ?,email = ?, phone = ?," +
                        "qualification = ?,department = ?, job_type = ? " +
                        "WHERE id = ?";

                try {
                    PreparedStatement preparedStatement = connectivity.con.prepareStatement(query);
                    preparedStatement.setString(1, name);
                    preparedStatement.setString(2, dob);
                    preparedStatement.setString(3, gen);
                    preparedStatement.setString(4, nat);
                    preparedStatement.setString(5, des);
                    preparedStatement.setString(6, date);
                    preparedStatement.setString(7, addr);
                    preparedStatement.setString(8, email);
                    preparedStatement.setString(9, phone);
                    preparedStatement.setString(10, qual);
                    preparedStatement.setString(11, dept);
                    preparedStatement.setString(12, type);
                    preparedStatement.setInt(13, id);
                    preparedStatement.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Data Updated successfully!", "Data Info",
                            JOptionPane.INFORMATION_MESSAGE);
                    setVisible(false);
                    new Home();

                } catch (Exception exp) {
                    JOptionPane.showMessageDialog(null, "Problem during update", "Data Info",
                            JOptionPane.WARNING_MESSAGE);
                    exp.printStackTrace();
                }

            } else {
                JOptionPane.showMessageDialog(null, "Data not updated", "Update Information",
                        JOptionPane.ERROR_MESSAGE);
            }


        } else if (e.getSource() == back) {
            setVisible(false);
            new UpdateView();
        } else {
            txtName.setText("");
            txtNat.setText("");
            txtDes.setText("");
            txtAdd.setText("");
            txtEmail.setText("");
            txtPh.setText("");
            txtQual.setText("");
            txtDept.setText("");
            male.setSelected(false);
            female.setSelected(false);
            job.setSelectedIndex(0);
            dateChooser.setDate(null);
            dateJoin.setDate(null);
        }
    }

    public void oldData() {
        String query = "Select * from EmployeeData where id=" + id;
        try {
            Connectivity connectivity = new Connectivity();
            Statement statement = connectivity.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                empNum.setText(resultSet.getString("id"));
                txtName.setText(resultSet.getString("name"));
                txtNat.setText(resultSet.getString("nationality"));
                txtEmail.setText(resultSet.getString("email"));
                txtPh.setText(resultSet.getString("phone"));

                Date dob = resultSet.getDate("date_of_birth");
                Date date = resultSet.getDate("joining_date");
                dateChooser.setDate(dob);
                dateJoin.setDate(date);

                String gen = resultSet.getString("gender");
                male.setSelected(gen.equals("Male"));
                female.setSelected(gen.equals("Female"));

                job.setSelectedItem(jobType);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
