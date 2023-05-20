import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
public class PongFrame extends JFrame{
   public Paddle paddle;
   public PongFrame(){
    PongPanel game = new PongPanel();
    JLabel label = new JLabel();
    Border border = BorderFactory.createLineBorder(Color.white);
    setTitle("Pong");
    setSize(1000, 650);
    setResizable(true);
    add(label, SwingConstants.CENTER);
    label.setBorder(border);
    label.setOpaque(false);
    setDefaultCloseOperation(PongFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setVisible(true);
       
   }
   public void KeyPressed(KeyEvent e){
      switch(e.getKeyCode()) {
         case 'w':paddle.setLocation(paddle.getX(), paddle.getY()-10);
            break;
         case 's':paddle.setLocation(paddle.getX(), paddle.getY()+10);
            break;
      }
   }  
}
