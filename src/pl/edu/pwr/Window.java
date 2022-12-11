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
        setLayout(null);

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

        //set field positions
        usernameField.setBounds(125, 75, 275, 25);
        passwordField.setBounds(125, 100, 275, 25);

        JLabel usernameLabel = new JLabel("User name:");
        JLabel passwordLabel = new JLabel("Password:");

        //set label positions
        usernameLabel.setBounds(25, 75, 100 ,25);
        passwordLabel.setBounds(25, 100, 100, 25);

        usernameLabel.setLabelFor(usernameField);
        passwordLabel.setLabelFor(passwordField);


        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
    }

    private void createButtons(){
        JButton loginBtn = new JButton("Log in");
        JButton clearBtn = new JButton("Clear");

        //set button positions
        loginBtn.setBounds(125, 150, 75, 25);
        clearBtn.setBounds(200, 150, 75, 25);

        loginBtn.addActionListener(this::loginBtnActionPerformed);
        clearBtn.addActionListener(this::clearBtnActionPerformed);

        add(loginBtn);
        add(clearBtn);
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
