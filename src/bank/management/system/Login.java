package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login, register, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;

    Login() {
        setTitle("Welcome To Our Online Bank Services");
        setLayout(null);

        GradientPanel gradientPanel = new GradientPanel();
        gradientPanel.setLayout(null);
        setContentPane(gradientPanel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(170, 120, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(10, 10, 170, 120);
        add(label);

        JLabel text = new JLabel("Welcome To Our Bank");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setForeground(Color.WHITE);
        text.setBounds(200, 40, 450, 40);
        add(text);

        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 38));
        cardno.setForeground(Color.WHITE);
        cardno.setBounds(120, 150, 200, 40);
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(320, 154, 250, 40);
        cardTextField.setBackground(Color.LIGHT_GRAY);
        cardTextField.setForeground(Color.BLACK);
        cardTextField.setBorder(BorderFactory.createEmptyBorder());
        add(cardTextField);

        JLabel pin = new JLabel("Pin:");
        pin.setFont(new Font("Raleway", Font.BOLD, 38));
        pin.setForeground(Color.WHITE);
        pin.setBounds(120, 220, 150, 40);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(320, 224, 250, 40);
        pinTextField.setBackground(Color.LIGHT_GRAY);
        pinTextField.setForeground(Color.BLACK);
        pinTextField.setBorder(BorderFactory.createEmptyBorder());
        add(pinTextField);

        login = new JButton("Sign In");
        login.setBounds(320, 300, 100, 30);
        login.setBackground(new Color(153, 50, 204));
        login.setForeground(Color.WHITE);
        login.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        login.addActionListener(this);
        add(login);

        clear = new JButton("Clear");
        clear.setBounds(470, 300, 100, 30);
        clear.setBackground(new Color(153, 50, 204));
        clear.setForeground(Color.WHITE);
        clear.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        clear.addActionListener(this);
        add(clear);

        register = new JButton("Sign Up");
        register.setBounds(320, 340, 251, 30);
        register.setBackground(new Color(153, 50, 204));
        register.setForeground(Color.WHITE);
        register.setFocusPainted(false);
        register.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        register.addActionListener(this);
        add(register);

        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);
    }

    public class GradientPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            GradientPaint gradient = new GradientPaint(0, 0, Color.BLACK, getWidth(), getHeight(), new Color(128, 0, 128));
            g2d.setPaint(gradient);
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }
    }

    public void actionPerformed(ActionEvent ac) {
        if (ac.getSource() == clear) {
            cardTextField.setText("");
            pinTextField.setText("");
        } else if (ac.getSource() == login) {
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "SELECT * FROM login WHERE cardnumber = '" + cardnumber + "' AND pin = '" + pinnumber + "'";
            try {
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);  // Pass the correct pin number
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ac.getSource() == register) {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }

    public static void main(String args[]) {
        new Login();
    }
}
