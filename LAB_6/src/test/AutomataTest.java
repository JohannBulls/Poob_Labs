import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class of Automata.
 * @author Sebastian Zamora
 * @author Johann Amaya
 * @version 1.2
 */
public class AutomataTest {
    @Test
    public void shouldKnowItsNeighbords() {
        CellularAutomata c = new CellularAutomata();
        Cell a = new Cell(c,10,10);
        Cell b = new Cell(c,11,10);
        Cell d = new Cell(c,10,11);
        Sociable e = new Sociable(c,11,11);
        c.ticTac();
        assertEquals(e.neighbors(),3);
        c.ticTac();
        assertEquals(e.neighbors(),3);
        c.ticTac();
        assertEquals(e.neighbors(),0);
    }

    @Test
    public void shouldNotExpantIfSociableIsDead(){
        CellularAutomata c = new CellularAutomata();
        Cell a = new Cell(c,10,10);
        Cell b = new Cell(c,11,10);
        Cell d = new Cell(c,10,11);
        Sociable e = new Sociable(c,11,11);
        c.ticTac();
        c.ticTac();
        c.ticTac();
        c.ticTac();
        c.ticTac();
        c.ticTac();
        c.ticTac();
        c.ticTac();
        c.ticTac();
        c.ticTac();
        assertFalse(e.isAlive());
    }
}