package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.sql.*;  

public class SignupOne extends JFrame implements ActionListener {

    Long random;
    JTextField nameTextField, fathersnameTextField, dobnameTextField, edTextField, addressTextField, cityTextField, pincodeTextField, stateTextField;
    JButton next;
    JRadioButton male, female, other, married, unmarried;

    public SignupOne() {

        setLayout(null);
        
        GradientPanel gradientPanel = new GradientPanel();
        gradientPanel.setLayout(null);
        setContentPane(gradientPanel);

        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        JLabel formno = new JLabel("Application Form No: " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140, 20, 600, 40);
        formno.setForeground(Color.WHITE);
        add(formno);

        JLabel personaldetails = new JLabel("Page 1: Personal Details");
        personaldetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personaldetails.setBounds(290, 80, 400, 30);
        personaldetails.setForeground(Color.WHITE);
        add(personaldetails);

        JLabel name = new JLabel("Name");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        name.setForeground(Color.WHITE);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(300, 140, 400, 30);
        nameTextField.setBorder(BorderFactory.createEmptyBorder());
        add(nameTextField);

        JLabel fathersname = new JLabel("Father’s Name");
        fathersname.setFont(new Font("Raleway", Font.BOLD, 20));
        fathersname.setBounds(100, 190, 200, 30);
        fathersname.setForeground(Color.WHITE);
        add(fathersname);

        fathersnameTextField = new JTextField();
        fathersnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        fathersnameTextField.setBounds(300, 190, 400, 30);
        fathersnameTextField.setBorder(BorderFactory.createEmptyBorder());
        add(fathersnameTextField);

        JLabel dob = new JLabel("Date of Birth");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        dob.setForeground(Color.WHITE);
        add(dob);

        dobnameTextField = new JTextField("DD/MM/YYYY");
        dobnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        dobnameTextField.setBounds(300, 240, 400, 30);
        dobnameTextField.setBorder(BorderFactory.createEmptyBorder());
        add(dobnameTextField);

        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        gender.setForeground(Color.WHITE);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300, 290, 160, 30);
        male.setBackground(Color.LIGHT_GRAY);
        male.setBorder(BorderFactory.createEmptyBorder());
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(460, 290, 160, 30);
        female.setBackground(Color.LIGHT_GRAY);
        female.setBorder(BorderFactory.createEmptyBorder());
        add(female);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        JLabel ed = new JLabel("Email Address");
        ed.setFont(new Font("Raleway", Font.BOLD, 20));
        ed.setBounds(100, 340, 200, 30);
        ed.setForeground(Color.WHITE);
        add(ed);

        edTextField = new JTextField();
        edTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        edTextField.setBounds(300, 340, 400, 30);
        edTextField.setBorder(BorderFactory.createEmptyBorder());
        add(edTextField);

        JLabel ms = new JLabel("Marital Status");
        ms.setFont(new Font("Raleway", Font.BOLD, 20));
        ms.setBounds(100, 390, 200, 30);
        ms.setForeground(Color.WHITE);
        add(ms);

        married = new JRadioButton("Married");
        married.setBounds(300, 390, 160, 30);
        married.setBackground(Color.LIGHT_GRAY);
        married.setBorder(BorderFactory.createEmptyBorder());
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(460, 390, 160, 30);
        unmarried.setBackground(Color.LIGHT_GRAY);
        unmarried.setBorder(BorderFactory.createEmptyBorder());
        add(unmarried);

        other = new JRadioButton("Other");
        other.setBounds(620, 390, 80, 30);
        other.setBackground(Color.LIGHT_GRAY);
        add(other);

        ButtonGroup msGroup = new ButtonGroup();
        msGroup.add(married);
        msGroup.add(unmarried);
        msGroup.add(other);

        JLabel address = new JLabel("Address");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        address.setForeground(Color.WHITE);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTextField.setBounds(300, 440, 400, 30);
        addressTextField.setBorder(BorderFactory.createEmptyBorder());
        add(addressTextField);

        JLabel city = new JLabel("City");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        city.setForeground(Color.WHITE);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField);

        JLabel pincode = new JLabel("Pincode");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 540, 200, 30);
        pincode.setForeground(Color.WHITE);
        add(pincode);

        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pincodeTextField.setBounds(300, 540, 400, 30);
        pincodeTextField.setBorder(BorderFactory.createEmptyBorder());
        add(pincodeTextField);

        JLabel state = new JLabel("State");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 590, 200, 30);
        state.setForeground(Color.WHITE);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        stateTextField.setBounds(300, 590, 100, 30);
        stateTextField.setBorder(BorderFactory.createEmptyBorder());
        add(stateTextField);

        next = new JButton("Next");
        next.setBounds(600, 620, 100, 30);
        next.setFont(new Font("Times New Roman", Font.BOLD, 18));
        next.setBackground(new Color(200, 30, 200));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public class GradientPanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            // Create a gradient from black (top-left) to purple (bottom-right)
            GradientPaint gradient = new GradientPaint(0, 0, new Color(0, 0, 50), getWidth(), getHeight(), new Color(128, 0, 128)); // Purple
            g2d.setPaint(gradient);
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }
    }

    public void actionPerformed(ActionEvent e) {
        String formno = "" + random;
        String name = nameTextField.getText();
        String fathersname = fathersnameTextField.getText();
        String dob = dobnameTextField.getText();
        String gender = null;

        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }

        String ms = null;
        if (married.isSelected()) {
            ms = "Married";
        } else if (unmarried.isSelected()) {
            ms = "Unmarried";
        } else if (other.isSelected()) {
            ms = "Other";
        }

        String ed = edTextField.getText();
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String pincode = pincodeTextField.getText();
        String state = stateTextField.getText();

        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is required");
            } else {
                Conn c = new Conn();  // Ensure you have this class defined
                String query = "INSERT INTO signup VALUES('" + formno + "','" + name + "','" + fathersname + "','" + dob + "','" + gender + "','" + ed + "','" + ms + "','" + address + "','" + city + "','" + pincode + "','" + state + "')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        } catch (HeadlessException | SQLException ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
        new SignupOne();
    }
}
