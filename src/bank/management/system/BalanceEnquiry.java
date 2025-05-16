package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener {
    String pinnumber;
    JButton logout, home, about;

    BalanceEnquiry(String pinnumber) {
        this.pinnumber = pinnumber;

        setLayout(null);

     
        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/balance_1.png"));
        Image i2 = i1.getImage().getScaledInstance(980, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 980, 700);
        add(image);

        
        setSize(980, 700);
        setLocation(300, 0);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     
        
        Conn conn = new Conn();
        int balance = 0;
        try {
            
            ResultSet rs = conn.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pinnumber + "'");

            
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amont"));  
                } else {
                    balance -= Integer.parseInt(rs.getString("amont"));  
                }
            }
        } catch (Exception e) {
            System.out.println(e);  
        }

    
        JLabel balanceLabel = new JLabel("Your Current Balance:");
        balanceLabel.setFont(new Font("Osward", Font.BOLD, 32));
        balanceLabel.setForeground(Color.WHITE);
        balanceLabel.setBounds(160, 330, 400, 40);
        image.add(balanceLabel);

        JLabel balanceValue = new JLabel(" Rs. " + balance);
        balanceValue.setFont(new Font("Raleway", Font.BOLD, 30));
        balanceValue.setForeground(Color.BLACK);
        balanceValue.setBounds(270, 415, 200, 40);
        image.add(balanceValue);

     
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

    
        /*JLabel pinlabel = new JLabel("Checking pin number: " + pinnumber);
        pinlabel.setForeground(Color.WHITE);
        pinlabel.setFont(new Font("System", Font.BOLD, 16));
        pinlabel.setBounds(170, 220, 400, 20);
        image.add(pinlabel);*/
    }

    public void actionPerformed(ActionEvent ac) {
        if (ac.getSource() == logout) {
            setVisible(false);
            new Login().setVisible(true);  
        } else if (ac.getSource() == home) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);  
        } else if (ac.getSource() == about) {
            setVisible(false);
            new AboutUs(pinnumber).setVisible(true);  
        }
    }

    public static void main(String args[]) {
        new BalanceEnquiry(""); 
    }
}

