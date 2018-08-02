package runner;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JTextField;

public class GameLoop extends javax.swing.JPanel implements ActionListener, KeyListener {
    
    static int xPos = 10;
    static int yPos = 120;
    static int xObst = 500;
    static int yObst = 130;
    static int holdScore = 0;
    static int xObstVel = 1;
    int i = 0;
    int firstJump;
    int score;
    static int xVel, yVel;
    private boolean jumpBool = false;
    private final int GRAVITY = 1;
    private final int WIDTH = 10;
    private final int HEIGHT = 20;
    Sound sounds;
    JTextField j;
    MainChar goodGuy;
    Obstacle badGuy;

    Timer timer = new Timer(5, this);
    
    public GameLoop() {
        goodGuy = new MainChar();
        badGuy = new Obstacle();
        setFocusable(true);
        addKeyListener(this);
        sounds = new Sound();
        firstJump = 0;
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;    
        super.paintComponent(g);
        goodGuy.setLocation(10, yPos);
        badGuy.setLocation(xObst, 130);
        g2.draw(goodGuy);
        g2.draw(badGuy);
        g.drawLine(0, 140, 500, 140);
    }
    
    private void jump()
    {
        yVel = -1;
        jumpBool = true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(jumpBool == true)
        {
            if(yPos == 120 && i == 80)
            {
                jumpBool = false;
                i = 0;
            }
            else if(i == 80)
            {
                yPos -= yVel;
            }
            else if(yPos > 80)
            {
                yPos += yVel;
                i = yPos;
            }
            
        }
        
        if(xObst > 0)
        {
            xObst -= xObstVel;
        }
        
        else
        {
            xObst = 500;
        }
        
        if(score == holdScore + 20000)
        {
            xObstVel += 1;
            holdScore = score;
        }
        
        if(goodGuy.intersects(badGuy))
        {
            timer.stop();
            reset();
        }
        
        score++;
        repaint();
    }
    
    @Override
    public void keyTyped(KeyEvent e) 
    {
        return;
    }

    @Override
    public void keyPressed(KeyEvent e) 
    {
        if(e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            firstJump++;
            if(firstJump == 1)
            {
                timer.start();
                sounds.gameMusic();
                return;
            }
            sounds.hitMarker();
            jump();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) 
    {
        return;
    }
    
    private void reset()
    {
        sounds.stopMusic();
        xPos = 10;
        yPos = 120;
        xObst = 500;
        yObst = 130;
        holdScore = 0;
        xObstVel = 1;
        i = 0;
        firstJump = 0;
        score = 0;
        jumpBool = false;
    }
    
}
