package domain;

import java.awt.Color;

public class Player {

    private static boolean turn = false;
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

    /**
     * Return if the player is in turn or not.
     * 
     * @return the player's state.
     */
    public boolean getTurn() {
        return turn;
    }

    /**
     * Change the player's state
     */
    public void changeTurn() {
        turn = !turn;
    }

}