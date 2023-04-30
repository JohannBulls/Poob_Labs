package domain;

import java.awt.Color;

import javax.swing.JButton;

public class Player {

    private Color color;

    /**
     * Let me create a player
     * 
     * @param color the color with it play
     */
    public Player(Color color) {
        this.color = color;
    }

    /**
     * Give me the color of the player
     * 
     * @return the color.
     */
    public Color getColor() {
        return color;
    }

    public void win(JButton[][] botones) {

    }

}