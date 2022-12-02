package pl.edu.pwr;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    Window mainWindow = new Window("Log In");
                    mainWindow.setVisible(true);
                }catch (Exception e){
                    e.printStackTrace(System.err);
                }
            }
        });
    }
}
