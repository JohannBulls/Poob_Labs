package domain;

import java.awt.Color;

/**
 * The interface that let me create the figure
 * 
 * @author Sebastian Zamora
 * @author Johann Amaya
 * @version 1.0
 */
public interface Item {
    int ROUND = 1;
    int SQUARE = 2;

    /**
     * Let´s see what it does when the user click the button.
     */
    void decide();

    /**
     * Let's se if the change in the interface
     */
    default void change() {
    }

    /**
     * Let´s know what is the cell's shape;
     * 
     * @return A square
     */
    default int shape() {
        return SQUARE;
    }

    /**
     * Let´s know the cell's color.
     * 
     * @return the cell's colo
     */
    default Color getColor() {
        return Color.black;
    }

    /**
     * Return the cell's state.
     * 
     * @return if the cell is active or not.
     */
    default boolean isAlive() {
        return false;
    }

    default void changeShape() {
    }
}
