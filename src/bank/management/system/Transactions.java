package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {

    JButton logout, home, about;
    GradientButton deposit, fastcash, pin, cashW, mini, balance;
    String pinnumber ;
    Transactions(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

  
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Landing_Page .jpg"));
        Image i2 = i1.getImage().getScaledInstance(980, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 980, 700);
        add(image);

        setSize(980, 700);
        setLocation(300, 0);
        setVisible(true);

        JLabel text = new JLabel("Please Select Your Transaction");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setForeground(Color.WHITE); 
        text.setBounds(230, 150, 750, 50);
        image.add(text);

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

        deposit = new GradientButton("Deposit");
        deposit.setBounds(150, 300, 330, 50);
        deposit.addActionListener(this);
        image.add(deposit);

        fastcash = new GradientButton("Fast Cash");
        fastcash.setBounds(150, 400, 330, 50);
        fastcash.addActionListener(this);
        image.add(fastcash);

        pin = new GradientButton("Pin Change");
        pin.setBounds(150, 500, 330, 50);
        pin.addActionListener(this);
        image.add(pin);

        cashW = new GradientButton("Payment/Transfer");
        cashW.setBounds(540, 300, 330, 50);
        cashW.addActionListener(this);
        image.add(cashW);

        mini = new GradientButton("Mini Statement");
        mini.setBounds(540, 400, 330, 50);
        mini.addActionListener(this);
        image.add(mini);

        balance = new GradientButton("Balance Enquiry");
        balance.setBounds(540, 500, 330, 50);
        balance.addActionListener(this);
        image.add(balance);
        
        //JLabel pinlabel = new JLabel("Checking pin number: " + pinnumber); // Correctly reference pinn
        //pinlabel.setForeground(Color.WHITE);
        //pinlabel.setFont(new Font("System", Font.BOLD, 16));
        //pinlabel.setBounds(170, 220, 400, 20);
        //image.add(pinlabel);
    }

    public class GradientButton extends JButton {

        public GradientButton(String text) {
            super(text);
            setOpaque(false); 
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

            GradientPaint gradient = new GradientPaint(0, 0, new Color(70, 130, 180), width, height, new Color(128, 0, 128));
            g2d.setPaint(gradient);
            g2d.fillRect(0, 0, width, height);

            super.paintComponent(g);
        }
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
        } else if (ac.getSource() == deposit) {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if(ac.getSource() == fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }else if(ac.getSource() == pin){
            setVisible(false);
            new pinChange(pinnumber).setVisible(true);
        }else if(ac.getSource() == cashW){
              setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }else if(ac.getSource() == mini){
                      setVisible(false);
            new MiniStatement(pinnumber).setVisible(true);
        }else if(ac.getSource() == balance){
               setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Transactions("");
    }
}
