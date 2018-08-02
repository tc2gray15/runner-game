package runner;

import java.awt.Color;
import javax.swing.*;

public class Runner {

    private static GameLoop component;
    
    public static void main(String[] args) 
    {
        addFrame();
    }
    
    private static void addFrame()
    {
        component = new GameLoop();
        component.setBackground(Color.PINK);
        JFrame f = new JFrame();
        f.setTitle("Runner");
        f.add(component);
        f.setSize(500, 300);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
