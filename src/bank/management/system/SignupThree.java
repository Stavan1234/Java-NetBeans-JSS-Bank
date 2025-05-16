package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {

    JButton submit, cancel;
    JRadioButton AcT1, AcT2, AcT3, AcT4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    String formno;

    public SignupThree(String formno) {

        this.formno = formno;
        setLayout(null);

        GradientPanel gradientPanel = new GradientPanel();
        gradientPanel.setLayout(null);
        setContentPane(gradientPanel);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");

        JLabel additionalDetails = new JLabel("Page 3: Account Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 50, 400, 30);
        additionalDetails.setForeground(Color.WHITE);
        add(additionalDetails);

        JLabel type = new JLabel("Account Type:");
        type.setFont(new Font("Raleway", Font.BOLD, 20));
        type.setBounds(100, 110, 200, 30);
        type.setForeground(Color.WHITE);
        add(type);

        AcT1 = new JRadioButton("Saving Account");
        AcT1.setBounds(100, 140, 190, 25);
        AcT1.setBackground(Color.LIGHT_GRAY);
        add(AcT1);

        AcT2 = new JRadioButton("Fixed Deposit Account");
        AcT2.setBounds(300, 140, 190, 25);
        AcT2.setBackground(Color.LIGHT_GRAY);
        add(AcT2);

        AcT3 = new JRadioButton("Current Account");
        AcT3.setBounds(100, 170, 190, 25);
        AcT3.setBackground(Color.LIGHT_GRAY);
        add(AcT3);

        AcT4 = new JRadioButton("Recurring Deposit Account");
        AcT4.setBounds(300, 170, 190, 25);
        AcT4.setBackground(Color.LIGHT_GRAY);
        add(AcT4);

        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(AcT1);
        groupaccount.add(AcT2);
        groupaccount.add(AcT3);
        groupaccount.add(AcT4);

        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("Raleway", Font.BOLD, 20));
        card.setBounds(100, 230, 200, 30);
        card.setForeground(Color.WHITE);
        add(card);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-4321");
        number.setFont(new Font("Raleway", Font.BOLD, 20));
        number.setBounds(330, 230, 300, 30);
        number.setForeground(Color.WHITE);
        add(number);

        JLabel cardinfo = new JLabel("Your 16 Digit Card Number");
        cardinfo.setFont(new Font("Raleway", Font.BOLD, 12));
        cardinfo.setBounds(100, 260, 300, 20);
        cardinfo.setForeground(Color.WHITE);
        add(cardinfo);

        JLabel pin = new JLabel("Pin:");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(100, 300, 200, 30);
        pin.setForeground(Color.WHITE);
        add(pin);

        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 20));
        pnumber.setBounds(330, 300, 300, 30);
        pnumber.setForeground(Color.WHITE);
        add(pnumber);

        JLabel pininfo = new JLabel("Your 4 Digit Password");
        pininfo.setFont(new Font("Raleway", Font.BOLD, 12));
        pininfo.setBounds(100, 330, 300, 20);
        pininfo.setForeground(Color.WHITE);
        add(pininfo);

        JLabel service = new JLabel("Services Required: ");
        service.setFont(new Font("Raleway", Font.BOLD, 20));
        service.setBounds(100, 390, 300, 30);
        service.setForeground(Color.WHITE);
        add(service);

        c1 = new JCheckBox("ATM Card");
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100, 420, 200, 30);
        c1.setBackground(Color.LIGHT_GRAY);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(320, 420, 200, 30);
        c2.setBackground(Color.LIGHT_GRAY);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(100, 460, 200, 30);
        c3.setBackground(Color.LIGHT_GRAY);
        add(c3);

        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(320, 460, 200, 30);
        c4.setBackground(Color.LIGHT_GRAY);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(100, 500, 200, 30);
        c5.setBackground(Color.LIGHT_GRAY);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(320, 500, 200, 30);
        c6.setBackground(Color.LIGHT_GRAY);
        add(c6);

        c7 = new JCheckBox("I hereby declare above details are correct to the best of my knowledge.");
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBounds(100, 580, 500, 30);
        c7.setBackground(Color.LIGHT_GRAY);
        c7.setForeground(Color.WHITE);
        c7.setOpaque(false);
        c7.setBackground(null);
        c7.setFocusPainted(false);
        add(c7);

        submit = new JButton("Submit");
        submit.setBounds(380, 630, 100, 30);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBackground(new Color(200, 30, 200));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(220, 630, 100, 30);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBackground(new Color(200, 30, 200));
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.LIGHT_GRAY);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }
    
        public class GradientPanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            GradientPaint gradient = new GradientPaint(0, 0, Color.BLACK, getWidth(), getHeight(), new Color(128, 0, 128)); // Purple
            g2d.setPaint(gradient);
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String accountType = null;
            if (AcT1.isSelected()) {
                accountType = "Saving Account";
            } else if (AcT2.isSelected()) {
                accountType = "Fixed Deposit Account";
            } else if (AcT3.isSelected()) {
                accountType = "Current Account";
            } else if (AcT4.isSelected()) {
                accountType = "Recurring Deposit Account";
            }

            Random random = new Random();
            String cardnumber = String.format("%016d", Math.abs(random.nextLong() % 10000000000000000L));
            String pin = String.format("%04d",Math.abs(random.nextInt(9000) + 1000));

            String facility = "";
            if (c1.isSelected()) facility += "ATM Card ";
            if (c2.isSelected()) facility += "Internet Banking ";
            if (c3.isSelected()) facility += "Mobile Banking ";
            if (c4.isSelected()) facility += "Email & SMS Alerts ";
            if (c5.isSelected()) facility += "Cheque Book ";
            if (c6.isSelected()) facility += "E-Statement ";

            try {
                if (accountType == null) {
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                } else {
                    // Commenting out the database connection for now
                    Conn conn = new Conn();
                    String query1 = "insert into signupthree values('" + formno + "','" + accountType + "','" + cardnumber + "','" + pin + "','" + facility + "')";
                    String query2 = "insert into login values('" + formno + "','" + cardnumber + "','" + pin + "')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    
                    
                    JOptionPane.showMessageDialog(null, "Card Number:" + cardnumber + "\n Pin:" + pin);
                    
                    setVisible(false);
                    new Login().setVisible(true);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new SignupThree("");
    }
}
