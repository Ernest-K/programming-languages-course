import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class CatchBtnFrame extends JFrame implements KeyListener {

    Random rand = new Random();
    Boolean isCtrlPressed = false;

    public CatchBtnFrame() throws HeadlessException {
        this("undefined");
    }

    public CatchBtnFrame(String title) throws HeadlessException {
        super(title);
        buildFrame();
    }

    protected void buildFrame(){
        setSize(650, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        addKeyListener(this);
        setVisible(true);

        createButton();
    }

    protected void createButton(){
        JButton btn = new JButton("OK");
        btn.setBounds(275, 150, 60, 25);
        btn.setFocusable(false);

        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new CanvasFrame();
                dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);

                int x = rand.nextInt(getWidth() - btn.getWidth());
                int y = rand.nextInt(getHeight() - 3 * btn.getHeight());

//                If left-ctrl pressed do not change location of button
                if(!isCtrlPressed){
                    btn.setLocation(x, y);
                }
            }
        });

        add(btn);
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        isCtrlPressed = keyEvent.getKeyCode() == 17;
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        isCtrlPressed = !(keyEvent.getKeyCode() == 17);
    }
}
