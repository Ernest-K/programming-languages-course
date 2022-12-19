package sprites;

import java.awt.*;

public class Square extends Sprite{

    private final int width = 50;

    public Square(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.fillRect(x - Math.round(width/2), y - Math.round(width/2), width, width);
    }

    @Override
    public String toString() {
        return "Square";
    }
}
