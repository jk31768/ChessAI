package Game;

import Game.Board;

import javax.swing.*;
import java.awt.*;

public class Driver
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Chess Program");
        frame.setSize(1300, 1300);
        frame.setLocation(800, 300);
        frame.setContentPane(new Board());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
/*
        JMenuBar bar =new JMenuBar();
       // bar.add(Box.createRigidArea(new Dimension(150,30)));
        JMenu file = new JMenu("File");
        JMenuItem open = new JMenuItem("Open");
        file.add(open);
        frame.setJMenuBar(bar);
        bar.add(file);

        frame.setVisible(true);  */
    }
}
