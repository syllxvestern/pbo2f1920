/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManajemenLayout;

/**
 *
 * @author RuminazVlntine
 */
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class Grid extends JFrame{
    private static final int FRAME_WIDTH = 600;
    private static final int FRAME_HEIGHT = 200;    
private JPanel panel;

public Grid() {
    panel = new JPanel();
    panel.setLayout(new GridLayout(4, 2));
    panel.add(new JButton("1"));
    panel.add(new JButton("2"));
    panel.add(new JButton("3"));
    panel.add(new JButton("4"));
    panel.add(new JButton("5"));
    panel.add(new JButton("6"));
    panel.add(new JButton("7"));
    panel.add(new JButton("8"));
    
    add(panel);
    setSize(FRAME_WIDTH, FRAME_HEIGHT);
    setTitle("Grid Layout Demo");
}    

}
