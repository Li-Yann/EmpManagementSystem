package EmployeeManagementSystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class UpdateView extends JFrame implements ActionListener {
    JButton btnSearch, btnUpdate, back;
    JTextField txtSearch;
    JTable table;
    JScrollPane scrollPane;

    UpdateView() {
        setLayout(null);
        setBounds(200, 50, 1150, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(214, 232, 232));
        JLabel title = new JLabel("UPDATE EMPLOYEE RECORD");
        title.setBounds(300, 20, 1200, 60);
        title.setFont(new Font("Serif", Font.PLAIN, 40));
        add(title);

        table = new JTable();
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 280, 1100, 80);
        add(scrollPane);
        scrollPane.setVisible(false);
        JLabel search = new JLabel("Search ID");
        search.setBounds(420, 130, 120, 30);
        search.setFont(new Font("TimesNewRoman", Font.BOLD, 25));
        add(search);
        txtSearch = new JTextField(10);
        txtSearch.setBounds(550, 130, 100, 35);
        add(txtSearch);
        btnSearch = new JButton("Search");
        btnSearch.setBounds(540, 200, 100, 30);
        btnSearch.setFocusable(false);
        add(btnSearch);
        btnSearch.addActionListener(this);

        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(490, 390, 100, 30);
        btnUpdate.setFocusable(false);
        add(btnUpdate);
        btnUpdate.setVisible(false);
        btnUpdate.addActionListener(this);

        back = new JButton("Back");
        back.setBounds(430, 200, 100, 30);
        back.setFocusable(false);
        add(back);
        back.setVisible(true);
        back.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSearch) {
            int id = Integer.parseInt(txtSearch.getText());
            searchEmployeeById(id);

        } else if (e.getSource() == btnUpdate) {
            setVisible(false);
            int id = Integer.parseInt(txtSearch.getText());
            new UpdateEmp(id);

        } else {
            setVisible(false);
            new Home();
        }
    }

    public void displayData(String query) {

        DefaultTableModel model = (DefaultTableModel) table.getModel();// Clears the table before displaying new data
        model.setRowCount(0);  // Clear existing rows

        try {
            Connectivity connectivity = new Connectivity();
            Statement statement = connectivity.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int totalCols = resultSetMetaData.getColumnCount();
            String[] columnName = new String[totalCols];
            for (int i = 0; i < totalCols; i++) {
                columnName[i] = resultSetMetaData.getColumnName(i + 1);
                model.setColumnIdentifiers(columnName);
            }
            while (resultSet.next()) {
                Object[] rowValues = new Object[totalCols];
                for (int i = 0; i < totalCols; i++) {
                    rowValues[i] = resultSet.getObject(i + 1);
                }
                model.addRow(rowValues);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void searchEmployeeById(int id) {
        try {
            String query = "SELECT * FROM EmployeeData WHERE id=" + id;
            Connectivity connectivity = new Connectivity();
            Statement statement = connectivity.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if (!resultSet.next()) {
                scrollPane.setVisible(false);
                btnUpdate.setVisible(false);
                JOptionPane.showMessageDialog(this, "Employee with ID " + id + " not found.",
                        "Employee Not Found", JOptionPane.ERROR_MESSAGE);
            } else {
                displayData(query);
                scrollPane.setVisible(true);
                btnUpdate.setVisible(true);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}