package pl.edu.pwr;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                try{
//                    Window mainWindow = new Window("Log In");
//                    mainWindow.setVisible(true);
//                }catch (Exception e){
//                    e.printStackTrace(System.err);
//                }
//            }
//        });
//    }

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
    }
}
