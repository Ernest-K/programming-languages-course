package pl.edu.pwr;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        Database database = Database.getInstance();
        database.add("abc", "abc".toCharArray());
        database.add("cba", "cba".toCharArray());

        SwingUtilities.invokeLater(() -> {
            try{
                Window mainWindow = new Window("Log In");
                mainWindow.setVisible(true);
            }catch (Exception e) {
                e.printStackTrace(System.err);
            }
        });
    }
}
