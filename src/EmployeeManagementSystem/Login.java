package EmployeeManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JTextField txtUserName;
    JPasswordField txtPassword;
    JButton button, clear;

    Login() {
        setLayout(null);
        setBounds(450, 200, 600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);

        JLabel username = new JLabel("Username:");
        username.setBounds(70, 70, 80, 30);
        txtUserName = new JTextField(20);
        txtUserName.setBounds(150, 70, 150, 30);
        JLabel password = new JLabel("Password:");
        password.setBounds(70, 120, 80, 30);
        txtPassword = new JPasswordField(20);
        txtPassword.setBounds(150, 120, 150, 30);
        add(username);
        add(txtUserName);
        add(password);
        add(txtPassword);
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icons/cred.jpg"));
        Image img = image.getImage().getScaledInstance(280, 280, Image.SCALE_DEFAULT);
        ImageIcon imageIcon = new ImageIcon(img);
        JLabel pic = new JLabel(imageIcon);
        pic.setBounds(300, 0, 280, 280);
        add(pic);
        button = new JButton("Login");
        button.setFocusable(false);
        button.setBounds(80, 180, 100, 30);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLACK);
        add(button);
        button.addActionListener(this);
        clear = new JButton("Clear");
        clear.setFocusable(false);
        clear.setBounds(190, 180, 100, 30);
        clear.setForeground(Color.WHITE);
        clear.setBackground(Color.BLACK);
        add(clear);
        clear.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            try {
                String user = txtUserName.getText();
                String pass = new String(txtPassword.getPassword());

                Connectivity connectivity = new Connectivity();
                String query = "SELECT * FROM login WHERE username = ? AND password = ?";
                PreparedStatement preparedStatement = connectivity.con.prepareStatement(query);
                preparedStatement.setString(1, user);
                preparedStatement.setString(2, pass);

                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    setVisible(false);
                    new Home();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password",
                            "Wrong Credentials", JOptionPane.ERROR_MESSAGE);
                    txtUserName.setText("");
                    txtPassword.setText("");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            txtUserName.setText("");
            txtPassword.setText("");
        }
    }
}
