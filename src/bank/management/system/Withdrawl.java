package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;

public class Withdrawl extends JFrame implements ActionListener {
    JTextField amount, acno, acname;
    JButton deposit, clear;
    String pinnumber;
    JButton logout, home, about;
    String retrievedPin ;
    Withdrawl(String pinnumber) {
    this.pinnumber = pinnumber;

    setLayout(null);

   
    ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/Pay.png"));
    Image i2 = i1.getImage().getScaledInstance(980, 700, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(0, 0, 980, 700);
    add(image);

   
    setSize(980, 700);
    setLocation(300, 0);
    setVisible(true);
        
        JLabel text = new JLabel("Enter details of the beneficiary:");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setForeground(Color.WHITE);  // Set text color to white
        text.setBounds(230, 120, 750, 50);
        image.add(text);
    
        acname = new JTextField();
        acname.setFont(new Font("Raleway", Font.BOLD, 22));
        acname.setBounds(380, 320, 320, 40);
        image.add(acname);
        
        JLabel accname = new JLabel("Account Holder: ");
        accname.setFont(new Font("Raleway", Font.BOLD, 22));
        accname.setForeground(Color.WHITE);
        accname.setBounds(180, 320, 320, 40);
        image.add(accname);
         
        acno = new JTextField();
        acno.setFont(new Font("Raleway", Font.BOLD, 22));
        acno.setBounds(380, 400, 320, 40);
        image.add(acno);
        
        JLabel accno = new JLabel("Account Number: ");
        accno.setFont(new Font("Raleway", Font.BOLD, 22));
        accno.setForeground(Color.WHITE);
        accno.setBounds(180, 400, 320, 40);
        image.add(accno);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(380, 480, 320, 40);
        image.add(amount);
        
        JLabel Amount = new JLabel("Enter Amount: ");
        Amount.setFont(new Font("Raleway", Font.BOLD, 22));
        Amount.setForeground(Color.WHITE);
        Amount.setBounds(180, 480, 320, 40);
        image.add(Amount);
        
        deposit = new JButton("Pay");
        deposit.setBounds(380, 550, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);

        clear = new JButton("Clear");
        clear.setBounds(555, 550, 150, 30);
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


    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deposit) {
            String number = amount.getText();
            String name = acname.getText();
            String Accountno = acno.getText();
            
            Date date = new Date(); 

            if (number.equals("")||name.equals("")||Accountno.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter all the Details ");
            } else {
                try {
                    Conn conn = new Conn();
                String queryPin = "SELECT pin FROM signupthree WHERE formno = '" + Accountno + "'"; 
                ResultSet rs = conn.s.executeQuery(queryPin);

                if (rs.next()) {
                    retrievedPin = rs.getString("pin"); 
                }
                    
                    String query1 = "INSERT INTO bank VALUES('" + pinnumber + "', '" + date + "', 'Withdraw', '" + number + "')";
                    String query2 = "INSERT INTO pay VALUES('" + name + "', '" + Accountno + "','" + number + "')";
                    String query3 = "INSERT INTO bank VALUES('" + retrievedPin + "', '" + date + "', 'Deposit', '" + number + "')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    conn.s.executeUpdate(query3);
                    JOptionPane.showMessageDialog(null, "Rs " + number + " Transfered Successfully");
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
        } else if (ae.getSource() == about) {
            setVisible(false);
            new AboutUs(pinnumber).setVisible(true);
        } else if (ae.getSource() == clear) {
            amount.setText("");
        }
    }

    public static void main(String[] args) {
        new Withdrawl("");   
    }
}
