
/**
 *
 */
public class ComplexNumber{
    private int real;
    private int imaginary;
    
    /**
     * Create a new fractional given the real and imaginary part
     * @param real the real part of the complex number
     * @param imginary the imaginary part of the complex number
     */
    public ComplexNumber(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }
    
    
    /**
     * Returns the real part of this complex number
     * @return
     */
    
    public int getReal(){
        return real;
    }
    
    /**
     * Returns the imaginary part of this complex number
     * @return
     */
    
    public int getImaginary(){
        return imaginary;
    }
    
    /**
     * Add this with other 
     * @param other  the complex number with which to operate
     * @return this+other
     */
    public ComplexNumber add(ComplexNumber other) {
        real += other.real;
        imaginary += other.imaginary;
        ComplexNumber numero= new ComplexNumber(real,imaginary);
        return numero;
    }
    

    /**
     * Substract other from this 
     * @param other  the complex number with which to operate
     * @return this-other
     */
    public ComplexNumber substract(ComplexNumber other) {
        return null;
    }
    
    /**
     * Multiply this by other 
     * @param other  the complex number with which to operate
     * @return this*other
     */
    public ComplexNumber multiply(ComplexNumber other) {
        return null;
    }    
    
    /**
     * Divide this by other 
     * @param other  the complex number with which to operate
     * @return this/other
     */
    public ComplexNumber divide(ComplexNumber other) {
        return null;
    }  
    
    /**Indicates whether some other complex number is "equal to" this one.
     * @param other the complex number with which to comparate
     * @return  if this complex number is the same as the other 
     */
    public boolean equals (ComplexNumber other) {
        return real == other.real && imaginary == other.imaginary;
    }


    @Override
    public boolean equals(Object obj) {
        return equals((ComplexNumber)obj);
    }  
    
    
    @Override
    public String toString() {
        String complexNumber;
        if(imaginary > 0 && real != 0){
            complexNumber =Integer.toString(real) + "+" + Integer.toString(imaginary) +"i";
        }else if (imaginary < 0 && real != 0){
            complexNumber =Integer.toString(real) + "" + Integer.toString(imaginary) +"i";
        }else if (imaginary == 0){
            complexNumber =Integer.toString(real);
        }else{
            complexNumber =""+Integer.toString(imaginary) + "i";
        }
        return complexNumber;
        }
    }