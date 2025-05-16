package bank.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener {

    String pinnumber;
    JButton logout, home, about;

    MiniStatement(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        // Load background image
        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/mini.png"));
        Image i2 = i1.getImage().getScaledInstance(980, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 980, 700);
        add(image);

        // Window setup
        setSize(980, 700);
        setLocation(300, 0);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("MINI STATEMENT");

        JLabel text = new JLabel("MINI STATEMENT");
        text.setBounds(320, 120, 700, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("system", Font.BOLD, 32));
        image.add(text);
        
        // Labels for displaying card number, mini statement, and balance
        JLabel mini = new JLabel();
        mini.setBounds(200, 320, 600, 250);
        mini.setForeground(Color.white);
        mini.setFont(new Font("Monospaced", Font.BOLD, 18));
        image.add(mini);

        JLabel card = new JLabel();
        card.setBounds(150, 250, 500, 30);
        card.setForeground(Color.LIGHT_GRAY);
        card.setFont(new Font("Raleway", Font.BOLD, 16));
        image.add(card);

        JLabel balance = new JLabel();
        balance.setBounds(150, 210, 500, 20);
        balance.setForeground(Color.LIGHT_GRAY);
        balance.setFont(new Font("Raleway", Font.BOLD, 16));
        image.add(balance);

        // Fetch card number from database
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin ='" + pinnumber + "'");
            if (rs.next()) {
                card.setText("CARD NUMBER: " + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        // Fetch and display the last five transactions and current balance
        try {
            Conn conn = new Conn();
            int bal = 0;
            ResultSet rs = conn.s.executeQuery("select * from bank where pin ='" + pinnumber + "'");

            // Store transactions in a 2D array for the last five transactions
            String[][] transactions = new String[5][3];
            int count = 0;

            while (rs.next()) {
                // Move older transactions up and add new transaction at the end
                if (count >= 5) {
                    for (int i = 0; i < 4; i++) {
                        transactions[i] = transactions[i + 1];
                    }
                    count = 4;  // Ensure last position is used
                }
                transactions[count][0] = rs.getString("date");
                transactions[count][1] = rs.getString("type");
                transactions[count][2] = rs.getString("amont");

                // Keep track of balance
                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amont"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amont"));
                }

                count++;
            }

            // Build the HTML string for the last five transactions
            StringBuilder statement = new StringBuilder("<html>");
            for (int i = 0; i < count; i++) {
                statement.append(transactions[i][0]).append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                        .append(transactions[i][1]).append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                        .append(transactions[i][2]).append("<br><br>");
            }
            statement.append("</html>");

            // Display mini statement and current balance
            mini.setText(statement.toString());
            balance.setText("YOUR CURRENT ACCOUNT BALANCE IS RS. " + bal);

        } catch (Exception e) {
            System.out.println(e);
        }

        // Create navigation buttons
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
        if (ae.getSource() == logout) {
            setVisible(false);
            new Login().setVisible(true);
        } else if (ae.getSource() == home) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else if (ae.getSource() == about) {
            setVisible(false);
            new AboutUs(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new MiniStatement("");
    }
}
