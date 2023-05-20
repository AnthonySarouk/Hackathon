import java.awt.Color;
import java.awt.*;
import javax.swing.JPanel;

public class PongPanel extends JPanel{
    static final int Width = 1000;
    static final int Height = 650;
    public Ball ball;
    public Paddle paddle;
    public Paddle paddle2;
    @Override
    public void setOpaque(boolean isOpaque) {
        // TODO Auto-generated method stub
        super.setOpaque(isOpaque);
    }
    public PongPanel(){
        ball = new Ball(500, 320, 3, 3, 3, Color.white, 10);
        paddle = new Paddle(15,60,0,300,4,Color.WHITE);
        paddle2 = new Paddle(15,60,970,300,4,Color.WHITE);
    }

    public void paintComponent(Graphics g){
        g.setColor(Color.black);
        g.fillRect(0,0,Width, Height);
        
        ball.paint(g);
        paddle.paint(g);
        paddle2.paint(g);
    }

}
