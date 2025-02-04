package EmployeeManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {

    Main() {
        setLayout(null);
        setBounds(200, 50, 1200, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        JLabel title = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        title.setBounds(80, 30, 1200, 60);
        title.setFont(new Font("Serif", Font.PLAIN, 60));
        title.setForeground(Color.RED);
        add(title);

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image img = image.getImage().getScaledInstance(1200, 800, Image.SCALE_DEFAULT);
        ImageIcon imageIcon = new ImageIcon(img);
        JLabel pic = new JLabel(imageIcon);
        pic.setBounds(50, 100, 1100, 600);
        add(pic);

        JButton btn = new JButton("CLICK TO CONTINUE");
        btn.setBounds(420, 470, 270, 70);
        btn.setBackground(Color.WHITE);
        btn.setForeground(Color.BLACK);
        btn.setFocusable(false);
        pic.add(btn);
        btn.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
        new Main();
    }
}
