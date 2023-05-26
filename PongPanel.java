import java.awt.Color;
import java.awt.*;
import java.util.Random;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import java.awt.event.*;
public class PongPanel extends JPanel implements KeyListener, Runnable {
    static final int Width = 1000;
    static final int Height = 650;
    public Ball ball;
    public Paddle paddle;
    public Paddle paddle2;
    private boolean running; 
    public final static int FPS = 240;
    public final static int Delay = 1000/FPS;
    private boolean paddleMovingUp = false;
    private boolean paddleMovingDown = false;
    private boolean paddleMovingUp2 = false;
    private boolean paddleMovingDown2 = false;

    public PongPanel(){
        
        ball = new Ball(490, 320, 3, 3, 1, Color.white, 20, 10);
        paddle = new Paddle(10,100,0,300,4,Color.RED);
        paddle2 = new Paddle(10,100,970,300,4,Color.blue);
        setFocusable(true);
        addKeyListener(this);
        startGame();
    
    }
    public void startGame() {
        running = true;
        Thread gameThread = new Thread(this);
        gameThread.start();
        
    }

    public void stopGame() {
        running = false;
    }

    @Override
    public void run() {
        long desiredFrameTime = 1000 / FPS; // Desired time per frame in milliseconds
        while (running) {
            long startTime = System.currentTimeMillis();

            // Game logic update
            updateGame();

            // Render the game state
            repaint();

            long elapsedTime = System.currentTimeMillis() - startTime;

            // Delay to achieve the desired frame rate
            long sleepTime = desiredFrameTime - elapsedTime;
            if (sleepTime > 0) {
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void paintComponent(Graphics g){
        g.setColor(Color.black);
        g.fillRect(0,0,Width, Height);
        
        ball.paint(g);
        paddle.paint(g);
        paddle2.paint(g);
    }
     public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
         if (key == KeyEvent.VK_W) {
               paddleMovingUp = true;
        } else if (key == KeyEvent.VK_S) { 
            paddleMovingDown = true;  
        }
        else if (key == KeyEvent.VK_UP) {
            paddleMovingUp2 = true;
        } else if (key == KeyEvent.VK_DOWN) {
            paddleMovingDown2 = true;
        }

         
     }
    
    
    
    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) {
             paddleMovingUp = false;
        } else if (key == KeyEvent.VK_S) {
            paddleMovingDown = false;
        }
        if (key == KeyEvent.VK_UP) {
            paddleMovingUp2 = false;

        } else if (key == KeyEvent.VK_DOWN) { 
            paddleMovingDown2 = false;
         
     }
        repaint();
    }
    private void updateGame() {
        // Update the paddles' positions
        if (paddleMovingUp) {
            paddle.moveUp();
        } else if (paddleMovingDown) {
            paddle.moveDown();
        }
        if (paddleMovingUp2) {
            paddle2.moveUp();
        } else if (paddleMovingDown2) {
            paddle2.moveDown();
        }
        ball.move();

    }
    @Override
    public void keyTyped(KeyEvent e) {
       
       
    }
   

}