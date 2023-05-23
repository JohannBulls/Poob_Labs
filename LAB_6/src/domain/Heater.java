package domain;

import java.awt.Color;
import java.io.Serializable;

/**
 * Write a description of class Heater here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Heater extends Cell {
    private CellularAutomata ac;

    /**
     * Constructor for objects of class Heater
     */
    public Heater(CellularAutomata ac, int row, int column) {
        super(ac, row, column);
        this.ac = ac;
        color = Color.orange;
    }

    /**
     * 
     */
    public void changeShape() {
        if (shape() == 2) {
            if (getAge() % 19 == 0) {
            }
        }
    }
}
