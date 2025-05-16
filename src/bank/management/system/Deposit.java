package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    JTextField amount;
    JButton deposit, clear;
    String pinnumber;
    JButton logout, home, about;

    Deposit(String pinnumber) {
        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Deposit_1.png"));
        Image i2 = i1.getImage().getScaledInstance(980, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 980, 700);
        add(image);

     
        setSize(980, 700);
        setLocation(300, 0);
        setVisible(true);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(350, 380, 320, 40);
        image.add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(355, 485, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);

        clear = new JButton("Clear");
        clear.setBounds(520, 485, 150, 30);
        clear.addActionListener(this);
        image.add(clear);

        home = new JButton("HOME");
        home.setBounds(235, 20, 150, 30);
        home.setFont(new Font("Raleway", Font.CENTER_BASELINE, 18));
        home.setBackground(Color.LIGHT_GRAY);
        home.setForeground(Color.WHITE);
        home.setFocusPainted(false);
        home.setOpaque(false);
        home.setBorder(BorderFactory.createEmptyBorder());
        home.addActionListener(this);
        image.add(home);

        JLabel services = new JLabel("SERVICES");
        services.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 18));
        services.setForeground(Color.WHITE);
        services.setBounds(420, 20, 150, 30);
        image.add(services);

        about = new JButton("ABOUT US");
        about.setBounds(565, 20, 150, 30);
        about.setFont(new Font("Raleway", Font.CENTER_BASELINE, 18));
        about.setBackground(Color.LIGHT_GRAY);
        about.setForeground(Color.WHITE);
        about.setFocusPainted(false);
        about.setOpaque(false);
        about.setBorder(BorderFactory.createEmptyBorder());
        about.addActionListener(this);
        image.add(about);

        logout = new JButton("LOGOUT");
        logout.setBounds(735, 20, 150, 30);
        logout.setFont(new Font("Raleway", Font.CENTER_BASELINE, 18));
        logout.setBackground(Color.LIGHT_GRAY);
        logout.setForeground(Color.WHITE);
        logout.setFocusPainted(false);
        logout.setOpaque(false);
        logout.setBorder(BorderFactory.createEmptyBorder());
        logout.addActionListener(this);
        image.add(logout);

        //JLabel text = new JLabel("Checking pin number: " + pinnumber); // Correctly reference pinn
        //text.setForeground(Color.WHITE);
        //text.setFont(new Font("System", Font.BOLD, 16));
        //text.setBounds(170, 300, 400, 20);
        //image.add(text);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deposit) {
            String number = amount.getText();
            Date date = new Date();  

            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter the amount you want to deposit");
            } else {
                try {
                    Conn conn = new Conn();
                    String query = "INSERT INTO bank VALUES('" + pinnumber + "', '" + date + "', 'Deposit', '" + number + "')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + number + " Deposited Successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } else if (ae.getSource() == logout) {
            setVisible(false);
            new Login().setVisible(true);  
        } else if (ae.getSource() == home) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);  
        } else if (ae.getSource() == clear) {
            amount.setText("");
        } else if (ae.getSource() == about) {
            setVisible(false);
            new AboutUs(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Deposit("");   
    }
}
