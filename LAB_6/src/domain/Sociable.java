package domain;

import java.lang.Math;
import java.awt.Color;
import java.io.Serializable;

/**
 * Let me create the Sociable cell
 * 
 * @author Johann Amaya.
 * @author Sebastian Zamora.
 * @version 1.0
 */
public class Sociable extends Cell{
    private CellularAutomata ac;

    /**
     * Create a new Sociable cell (<b>row,column</b>) in the automata <b>ac</b>.
     * Every new Sociable cell is going to be alive in the following state.
     * 
     * @param ac
     * @param row
     * @param column
     */
    public Sociable(CellularAutomata ac, int row, int column) {
        super(ac, row, column);
        this.ac = ac;
        color = Color.red;
    }

    /**
     * Let me know if the sociable has neighbors
     */
    public int neighbors() {
        int neighbors = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = column - 1; j < column + 1; j++) {
                if (i != row || j != column) {
                    if (i >= 0 && i < 30 && j >= 0 && j < 30) {
                        if (ac.getItem(i, j) != null) {
                            if (ac.getItem(i, j).isAlive()) {
                                neighbors++;
                            }
                        }
                    }
                }
            }
        }
        return neighbors;
    }

    @Override
    public void decide() {
        if (getAge() >= 80) {
            nextState = Agent.DEAD;
        } else if (neighbors() < 2) {
            nextState = Agent.DEAD;
        } else {
            nextState = Agent.ALIVE;
        }
        if (getAge() % 10 == 0 && getAge() != 0 && nextState == 'a') {
            if (column < 29 && ac.getItem(row, column + 1) == null) {
                Cell nueva = new Cell(ac, row, column + 1);
            }
            if (column > 0 && ac.getItem(row, column - 1) == null) {
                Sociable nueva = new Sociable(ac, row, column - 1);
            }
        }
    }
}
