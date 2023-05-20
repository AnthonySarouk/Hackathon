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
    public void paint(Graphics g){
        g.setColor(color.white);
        g.fillRect(x, y, width, height);
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setLocation(int x2, int i) {
    }
        
}
