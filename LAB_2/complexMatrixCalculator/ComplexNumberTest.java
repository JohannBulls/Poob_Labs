import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class ComplexNumberTest {


    @Test
    public void shouldCreateComplexNumbers() {
        ComplexNumber cn = new ComplexNumber(1234,567);
        assertEquals(1234,cn.getReal());
        assertEquals(567,cn.getImaginary());
    }


    @Test
    public void shouldKnowWhenTwoComplexNumbersAreEquals () {
        assertTrue (new ComplexNumber(5405400,4158000).equals(new ComplexNumber(5405400,4158000)));
        assertFalse(new ComplexNumber(13,10).equals(new ComplexNumber(54054,41580)));
        assertEquals (new ComplexNumber(5405400,4158000),(new ComplexNumber(5405400,4158000)));
        assertEquals(new ComplexNumber(-3,100), new ComplexNumber(-3,100));
        assertEquals(new ComplexNumber(3,-100), new ComplexNumber(3,-100));
        assertEquals(new ComplexNumber(-3,-100), new ComplexNumber(-3,-100));
        assertEquals(new ComplexNumber(0,0), new ComplexNumber(0,0));
    }
    

    @Test
    public void shouldRepresentAComplexNumberAsAString() {
        assertEquals("1+2i", new ComplexNumber(1,2).toString());
        assertEquals("-1+2i", new ComplexNumber(-1,2).toString());
        assertEquals("-1-2i", new ComplexNumber(-1,-2).toString());
        assertEquals("1", new ComplexNumber(1,0).toString());
        assertEquals("3i", new ComplexNumber(0,3).toString());
        assertEquals("-3i", new ComplexNumber(0,-3).toString());
        assertEquals("0", new ComplexNumber(0,0).toString());
    }    
    

    @Test
    public void shouldAdd() {
        assertEquals (new ComplexNumber(110,200),new ComplexNumber(50,100).add(new ComplexNumber(60,100)));
        assertEquals (new ComplexNumber(39,42),new ComplexNumber(39,0).add(new ComplexNumber(0,42)));
        assertEquals (new ComplexNumber(0,0),new ComplexNumber(7,-13).add(new ComplexNumber(-7,13)));
    }

    @Test
    public void shouldPass(){
        ComplexNumber cn = new ComplexNumber(0,567);
        assertEquals(cn.getReal(),0);
    }
    
    @Test
    public void shouldFail(){
        assertFalse(1==2);
    }
    
    
    /**
        Se genera un error
        -Index of on the range-
    */
    @Test
    public void shouldErr(){
        int[] x = {1,2};
        assertEquals(3,x[3]);
    }
}
