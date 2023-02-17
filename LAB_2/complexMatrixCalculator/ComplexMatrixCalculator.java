import java.util.TreeMap;
import java.util.ArrayList;

/** ComplexMatrixCalculator.java
 * 
 * @author CIS 2023-01
 */
    
public class ComplexMatrixCalculator{
    
    private TreeMap<String, Matrix> variables;
    private int[][][] inicial = {{{0,0}}};
    public ComplexMatrixCalculator(){
    }

    //Create a new variable
    public void create(String name){
        variables.put(name,new Matrix(inicial));
    }
     
    //Assign a matrix to an existing variable
    //matrix[i][j] := complexNumbers[i][j][0] + complexNumbers[i][j][1] i 
    public void assign(String name, int complexNumbers[][][] ){
        Matrix x = variables.get(name);
        x.assign();
    }    
    
    //Assigns the value of an operation to a variable (matrix operations)
    // a := b op c
    //The operator characters are:  +  * t
    public void assign(String a, String b, char op, String c){
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
}
    



