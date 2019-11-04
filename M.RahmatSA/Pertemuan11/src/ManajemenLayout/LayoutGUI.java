/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManajemenLayout;

import javax.swing.JFrame;

/**
 *
 * @author RuminazVlntine
 */
public class LayoutGUI {
    public static void main(String[] args) {
        JFrame frame = new Border();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        JFrame frame2 = new Grid();
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setVisible(true);
        
        JFrame frame3 = new Box();
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setVisible(true);
        
    }
}
