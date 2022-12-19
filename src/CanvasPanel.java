import sprites.Sprite;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.MouseInputListener;
import java.awt.*;

import java.awt.event.MouseEvent;

public class CanvasPanel extends JPanel implements MouseInputListener {

    private Sprite sprite = null;

    public CanvasPanel() {
        buildPanel();
    }

    protected void buildPanel(){
        setBorder(new LineBorder(Color.GRAY, 2, true));
        setBackground(Color.WHITE);
        addMouseListener(this);
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        if (sprite == null) return;
        try {
            g2d.setColor(Color.BLUE);
            sprite.draw(g2d);
        } finally {
            g2d.dispose();
        }
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        sprite.setX(mouseEvent.getX());
        sprite.setY(mouseEvent.getY());
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }
}
