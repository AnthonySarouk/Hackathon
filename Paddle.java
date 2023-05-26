import java.awt.*;
import javax.swing.*;
public class Paddle {
    private int width;
    private int height;
    public int x;
    public int y;
    private int speed;
    private Color color;

    public Paddle(int w, int h, int x, int y, int s, Color color){
        this.width = w;
        this.height= h;
        this.x = x;
        this.y = y;
        this.speed = s;
        this.color = color;
    }
    
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
    public void paint(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
    public int getY(){
        return y;
    }
    public void moveUp() {
        y -= speed;
        if (y < 0) {
            y = 0;
        }
    }
    
    public void moveDown() {
        y += speed;
        if (y + height > PongPanel.Height) {
            y = PongPanel.Height - height;
        }
    } 
}
