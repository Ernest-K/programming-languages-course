package pl.edu.pwr;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    private final Color DefaultBackgroundColor = Color.WHITE;

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
        JTextField loginField = new JTextField(25);
        JPasswordField passwordField = new JPasswordField(25);

        add(loginField);
        add(passwordField);
    }

    private void createButtons(){
        JPanel buttonsPanel = new JPanel(new FlowLayout());

        JButton loginBtn = new JButton("Log in");
        JButton clearBtn = new JButton("Clear");

        loginBtn.addActionListener(actionEvent -> changeBackgroundColor(Color.GREEN));
        clearBtn.addActionListener(actionEvent -> changeBackgroundColor(DefaultBackgroundColor));

        buttonsPanel.add(loginBtn);
        buttonsPanel.add(clearBtn);

        add(buttonsPanel);
    }
}
