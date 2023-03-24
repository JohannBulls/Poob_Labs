/**
 * @author ECI, 2023
 *
 */
public class Matrix{

    private ComplexNumber[][] valores;
    private int [][][] matris;
    /**
    * Create a new matrix. If there is an error in the data, {{{0,0}}} is assumed
    */
    public Matrix (int data[][][]) {
        valores = new ComplexNumber[data.length][data[0].length];
        for(int i = 0; i< valores.length;i++){
            for(int j = 0; j<valores[0].length;j++){
                ComplexNumber numero = new ComplexNumber(data[i][j][0],data[i][j][1]);
                valores[i][j] = numero;
            }
        }
        
        matris = data;
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
    
    public int[][][] getmatris(){
        return matris;
    }
    
    @Override
    public boolean equals(Object otra) {
        return equals((Matrix)otra);
    }
    
    @Override
    public String toString () {
        String matriz = "[";
        for(int i = 0; i< valores.length;i++){
            if(i>0){matriz += ",[";}
            for(int j = 0; j<valores[0].length-1;j++){
                matriz += valores[i][j].toString() + ","; 
            }
            matriz += valores[i][valores[0].length-1] + "]";
        }
        return matriz;
    }
    
    public void conjugada(){
        for(int i = 0; i< valores.length;i++){
            for(int j = 0; j<valores[0].length;j++){
                valores[i][j].conjugado();
            }
        }
    }
}
