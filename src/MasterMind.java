/* 
 * IEMS5731 Software Engineering and Design (Fall 2024)
 * Course Project: Master Mind
 * 
 * By filling in your student information, it is the same as 
 * declaring your work abides by the university guideline on 
 * academic honesty.
 * Student Name:  
 * Student ID:    
 * 
 * 
 * Declaration of the use of AI tools:
 * 
 * */

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Master Mind
 * Author: Peter Mitchell (2021)
 *
 * Game class:
 * Entry point to create the frame, and pass key events.
 * 
 * Source: https://github.com/Squirrelbear/MasterMind/blob/main/MasterMind/src/Game.java
 */
public class MasterMind implements KeyListener {
    /**
     * Creates the game to start it.
     *
     * @param args Not used.
     */
    public static void main(String[] args) {
    	MasterMind game = new MasterMind();
    }

    /**
     * Reference to the game panel to pass key events to it.
     */
    private GamePanel gamePanel;

    /**
     * Creates the JFrame and sets up the GamePanel to manage all the game state.
     */
    public MasterMind() {
        JFrame frame = new JFrame("Master Mind: STUDENT_ID");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        gamePanel = new GamePanel();
        frame.getContentPane().add(gamePanel);

        frame.addKeyListener(this);

        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Handles R to restart, Escape to quit, and C to toggle the cheat mode.
     *
     * @param e Information about the key that was pressed.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_R) {
            gamePanel.restart();
            gamePanel.repaint();
        } else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        } else if(e.getKeyCode() == KeyEvent.VK_C) {
            gamePanel.toggleCheat();
            gamePanel.repaint();
        }
    }

    /**
     * Not used.
     *
     * @param e Not used.
     */
    @Override
    public void keyTyped(KeyEvent e) {}
    /**
     * Not used.
     *
     * @param e Not used.
     */
    @Override
    public void keyReleased(KeyEvent e) {}
}