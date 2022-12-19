import sprites.Circle;
import sprites.Square;
import sprites.Triangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CanvasFrame extends JFrame {

    private CanvasPanel canvasPanel;
    private JLabel spriteLabel;

    public CanvasFrame() throws HeadlessException {
        super("Canvas");
        buildFrame();
    }

    protected void buildFrame(){
        setSize(650, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        setFocusable(true);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                switch (e.getKeyCode()){
                    case 49:
                        canvasPanel.setSprite(new Square(0, 0));
                        updateSpriteLabel(canvasPanel.getSprite().toString());
                        break;
                    case 50:
                        canvasPanel.setSprite(new Circle(0, 0));
                        updateSpriteLabel(canvasPanel.getSprite().toString());
                        break;
                    case 51:
                        canvasPanel.setSprite(new Triangle(0, 0));
                        updateSpriteLabel(canvasPanel.getSprite().toString());
                        break;
                    default:
                }
            }
        });

        createCanvasPanel();
        createDescriptionLabel();
        createSpriteLabel();
    }

    protected void createCanvasPanel() {
        canvasPanel = new CanvasPanel();
        canvasPanel.setLocation(10, 10);
        canvasPanel.setSize(610, 350);
        add(canvasPanel);
    }

    protected void createDescriptionLabel() {
        JLabel descriptionLabel = new JLabel("Wybierz sprite z klawiatury: 1, 2, 3");
        descriptionLabel.setBounds(10,  360, 200, 30);
        add(descriptionLabel);
    }

    protected void createSpriteLabel() {
        spriteLabel = new JLabel("Bieżący sprite: ");
        spriteLabel.setBounds(10,  380, 200, 30);
        add(spriteLabel);
    }

    private void updateSpriteLabel(String spriteName){
        spriteLabel.setText("Bieżący sprite: " + spriteName);
    }

}
