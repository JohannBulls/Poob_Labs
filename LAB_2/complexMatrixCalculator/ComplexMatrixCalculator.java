import java.util.TreeMap;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/** ComplexMatrixCalculator.java
 * 
 * @author CIS 2023-01
 */
    
public class ComplexMatrixCalculator{
    
    private TreeMap<String, Matrix> variables;
    private int[][][] inicial = {{{0,0}}};
    /**
     *Me permite construir un objeto de esta clase.
     */
    public ComplexMatrixCalculator(){
        variables = new TreeMap<>();
    }

    //Create a new variable
    /**
     * Me permite declarar variables de la calculadora
     * @Param name El nombre de la variable.
     */
    public void create(String name){
        variables.put(name,new Matrix(inicial));
    }
     
    //Assign a matrix to an existing variable
    //matrix[i][j] := complexNumbers[i][j][0] + complexNumbers[i][j][1] i
    // {{{1,2},{-3,4},{4,-5},{6,7}},{{8,9},{0,-1},{2,3},{-4,5}},{{6,-7},{8,9},{0,1},{2,3}}}
    /**
     *Me permite asignarle la matriz de numeros complejos a una variable.
     *@Param name El nombre de la variable.
     *@Param complexNumbers Una matriz de tres dimensiones de enteros donde estan las partes enteras y imaginarias de los numeros complejos
     */
    public void assign(String name, int complexNumbers[][][] ){
        Matrix x = new Matrix(complexNumbers);
        variables.replace(name,x);
    }    
    
    //Assigns the value of an operation to a variable (matrix operations)
    // a := b op c
    //The operator characters are:  +  * t
    /**
     * Me permite hacer operaciones con dos matrices y el resultado lo asigno en otra matriz.
     * @Param a El nombre de la variable.
     * @Param b El nombre de la variable.
     * @Param op el identificador de la operación que se va hacer.
     * @Param c El nombre de la variable.
     */
    public void assign(String a, String b, char op, String c){
        int[][][] matrizB=variables.get(b).getmatris();
        int[][][] matrizC=variables.get(c).getmatris();
        //suma,resta
        if(matrizB.length==matrizC.length && matrizB[0].length==matrizC[0].length){
            Operation Operarions = new Operation(matrizB, op,matrizC);
        }
        //Multiplicacion
        else if (matrizB.length==matrizC[0].length){
            Operation Operarions = new Operation(matrizB, op,matrizC);
        }else{
            JOptionPane.showMessageDialog(null, "No se puede Realizar la operacion");
        }
    }
  
    //Assigns the value of an operation to a variable (unary matrix aggregation operations)
    // a := op type b
    //The operator characters are:  +, * 
    //The type characters are: r (row), c(column), a (all)
    /**
     * Me permite hacer suma y multiplicacion entre una misma matriz y si hacer en columnas,filas y toda la matriz.
     * @Param a El nombre de la variable.
     * @Param op el identificador de la operación que se va hacer.
     * @Param type Nos indica en que parte de la matriz se va realizar la operación
     * @Param c El nombre de la variable.
     */
    public void assign(String a, char op, char type, String b){
        
    }    
    
    //Returns the string representtion of a matriz
    /**
     * Me permite representar la matriz en un string
     * @Param set El nombre de la variable.
     * @Return La representacion de la matriz.
     */
    public String toString(String set){
        Matrix x = variables.get(set);
        return x.toString();
    }
    
    //If the last operation was successful
    public boolean ok(){
        return false;
    }
    
    /**
     * Me permite calcular la conjugada de la matriz, que es el resiproco de la parte imaginaria.
     * @Param b El nombre de la matriz.
     */
    public void conjugada(String b){
        Matrix x = variables.get(b);
        x.conjugada();
        variables.replace(b,x);
    }
}
    



