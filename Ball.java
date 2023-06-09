import java.awt.*;
import javax.swing.*;
public class Ball {
    private int speed;
    private int size;
    private int x;
    private int y;
    private int cx;
    private int cy;
    private Color color;
    private int screenHeight;

    public Ball(int x, int y, int cx, int cy, int speed, Color color, int size, int screenHeight) {
        this.x = x;
        this.y = y;
        this.cx = cx;
        this.cy = cy;
        this.speed = speed;
        this.color = color;
        this.size = size;
        this.screenHeight = screenHeight;
    }

    public void paint(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, size, size);
    }

    public void move() {
        x += cx * speed;
        y += cy * speed;

        // Check for collision with top and bottom walls
        if (y <= 0 || y >= screenHeight - size) {
            cy = -cy; // Reverse the vertical direction
        }
    }
}
