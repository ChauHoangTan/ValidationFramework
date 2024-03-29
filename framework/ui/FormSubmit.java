package framework.ui;

import javax.swing.*;

import app.model.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import validation.Validations;
import validation.observerNotification.Observer;
import validation.strategyNotication.DialogStrategy;
import validation.strategyNotication.IStrategyNotication;
import validation.strategyNotication.OptionPaneStrategy;

public class FormSubmit extends JFrame implements Observer {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField ageField;
    private JTextField emailField;
    private JTextField phoneNumberField;

    private JLabel usernameMessage;
    private JLabel passwordMessage;
    private JLabel ageMessage;
    private JLabel emailMessage;
    private JLabel phoneNumberMessage;

    private int leftx = 100;
    private int lefty = 160;

    private int rightx = 250;
    private int righty = 160;
    private int righty2 = 190;

    private int step = 65;

    private IStrategyNotication notication;
    // private List<ErrorInfo> errorList; // delete

    public FormSubmit() {
        // errorList = new ArrayList<>();
        // setStrategy(new DialogStrategy());
        setStrategy(new OptionPaneStrategy());
        initComponents();
    }

    public void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel headerLabel = new JLabel("REGISTER FORM");
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        JLabel ageLabel = new JLabel("Age:");
        JLabel emailLabel = new JLabel("Email:");
        JLabel phoneNumberLabel = new JLabel("PhoneNumber:");

        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        ageField = new JTextField(15);
        emailField = new JTextField(15);
        phoneNumberField = new JTextField(15);

        usernameMessage = new JLabel("");
        passwordMessage = new JLabel("");
        ageMessage = new JLabel("");
        emailMessage = new JLabel("");
        phoneNumberMessage = new JLabel("");

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                register(); // tranfer data to validations
                // update(errorList); //strategy
            }
        });

        headerLabel.setFont(new Font("Arial", Font.BOLD, 30));

        usernameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 16));
        ageLabel.setFont(new Font("Arial", Font.BOLD, 16));
        emailLabel.setFont(new Font("Arial", Font.BOLD, 16));
        phoneNumberLabel.setFont(new Font("Arial", Font.BOLD, 16));

        usernameField.setFont(new Font("Arial", Font.PLAIN, 16));
        passwordField.setFont(new Font("Arial", Font.PLAIN, 16));
        ageField.setFont(new Font("Arial", Font.PLAIN, 16));
        emailField.setFont(new Font("Arial", Font.PLAIN, 16));
        phoneNumberField.setFont(new Font("Arial", Font.PLAIN, 16));

        usernameMessage.setForeground(Color.RED);
        passwordMessage.setForeground(Color.RED);
        ageMessage.setForeground(Color.RED);
        emailMessage.setForeground(Color.RED);
        phoneNumberMessage.setForeground(Color.RED);

        registerButton.setFont(new Font("Arial", Font.BOLD, 18));

        add(headerLabel);

        add(usernameLabel);
        add(passwordLabel);
        add(ageLabel);
        add(emailLabel);
        add(phoneNumberLabel);

        add(usernameField);
        add(passwordField);
        add(ageField);
        add(emailField);
        add(phoneNumberField);

        add(usernameMessage);
        add(passwordMessage);
        add(ageMessage);
        add(emailMessage);
        add(phoneNumberMessage);

        add(registerButton);

        headerLabel.setBounds(220, 70, 600, 60);
        usernameLabel.setBounds(leftx, lefty, 180, 35);
        passwordLabel.setBounds(leftx, lefty += step, 180, 35);
        ageLabel.setBounds(leftx, lefty += step, 180, 35);
        emailLabel.setBounds(leftx, lefty += step, 180, 35);
        phoneNumberLabel.setBounds(leftx, lefty += step, 180, 35);

        usernameField.setBounds(rightx, righty, 320, 35);
        passwordField.setBounds(rightx, righty += step, 320, 35);
        ageField.setBounds(rightx, righty += step, 60, 35);
        emailField.setBounds(rightx, righty += step, 320, 35);
        phoneNumberField.setBounds(rightx, righty += step, 320, 35);

        usernameMessage.setBounds(rightx, righty2, 400, 35);
        passwordMessage.setBounds(rightx, righty2 += step, 400, 35);
        ageMessage.setBounds(rightx, righty2 += step, 400, 35);
        emailMessage.setBounds(rightx, righty2 += step, 400, 35);
        phoneNumberMessage.setBounds(rightx, righty2 += step, 400, 35);

        registerButton.setBackground(Color.orange);
        registerButton.setOpaque(true);
        registerButton.setBounds(280, 520, 180, 35);

        setTitle("Register form");
        setSize(720, 720);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    private void register() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String age = ageField.getText();
        String email = emailField.getText();
        String phoneNumber = phoneNumberField.getText();

        User user = new User(username, password, age, phoneNumber, email);
        Validations validations = Validations.getInstance(); // tranfer
        validations.validates(user);

        // errorList = validations.validates(user);
        // System.out.println(errorList);
    }

    private String getMessageFromError(HashMap<String, String> list, String key){

        if (list.get(key) == null) 
            return null;
        String[] mes = list.get(key).split("\n");
        if (mes.length > 0 )
            return list.get(key).split("\n")[list.get(key).split("\n").length - 1];
        return null;

    }

    private void showMessage(HashMap<String, String> errorList) {

        usernameMessage.setText(getMessageFromError(errorList, "userName"));
        usernameMessage.setVisible(true);

        passwordMessage
                .setText(getMessageFromError(errorList, "password"));
        passwordMessage.setVisible(true);

        ageMessage.setText(getMessageFromError(errorList, "age"));
        ageMessage.setVisible(true);

        emailMessage.setText(getMessageFromError(errorList, "emailAddress"));
        emailMessage.setVisible(true);

        phoneNumberMessage.setText(getMessageFromError(errorList, "phoneNumber"));
        phoneNumberMessage.setVisible(true);
    }

    private void resetMessage() {
        usernameMessage.setText("");
        usernameMessage.setVisible(false);

        passwordMessage.setText("");
        passwordMessage.setVisible(false);

        ageMessage.setText("");
        ageMessage.setVisible(false);

        emailMessage.setText("");
        emailMessage.setVisible(false);

        phoneNumberMessage.setText("");
        phoneNumberMessage.setVisible(false);
    }

    public void setStrategy(IStrategyNotication newStrategy) {
        notication = newStrategy;
    }

    private String formatMesaage(HashMap<String, String> list) {
        String mess = "";
        for (Map.Entry<String, String> entry : list.entrySet()) {
            mess += (" - Field: " + entry.getKey() + ", Error: " + entry.getValue() + "\n");
        }
        if (mess == "")
            return "Register fail";
        return mess;
    }

    @Override
    public void update(HashMap<String, String> errorList) {
        resetMessage();
        if (errorList.size() == 0)
            notication.display("Register success");
        else {
            showMessage(errorList);
            notication.display(formatMesaage(errorList));
        }
        return;
    }
}
