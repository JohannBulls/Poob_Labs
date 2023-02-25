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

    public ComplexMatrixCalculator(){
        variables = new TreeMap<>();
    }

    //Create a new variable
    public void create(String name){
        variables.put(name,new Matrix(inicial));
    }
     
    //Assign a matrix to an existing variable
    //matrix[i][j] := complexNumbers[i][j][0] + complexNumbers[i][j][1] i
    // {{{1,2},{-3,4},{4,-5},{6,7}},{{8,9},{0,-1},{2,3},{-4,5}},{{6,-7},{8,9},{0,1},{2,3}}}
    // {{{1,1},{-3,-4},{-7,-8},{6,7}},{{9,-2},{0,-10},{12,3},{-4,5}},{{6,-7},{18,9},{0,1},{-2,13}}}
    /**
     * 
     */
    public void assign(String name, int complexNumbers[][][] ){
        Matrix x = new Matrix(complexNumbers);
        variables.replace(name,x);
    }    
    
    //Assigns the value of an operation to a variable (matrix operations)
    // a := b op c
    //The operator characters are:  +  * t
    public void assign(String a, String b, char op, String c){
        int[][][] matrizB=consult(b);
        int[][][] matrizC=consult(c);
        //suma,resta
        if(matrizB.length==matrizC.length && matrizB[0].length==matrizC[0].length){
            Operation Operarions = new Operation(matrizB, op,matrizC);
        }
        //Multiplicacion
        else if (matrizB.length==matrizC[0].length){
            Operation Operarions = new Operation(matrizB, op,matrizC);
        }else{
            JOptionPane.showMessageDialog(null, "No se puede Realizar la operacion");
        };
        
    }
  
    //Assigns the value of an operation to a variable (unary matrix aggregation operations)
    // a := op type b
    //The operator characters are:  +, * 
    //The type characters are: r (row), c(column), a (all)
    public void assign(String a, char op, char type, String b){
    }    
    
    //Returns the string representtion of a matriz
    public String toString(String set){
        return null;
    }
    
    //If the last operation was successful
    public boolean ok(){
        return false;
    }
    
    public int[][][] consult(String name){
        Matrix consultar = variables.get(name);
        return consultar.consultar();
    }
}
    



