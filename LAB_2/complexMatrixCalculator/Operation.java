import javax.swing.JOptionPane;
/**
 * Write a description of class Operation here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Operation
{
    private int[][][] a;
    public Operation(int[][][] b,  String op,int[][][] c) {
       String s = String.valueOf(op);
       if(s=="+"){
            a=Suma(b,c);
        }else if(s=="-"){
            a=Resta(b,c);
        }else if(s=="*"){
            a=Multiplicacion(b,c);      
        }else{
            JOptionPane.showMessageDialog(null, "Esa opereacion no se puede realizar");
        }
 
    }
    
    public int[][][] Suma(int[][][] b,int[][][] c){
        for(int i=0;i<b.length;i++){
            for(int j=0;j<b[i].length;j++){
                for(int k=0;k<b[i][j].length;k++){
                    a[i][j][k]=b[i][j][k] + c[i][j][k];
                }
            }
        }
        return a;
    }
    
    public int[][][] Resta(int[][][] b,int[][][] c){
        for(int i=0;i<b.length;i++){
            for(int j=0;j<b[i].length;j++){
                for(int k=0;k<b[i][j].length;k++){
                    a[i][j][k]=b[i][j][k] - c[i][j][k];
                }
            }
        }
        return a;
    }
    
    public int[][][] Multiplicacion(int[][][] b,int[][][] c){
        
        return a;
    }
}