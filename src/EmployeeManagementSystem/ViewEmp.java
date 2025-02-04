package EmployeeManagementSystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class ViewEmp extends JFrame implements ActionListener {

    JButton btnSearch,back,print;
    JTextField txtSearch;
    JTable table;
    String query;

    ViewEmp() {
        setLayout(null);
        setBounds(200, 50, 1150, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(214, 232, 232));
        JLabel title = new JLabel("EMPLOYEE DETAILS");
        title.setBounds(400, 20, 1200, 60);
        title.setFont(new Font("Serif", Font.PLAIN, 40));
        add(title);

        JLabel search = new JLabel("Search ID");
        search.setBounds(20, 90, 120, 30);
        search.setFont(new Font("TimesNewRoman", Font.BOLD, 15));
        add(search);
        txtSearch = new JTextField(10);
        txtSearch.setBounds(20, 120, 100, 30);
        add(txtSearch);
        btnSearch = new JButton("Search");
        btnSearch.setBounds(130, 120, 100, 30);
        btnSearch.setFocusable(false);
        add(btnSearch);
        btnSearch.addActionListener(this);


        back = new JButton("Back");
        back.setBounds(250, 120, 100, 30);
        back.setFocusable(false);
        add(back);
        back.addActionListener(this);

        print = new JButton("Print");
        print.setBounds(520, 600, 100, 30);
        print.setFocusable(false);
        add(print);
        print.addActionListener(this);



        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 180, 1100, 400);
        add(scrollPane);
        query = "SELECT * FROM EmployeeData";
        displayData(query);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSearch) {
            int id = Integer.parseInt(txtSearch.getText());
            searchEmployeeById(id);
        } else if(e.getSource()==print){
            try{
            table.print();
            } catch (PrinterException ex) {
                throw new RuntimeException(ex);
            }
        }else{
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

    public  void searchEmployeeById(int id) {
        try {
            String query = "SELECT * FROM EmployeeData WHERE id=" + id;
            Connectivity connectivity = new Connectivity();
            Statement statement = connectivity.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if (!resultSet.next()) {
                JOptionPane.showMessageDialog(this, "Employee with ID " + id + " not found.",
                        "Employee Not Found", JOptionPane.ERROR_MESSAGE);
            } else {
                displayData(query);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
