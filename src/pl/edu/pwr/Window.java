package pl.edu.pwr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Window extends JFrame {

    private final Color DefaultBackgroundColor = Color.WHITE;
    private int failLoginCounter = 0;

    JTextField usernameField;
    JPasswordField passwordField;

    public Window() throws HeadlessException {
        this("undefined");
    }

    public Window(String title) throws HeadlessException {
        super(title);
        buildFrame();
    }

    protected void buildFrame(){
        setBounds(100, 100, 450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        changeBackgroundColor(DefaultBackgroundColor);

        createFields();
        createButtons();
    }

    private void changeBackgroundColor(Color color){
        getContentPane().setBackground(color);
    }

    private void createFields(){
        usernameField = new JTextField(28);
        passwordField = new JPasswordField(28);

        JLabel usernameLabel = new JLabel("User name:");
        JLabel passwordLabel = new JLabel("Password:");

        usernameLabel.setLabelFor(usernameField);
        passwordLabel.setLabelFor(passwordField);

        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
    }

    private void createButtons(){
        JPanel buttonsPanel = new JPanel(new FlowLayout());

        JButton loginBtn = new JButton("Log in");
        JButton clearBtn = new JButton("Clear");

        loginBtn.addActionListener(this::loginBtnActionPerformed);
        clearBtn.addActionListener(this::clearBtnActionPerformed);

        buttonsPanel.add(loginBtn);
        buttonsPanel.add(clearBtn);

        add(buttonsPanel);
    }

    private void loginBtnActionPerformed(ActionEvent actionEvent){
        if (Database.login(usernameField.getText(), passwordField.getPassword())){
            changeBackgroundColor(Color.GREEN);
        }else {
            failLoginCounter++;
            changeBackgroundColor(Color.RED);
        };

        //if 3 failed attempts in a row - close window
        if(failLoginCounter >= 3){
            this.dispose();
        }
    }

    private void clearBtnActionPerformed(ActionEvent actionEvent){
        failLoginCounter = 0;
        usernameField.setText("");
        passwordField.setText("");
        changeBackgroundColor(DefaultBackgroundColor);
    }
}
