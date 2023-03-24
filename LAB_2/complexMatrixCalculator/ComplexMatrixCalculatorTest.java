

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * La clase de pruebas de ComplexMatrixCalculator
 *
 * @author Sebastian Zamora.
 * @author Johann Amaya.
 * @version 1.0
 */
public class ComplexMatrixCalculatorTest
{
    private ComplexMatrixCalculator calculadora;
    /**
     * Default constructor for test class ComplexMatrixCalculatorTest
     */
    public ComplexMatrixCalculatorTest()
    {
        calculadora = new ComplexMatrixCalculator();
    }

    @Test
    public void shouldCreateVariables() {
        calculadora.create("b");
        calculadora.create("a");
        calculadora.create("c");
        assertEquals(calculadora.toString("a"),"[0]");
        assertEquals(calculadora.toString("b"),"[0]");
        assertEquals(calculadora.toString("c"),"[0]");
    }
    
    @Test
    public void shouldAssingTheComplexNumber(){
        calculadora.create("b");
        calculadora.create("a");
        calculadora.create("c");
        int[][][] x = {{{1,2},{3,4}},{{5,6},{7,8}}};
        int[][][] y = {{{11,21},{13,14}},{{15,16},{17,18}}};
        int[][][] z = {{{21,22},{23,24}},{{25,26},{27,28}}};
        calculadora.assign("b",x);
        calculadora.assign("a",y);
        calculadora.assign("c",z);
        assertEquals(calculadora.toString("a"),"[11+21i,13+14i],[15+16i,17+18i]");
        assertEquals(calculadora.toString("b"),"[1+2i,3+4i],[5+6i,7+8i]");
        assertEquals(calculadora.toString("c"),"[21+22i,23+24i],[25+26i,27+28i]");
    }
    
    @Test
    public void shouldDoTheConjudate(){
        calculadora.create("b");
        calculadora.create("a");
        calculadora.create("c");
        int[][][] x = {{{1,2},{3,4}},{{5,6},{7,8}}};
        int[][][] y = {{{11,21},{13,14}},{{15,16},{17,18}}};
        int[][][] z = {{{21,22},{23,24}},{{25,26},{27,28}}};
        calculadora.assign("b",x);
        calculadora.assign("a",y);
        calculadora.assign("c",z);
        calculadora.conjugada("a");
        calculadora.conjugada("b");
        assertEquals(calculadora.toString("a"),"[11-21i,13-14i],[15-16i,17-18i]");
        assertEquals(calculadora.toString("b"),"[1-2i,3-4i],[5-6i,7-8i]");
    }
}