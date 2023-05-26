import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
public class PongFrame extends JFrame{
    public Paddle paddle;

    public PongFrame() {
        PongPanel game = new PongPanel();
        JLabel label = new JLabel();
        Border border = BorderFactory.createLineBorder(Color.white);
        ImageIcon icon = new ImageIcon("pong.png");
        setTitle("Pong");
        setIconImage(icon.getImage());
        setSize(1000, 650);
        setResizable(true);
        add(game);
        setContentPane(game);
        add(label, SwingConstants.CENTER);
        addKeyListener(game);
        label.setBorder(border);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
