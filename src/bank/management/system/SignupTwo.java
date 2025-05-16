package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class SignupTwo extends JFrame implements ActionListener {

    JTextField panTextField, aadharTextField;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religionBox, categoryBox, incomeBox, educationBox, occupationBox;
    String formno;

    public SignupTwo(String formno) {
        this.formno = formno;
        setLayout(null);
        
        GradientPanel gradientPanel = new GradientPanel();
        gradientPanel.setLayout(null);
        setContentPane(gradientPanel);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 50, 400, 30);
        additionalDetails.setForeground(Color.WHITE);
        add(additionalDetails);

        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(100, 110, 100, 30);
        religion.setForeground(Color.WHITE);
        add(religion);

        String[] valReligion = {"Christian", "Muslim", "Sikh", "Hindu", "Other"};
        religionBox = new JComboBox(valReligion);
        religionBox.setBounds(300, 110, 400, 30);
        religionBox.setBackground(Color.WHITE);
        add(religionBox);

        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(100, 170, 200, 30);
        category.setForeground(Color.WHITE);
        add(category);

        String[] valCategory = {"General", "OBC", "SC", "ST", "Other"};
        categoryBox = new JComboBox(valCategory);
        categoryBox.setBounds(300, 170, 400, 30);
        categoryBox.setBackground(Color.WHITE);
        add(categoryBox);

        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100, 230, 200, 30);
        income.setForeground(Color.WHITE);
        add(income);

        String[] incomeCategory = {"None", "<2,00,000", "<5,00,000", "<8,00,000", "<10,00,000"};
        incomeBox = new JComboBox(incomeCategory);
        incomeBox.setBounds(300, 230, 400, 30);
        incomeBox.setBackground(Color.WHITE);
        add(incomeBox);

        JLabel education = new JLabel("Educational ");
        education.setFont(new Font("Raleway", Font.BOLD, 20));
        education.setBounds(100, 280, 400, 30);
        education.setForeground(Color.WHITE);
        add(education);
        
        JLabel Qaulification = new JLabel("Qaulification:");
        Qaulification.setFont(new Font("Raleway", Font.BOLD, 20));
        Qaulification.setBounds(100, 310, 400, 30);
        Qaulification.setForeground(Color.WHITE);
        add(Qaulification);
        


        String[] educationValues = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctorate", "Others"};
        educationBox = new JComboBox(educationValues);
        educationBox.setBounds(300, 305, 400, 30);
        educationBox.setBackground(Color.WHITE);
        add(educationBox);

        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100, 360, 200, 30);
        occupation.setForeground(Color.WHITE);
        add(occupation);

        String[] occupationValues = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Others"};
        occupationBox = new JComboBox(occupationValues);
        occupationBox.setBounds(300, 360, 400, 30);
        occupationBox.setBackground(Color.WHITE);
        add(occupationBox);

        JLabel pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100, 400, 200, 30);
        pan.setForeground(Color.WHITE);
        add(pan);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panTextField.setBounds(300, 400, 400, 30);
        add(panTextField);

        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhar.setBounds(100, 440, 200, 30);
        aadhar.setForeground(Color.WHITE);
        add(aadhar);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharTextField.setBounds(300, 440, 400, 30);
        add(aadharTextField);

        JLabel seniorCitizen = new JLabel("Senior Citizen:");
        seniorCitizen.setFont(new Font("Raleway", Font.BOLD, 20));
        seniorCitizen.setBounds(100, 490, 200, 30);
        seniorCitizen.setForeground(Color.WHITE);
        add(seniorCitizen);

        syes = new JRadioButton("Yes");
        syes.setBounds(300, 490, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450, 490, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup seniorCitizenGroup = new ButtonGroup();
        seniorCitizenGroup.add(syes);
        seniorCitizenGroup.add(sno);

        JLabel existingAccount = new JLabel("Existing Account:");
        existingAccount.setFont(new Font("Raleway", Font.BOLD, 20));
        existingAccount.setBounds(100, 540, 200, 30);
        existingAccount.setForeground(Color.WHITE);
        add(existingAccount);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 540, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450, 540, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup existingAccountGroup = new ButtonGroup();
        existingAccountGroup.add(eyes);
        existingAccountGroup.add(eno);

        next = new JButton("Next");
        next.setBounds(620, 600, 80, 30);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBackground(new Color(200, 30, 200));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    SignupTwo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

    public void actionPerformed(ActionEvent e) {
        String religion = (String) religionBox.getSelectedItem();
        String category = (String) categoryBox.getSelectedItem();
        String income = (String) incomeBox.getSelectedItem();
        String education = (String) educationBox.getSelectedItem();
        String occupation = (String) occupationBox.getSelectedItem();
        String pan = panTextField.getText();
        String aadhar = aadharTextField.getText();
        String seniorCitizen = syes.isSelected() ? "Yes" : "No";
        String existingAccount = eyes.isSelected() ? "Yes" : "No";

        try {
            if (pan.equals("")) {
                JOptionPane.showMessageDialog(null, "PAN Number is Required");
            } else {
                Conn c = new Conn();
                String query = "INSERT INTO signuptwo VALUES('" + formno + "','" + religion + "','" + category + "','" + income + "','" + education + "','" + occupation + "','" + pan + "','" + aadhar + "','" + seniorCitizen + "','" + existingAccount + "')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
        new SignupTwo("");
    }
}
