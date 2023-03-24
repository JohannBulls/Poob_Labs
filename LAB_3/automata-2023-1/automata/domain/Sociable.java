package domain;

import java.awt.Color;

/**
 * Information about a Sociable cell<br>
 * <b>(automata,row,column,age,state,nextState, color)</b><br>
 * <br>
 */
public class Sociable extends Cell {

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
        color = Color.red;
    }

    /**
     * Decide its next state
     */
    /*public void decide() {
        if (getAge() >= 80) {
            nextState = Agent.DEAD;
        } else if (getNeighborsAlive() < 2) {
            nextState = Agent.DEAD;
        }
    }*/

    /**
     * Change its actual state
     */
   /* public final void change() {
        turn();
        state = nextState;
        if (getAge() % 10 == 0) {
            if (getFreeNeighborEast() != null) {
                new Normal(automata, row, column + 1);
            }
            if (getFreeNeighborWest() != null) {
                new Sociable(automata, row, column - 1);
            }
        }
    }*/
}
