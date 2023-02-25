/**
 * @author ECI, 2023
 *
 */
public class Matrix{

    private int[][][] valores;
    /**
     * Create a new matrix. If there is an error in the data, {{{0,0}}} is assumed
     */
    public Matrix (int data[][][]) {
        valores = data;
    }
    
    public int [] dimension(){
        return null;
    }
    
    public ComplexNumber get(int f, int c){
        return null;
    }
    
    public Matrix add(Matrix m){
        return null;
    }

    /**
     * @param rca indicates the type of the operation (r:row, c:column or a:all)
     */
    public Matrix add(char rca){
        return null;
    }
    
    public boolean equals(Matrix other) {
        return false;
    }
    
    @Override
    public boolean equals(Object otra) {
        return equals((Matrix)otra);
    }
    
    @Override
    public String toString () {
        return null;
    }   
    
    public int[][][] consultar(){
        return valores;
    }
}
