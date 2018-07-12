package runner;

import java.awt.Color;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Runner {

    private static Player component;
    
    public static void main(String[] args) 
    {
        addFrame();
    }
    
    private static void addFrame()
    {
        component = new Player();
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
