package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AboutUs extends JFrame implements ActionListener {

    JButton logout, home, about;
    String pinnumber ;
    AboutUs(String pinnumber) {
      this.pinnumber = pinnumber;
        setLayout(null);

       
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/team.png"));
        Image i2 = i1.getImage().getScaledInstance(980, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 980, 700);
        add(image);

        // Window settings
        setSize(980, 700);
        setLocation(300, 0);
        setVisible(true);

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
        image.add(logout);}

    // Event handling for buttons
    public void actionPerformed(ActionEvent ac){

        if (ac.getSource() == logout) {
            setVisible(false);
            new Login().setVisible(true);  
        } else if (ac.getSource() == home) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);  
        }
    }

    public static void main(String[] args) {
        new AboutUs("");
    }
}
