package domain;

import java.awt.Color;
import java.io.Serializable;
import java.util.Random;

/**
 * Write a description of class Camicase here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Teleport extends Cell {
    private CellularAutomata ac;

    /**
     * Constructor for objects of class Camicase
     *
     */
    public Teleport(CellularAutomata ac, int row, int column) {
        super(ac, row, column);
        this.ac = ac;
        color = Color.cyan;
    }

    @Override
    public void decide() {
        if (getAge() % 5 == 0) {
            Random num = new Random();
            int newRow = num.nextInt(30);
            int newColumn = num.nextInt(30);
            if (ac.getItem(newRow, newColumn) == null) {
                ac.eraseItem(row, column);
                Teleport nueva = new Teleport(ac, newRow, newColumn);
                ac.setItem(newRow, newColumn, (Item) nueva);
            }
        }
    }
}
