package EmployeeManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener {

    JButton add_emp, update, view, delete, logout, exit;

    Home() {
        setLayout(null);
        setBounds(200, 50, 1150, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icons/home.png"));
        Image img = image.getImage().getScaledInstance(1150, 700, Image.SCALE_DEFAULT);
        ImageIcon imageIcon = new ImageIcon(img);
        JLabel pic = new JLabel(imageIcon);
        pic.setBounds(0, 0, 1150, 700);
        add(pic);

        JLabel title = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        title.setBounds(350, 30, 1200, 60);
        title.setFont(new Font("Serif", Font.BOLD, 40));
        title.setForeground(Color.RED);
        pic.add(title);
        setVisible(true);

        add_emp = new JButton("1. Add Employee");
        add_emp.setBounds(350, 190, 300, 60);
        pic.add(add_emp);
        add_emp.setFont(new Font("Serif", Font.BOLD, 20));
        add_emp.setForeground(Color.WHITE);
        add_emp.setBackground(Color.BLACK);
        add_emp.setFocusable(false);
        add_emp.addActionListener(this);

        view = new JButton("2. View Employee");
        view.setBounds(700, 190, 300, 60);
        pic.add(view);
        view.setFont(new Font("Serif", Font.BOLD, 20));
        view.setForeground(Color.WHITE);
        view.setBackground(Color.BLACK);
        view.setFocusable(false);
        view.addActionListener(this);

        update = new JButton("3. Update Employee");
        update.setBounds(350, 300, 300, 60);
        pic.add(update);
        update.setFont(new Font("Serif", Font.BOLD, 20));
        update.setForeground(Color.WHITE);
        update.setBackground(Color.BLACK);
        update.setFocusable(false);
        update.addActionListener(this);

        delete = new JButton("4. Delete Employee");
        delete.setBounds(700, 300, 300, 60);
        pic.add(delete);
        delete.setFont(new Font("Serif", Font.BOLD, 20));
        delete.setForeground(Color.WHITE);
        delete.setBackground(Color.BLACK);
        delete.setFocusable(false);
        delete.addActionListener(this);

        logout = new JButton("Logout");
        logout.setBounds(820, 590, 120, 30);
        pic.add(logout);
        logout.setFocusable(false);
        logout.setFont(new Font("Serif", Font.BOLD, 20));
        logout.setBackground(Color.WHITE);
        logout.setForeground(Color.BLACK);
        logout.addActionListener(this);

        exit = new JButton("Exit");
        exit.setBounds(950, 590, 120, 30);
        pic.add(exit);
        exit.setFocusable(false);
        exit.setFont(new Font("Serif", Font.BOLD, 20));
        exit.setBackground(Color.WHITE);
        exit.setForeground(Color.RED);
        exit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add_emp) {
            setVisible(false);
            new AddEmp();
        } else if (e.getSource() == view) {
            setVisible(false);
            new ViewEmp();
        } else if (e.getSource() == update) {
            setVisible(false);
            new UpdateView();
        } else if (e.getSource() == delete) {
            setVisible(false);
            new RemoveEmp();
        } else if (e.getSource() == exit) {
            System.exit(0);
        } else {
            setVisible(false);
            new Login();
        }
    }
}
