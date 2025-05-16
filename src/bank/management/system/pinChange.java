package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class pinChange extends JFrame implements ActionListener {

    JPasswordField newpin, rnewpin; // Keep it as JPasswordField to hide input
    JButton changePin, clear;
    String pinnumber;
    JButton logout, home, about;

    pinChange(String pinnumber) {
        this.pinnumber = pinnumber;

        setLayout(null);

        // Updated image loading
        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/pinchange.png"));
        Image i2 = i1.getImage().getScaledInstance(980, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 980, 700);
        add(image);

        // Window settings
        setSize(980, 700);
        setLocation(300, 0);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure the window closes properly

        JLabel text = new JLabel("Enter New Pin:");
        text.setFont(new Font("Osward", Font.BOLD, 18));
        text.setForeground(Color.WHITE);
        text.setBounds(80, 330, 450, 40);
        image.add(text);

        JLabel rtext = new JLabel("Re-Enter New Pin:");
        rtext.setFont(new Font("Osward", Font.BOLD, 18));
        rtext.setForeground(Color.WHITE);
        rtext.setBounds(60, 400, 450, 40);
        image.add(rtext);

        // Create password fields for new PIN (JPasswordField keeps it hidden)
        newpin = new JPasswordField();
        newpin.setFont(new Font("Raleway", Font.BOLD, 22));
        newpin.setBounds(235, 330, 280, 30);
        image.add(newpin);

        rnewpin = new JPasswordField();
        rnewpin.setFont(new Font("Raleway", Font.BOLD, 22));
        rnewpin.setBounds(235, 400, 280, 30);
        image.add(rnewpin);

        // Change PIN button
        changePin = new JButton("Change PIN");
        changePin.setBounds(180, 485, 150, 30);
        changePin.addActionListener(this);
        image.add(changePin);

        // Clear button
        clear = new JButton("Clear");
        clear.setBounds(350, 485, 150, 30);
        clear.addActionListener(this);
        image.add(clear);

        // Home button
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

        // Services label
        JLabel services = new JLabel("SERVICES");
        services.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 18));
        services.setForeground(Color.WHITE);
        services.setBounds(420, 20, 150, 30);
        image.add(services);

        // About Us button
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

        // Logout button
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == changePin) {
            try {
                // Convert the char array from JPasswordField to String
                String npin = new String(newpin.getPassword());
                String rpin = new String(rnewpin.getPassword());

                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }
                if (npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter PIN");
                    return;
                }
                if (rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Re-Enter new PIN");
                    return;
                }

                // Store the PIN as plain text in the database
                Conn conn = new Conn();
                String query1 = "UPDATE bank SET pin = '" + rpin + "' WHERE pin = '" + pinnumber + "'";
                String query2 = "UPDATE login SET pin = '" + rpin + "' WHERE pin = '" + pinnumber + "'";
                String query3 = "UPDATE signupthree SET pin = '" + rpin + "' WHERE pin = '" + pinnumber + "'";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");

                setVisible(false);
                new Transactions(rpin).setVisible(true);
            } catch (Exception ae) {
                ae.printStackTrace();
            }
        } else if (e.getSource() == clear) {
            newpin.setText(""); // Clear the text field
            rnewpin.setText(""); // Clear the re-enter text field
        } else if (e.getSource() == logout) {
            setVisible(false);
            new Login().setVisible(true); // Redirect to the Login page
        } else if (e.getSource() == home) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else if (e.getSource() == about) {
            setVisible(false);
            new AboutUs().setVisible(true);
        }
    }

    public static void main(String args[]) {
        new pinChange("");
    }
}
