package bank.management.system;

import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.sql.*; 
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    GradientButton deposit, fastcash, pin, cashW, mini, balance;
    String pinnumber;
    JButton logout, home, about;

    FastCash(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/fastcash.png"));
        Image i2 = i1.getImage().getScaledInstance(980, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 980, 700);
        add(image);

      
        setSize(980, 700);
        setLocation(300, 0);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel text = new JLabel("SELECT WITHDRAWAL AMOUNT:");
        text.setBounds(280, 120, 700, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("system", Font.BOLD, 32));
        image.add(text);

        deposit = new GradientButton("100");
        deposit.setBounds(130, 340, 330, 50);
        deposit.addActionListener(this);
        image.add(deposit);

        fastcash = new GradientButton("500");
        fastcash.setBounds(130, 440, 330, 50);
        fastcash.addActionListener(this);
        image.add(fastcash);

        pin = new GradientButton("200");
        pin.setBounds(130, 540, 330, 50);
        pin.addActionListener(this);
        image.add(pin);

        // Right side buttons
        cashW = new GradientButton("2000");
        cashW.setBounds(520, 340, 330, 50);
        cashW.addActionListener(this);
        image.add(cashW);

        mini = new GradientButton("5000");
        mini.setBounds(520, 440, 330, 50);
        mini.addActionListener(this);
        image.add(mini);

        balance = new GradientButton("10000");
        balance.setBounds(520, 540, 330, 50);
        balance.addActionListener(this);
        image.add(balance);

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

  
    public String generateOTP() {
        Random rand = new Random();
        int otp = 100000 + rand.nextInt(900000); // Generate 6-digit OTP
        return String.valueOf(otp);
    }

    @Override

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
        } else {
      
        String amount = ((GradientButton) ae.getSource()).getText();
        
        Conn c = new Conn();
        try {
            ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pinnumber + "'");
            int balance = 0;

            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amont"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amont"));
                }
            }

          
            if (balance < Integer.parseInt(amount)) {
                JOptionPane.showMessageDialog(null, "Insufficient Balance");
                return;
            }

        
            Date date = new Date();
            String query = "INSERT INTO bank (pin, date, type, amont) VALUES ('" + pinnumber + "', '" + date + "', 'Withdraw', '" + amount + "')";
            c.s.executeUpdate(query);

         
            String otp = generateOTP();

          
            JOptionPane.showMessageDialog(null, "Rs " + amount + " Debited Successfully\nYour OTP is: " + otp + "\nVisit nearest JSS Bank ATM to withdraw.");

            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


    public static void main(String[] args) {
        new FastCash("");
    }
}

class GradientButton extends JButton {

    public GradientButton(String text) {
        super(text);
        setOpaque(false);  // Ensures that the button is transparent to show custom painting
        setContentAreaFilled(false);
        setFocusPainted(false);
        setFont(new Font("Arial", Font.BOLD, 25));
        setForeground(Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder());
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        int width = getWidth();
        int height = getHeight();

        // Create a gradient from blue to purple
        GradientPaint gradient = new GradientPaint(0, 0, new Color(70, 130, 180), width, height, new Color(128, 0, 128));
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, width, height);

        // Draw the button text and borders last to ensure they are visible
        super.paintComponent(g);
    }
}
