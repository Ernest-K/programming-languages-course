import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try{
                CatchBtnFrame catchBtnFrame = new CatchBtnFrame("Catch button");
            }catch (Exception e) {
                e.printStackTrace(System.err);
            }
        });
    }
}
