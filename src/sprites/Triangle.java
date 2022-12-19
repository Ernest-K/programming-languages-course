package sprites;

import java.awt.*;

public class Triangle extends Sprite{

    int[] xPoints;
    int[] yPoints;

    public Triangle(int x, int y) {
        super(x, y);
        updatePoints();
    }

    @Override
    public void draw(Graphics2D g2d) {
        updatePoints();
        g2d.fillPolygon(xPoints, yPoints, 3);
    }

    @Override
    public String toString() {
        return "Triangle";
    }

    private void updatePoints(){
        xPoints = new int[]{x - 30, x, x + 30};
        yPoints = new int[]{y + 25, y - 25, y + 25};
    }
}
