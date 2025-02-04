package EmployeeManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

import com.toedter.calendar.JDateChooser;

public class AddEmp extends JFrame implements ActionListener {

    JLabel fullName, dob, gender, nationality, designation, joinDate, address;
    JLabel email, phoneNo, qualification, department, jobType;
    JTextField txtName, txtNat, txtDes, txtAdd, txtEmail, txtPh, txtQual, txtDept;
    JRadioButton male, female;
    JDateChooser dateChooser, dateJoin;
    JButton submit, clear, back;
    JComboBox job;


    AddEmp() {
        setLayout(null);
        setBounds(200, 50, 1150, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(106, 189, 189));
        JLabel title = new JLabel("ADD EMPLOYEE DETAILS");
        title.setBounds(360, 20, 1200, 60);
        title.setFont(new Font("Serif", Font.PLAIN, 40));
        add(title);

        fullName = new JLabel("Full Name");
        fullName.setBounds(100, 100, 90, 30);
        fullName.setFont(new Font("Serif", Font.BOLD, 20));
        add(fullName);
        txtName = new JTextField(10);
        txtName.setBounds(270, 100, 200, 30);
        txtName.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(txtName);

        dob = new JLabel("Date of Birth");
        dob.setBounds(100, 160, 120, 30);
        dob.setFont(new Font("Serif", Font.BOLD, 20));
        add(dob);
        dateChooser = new JDateChooser();
        dateChooser.setBounds(270, 160, 200, 30);
        add(dateChooser);

        gender = new JLabel("Gender");
        gender.setBounds(100, 220, 120, 30);
        gender.setFont(new Font("Serif", Font.BOLD, 20));
        add(gender);
        male = new JRadioButton("Male");
        male.setBounds(270, 220, 90, 30);
        male.setFont(new Font("Serif", Font.BOLD, 20));
        male.setFocusable(false);
        male.setBackground(new Color(106, 189, 189));
        add(male);
        female = new JRadioButton("Female");
        female.setBounds(370, 220, 90, 30);
        female.setFont(new Font("Serif", Font.BOLD, 20));
        female.setFocusable(false);
        female.setBackground(new Color(106, 189, 189));
        add(female);
        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);

        nationality = new JLabel("Nationality");
        nationality.setBounds(100, 280, 120, 30);
        nationality.setFont(new Font("Serif", Font.BOLD, 20));
        add(nationality);
        txtNat = new JTextField(10);
        txtNat.setBounds(270, 280, 200, 30);
        txtNat.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(txtNat);

        designation = new JLabel("Designation");
        designation.setBounds(100, 340, 120, 30);
        designation.setFont(new Font("Serif", Font.BOLD, 20));
        add(designation);
        txtDes = new JTextField(10);
        txtDes.setBounds(270, 340, 200, 30);
        txtDes.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(txtDes);

        joinDate = new JLabel("Joining Date");
        joinDate.setBounds(100, 400, 120, 30);
        joinDate.setFont(new Font("Serif", Font.BOLD, 20));
        add(joinDate);
        dateJoin = new JDateChooser();
        dateJoin.setBounds(270, 400, 200, 30);
        add(dateJoin);

        address = new JLabel("Address");
        address.setBounds(650, 100, 120, 30);
        address.setFont(new Font("Serif", Font.BOLD, 20));
        add(address);
        txtAdd = new JTextField(10);
        txtAdd.setBounds(790, 100, 200, 30);
        txtAdd.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(txtAdd);

        email = new JLabel("Email");
        email.setBounds(650, 160, 120, 30);
        email.setFont(new Font("Serif", Font.BOLD, 20));
        add(email);
        txtEmail = new JTextField(10);
        txtEmail.setBounds(790, 160, 200, 30);
        txtEmail.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(txtEmail);

        phoneNo = new JLabel("Phone No");
        phoneNo.setBounds(650, 220, 120, 30);
        phoneNo.setFont(new Font("Serif", Font.BOLD, 20));
        add(phoneNo);
        txtPh = new JTextField(10);
        txtPh.setBounds(790, 220, 200, 30);
        txtPh.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(txtPh);

        qualification = new JLabel("Qualification");
        qualification.setBounds(650, 280, 120, 30);
        qualification.setFont(new Font("Serif", Font.BOLD, 20));
        add(qualification);
        txtQual = new JTextField(10);
        txtQual.setBounds(790, 280, 200, 30);
        txtQual.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(txtQual);

        department = new JLabel("Department");
        department.setBounds(650, 340, 120, 30);
        department.setFont(new Font("Serif", Font.BOLD, 20));
        add(department);
        txtDept = new JTextField(10);
        txtDept.setBounds(790, 340, 200, 30);
        txtDept.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(txtDept);

        jobType = new JLabel("Job Type");
        jobType.setBounds(650, 400, 120, 30);
        jobType.setFont(new Font("Serif", Font.BOLD, 20));
        add(jobType);
        String[] types = {"Select a Job Type", "Full Time", "Part Time", "Contract"};
        job = new JComboBox<>(types);
        job.setBounds(790, 400, 200, 30);
        add(job);

        submit = new JButton("Submit");
        submit.setFocusable(false);
        submit.setBounds(380, 490, 100, 50);
        submit.setForeground(Color.BLACK);
        submit.setBackground(Color.WHITE);
        add(submit);
        submit.addActionListener(this);

        clear = new JButton("Clear");
        clear.setFocusable(false);
        clear.setBounds(510, 490, 100, 50);
        clear.setForeground(Color.BLACK);
        clear.setBackground(Color.WHITE);
        add(clear);
        clear.addActionListener(this);

        back = new JButton("Back");
        back.setFocusable(false);
        back.setBounds(640, 490, 100, 50);
        back.setForeground(Color.BLACK);
        back.setBackground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            int check = JOptionPane.showConfirmDialog(null, "Are you sure you want to add this record?",
                    "Add Information", JOptionPane.YES_NO_OPTION);
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
                String query = "INSERT INTO EmployeeData (name, date_of_birth, gender, nationality, designation, joining_date, " +
                        "address, email, phone, qualification, department,job_type) " +
                        "VALUES (?, STR_TO_DATE(?, '%b %d,%Y'), ?, ?, ?, STR_TO_DATE(?, '%b %d,%Y'), ?, ?, ?, ?, ?, ?)";
                //STR_TO_DATE() =Convert a string with a specific format to a DATE since I am not using typical sql date format
                //so this method is needed

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
                    preparedStatement.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Data inserted successfully!", "Data Info",
                            JOptionPane.INFORMATION_MESSAGE);
                    setVisible(false);
                    new Home();

                } catch (Exception exp) {
                    JOptionPane.showMessageDialog(null, "Couldn't Insert", "Data Info",
                            JOptionPane.INFORMATION_MESSAGE);
                    exp.printStackTrace();
                }

            } else {
                JOptionPane.showConfirmDialog(null, "Data not added!...",
                        "Add Information", JOptionPane.INFORMATION_MESSAGE);
            }


        } else if (e.getSource() == back) {
            setVisible(false);
            new Home();
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
}
