
/**
 * Write a description of class Molecula here.
 * 
 * @author Johann Amaya
 * @author Sebastian Zamora
 * @version 1.0
 */
public class Molecula
{
    private String[] connectors;
    private Rectangle molecula;
    private String[] letras = {"A+","A-","B+","B-","C+","D+","D-","E+","E-","F+","F-","G+","G-","**"};
    private Circle[] signo = new Circle[4];
    private Rectangle[] letra = new Rectangle[4];
    private Integer[][] posiciones = {{125,20},};
    /**
     * Constructor for objects of class Molecula
     */
    public Molecula()
    {
        String[] start ={"00","C+","B-","C+"}; 
        molecula = new Rectangle();
        molecula.moveLeft();
        molecula.changeSize(150,150);
        molecula.changeColor("black");
        connectors = start;
        organize();
        
    }
    
    /**
     * Constructor de la clase Molecula indicando las conecciones
     * @Pagram connectors las conecciones de la moleculas en orden horario
     */
    public Molecula(String []connectors){
        this.connectors = connectors;
        molecula = new Rectangle();
        molecula.moveLeft();
        molecula.changeSize(150,150);
        organize();
        molecula.changeColor("black");
    }

    /**
     * Me permite organizar las connecciones de la molecula.
     */
    private void organize(){
        for(int i =0;i<4;i++){
            if(connectors[i].equals("A+") || connectors[i].equals("A-")){
                letra[i] = new Rectangle();
                letra[i].changeSize(30,30);
                letra[i].changeColor("blue");
                Circle a = new Circle();
                if(connectors[i].equals("A+")){
                    a.changeColor("yellow");
                }else{
                    a.changeColor("red");
                }
                signo[i] = a;
                signo[i].changeSize(20);
            }else if(connectors[i].equals("B+") || connectors[i].equals("B-")){
                letra[i] = new Rectangle();
                letra[i].changeSize(30,30);
                letra[i].changeColor("orange");
                Circle b = new Circle();
                if(connectors[i].equals("B+")){
                    b.changeColor("yellow");
                }else{
                    b.changeColor("red");
                }
                signo[i] = b;
                signo[i].changeSize(20);
            }else if(connectors[i].equals("C+") || connectors[i].equals("C-")){
                letra[i] = new Rectangle();
                letra[i].changeSize(30,30);
                letra[i].changeColor("green");
                Circle c = new Circle();
                if(connectors[i].equals("C+")){
                    c.changeColor("yellow");
                }else{
                    c.changeColor("red");
                }
                signo[i] = c;
                signo[i].changeSize(20);
            }else if(connectors[i].equals("D+") || connectors[i].equals("D-")){
                letra[i] = new Rectangle();
                letra[i].changeSize(30,30);
                letra[i].changeColor("magenta");
                Circle d = new Circle();
                if(connectors[i].equals("D+")){
                    d.changeColor("yellow");
                }else{
                    d.changeColor("red");
                }
                signo[i] = d;
                signo[i].changeSize(20);
            }else if(connectors[i].equals("E+") || connectors[i].equals("E-")){
                letra[i] = new Rectangle();
                letra[i].changeSize(30,30);
                letra[i].changeColor("cyan");
                Circle e = new Circle();
                if(connectors[i].equals("E+")){
                    e.changeColor("yellow");
                }else{
                    e.changeColor("red");
                }
                signo[i] = e;
                signo[i].changeSize(20);
            }else if(connectors[i].equals("F+") || connectors[i].equals("F-")){
                letra[i] = new Rectangle();
                letra[i].changeSize(30,30);
                letra[i].changeColor("pink");
                Circle f = new Circle();
                if(connectors[i].equals("F+")){
                    f.changeColor("yellow");
                }else{
                    f.changeColor("red");
                }
                signo[i] = f;
                signo[i].changeSize(20);
            }else if(connectors[i].equals("G+") || connectors[i].equals("G-")){
                letra[i] = new Rectangle();
                letra[i].changeSize(30,30);
                letra[i].changeColor("gray");
                Circle g = new Circle();
                if(connectors[i].equals("G+")){
                    g.changeColor("yellow");
                }else{
                    g.changeColor("red");
                }
                signo[i] = g;
                signo[i].changeSize(20);
            }else if(connectors[i].equals("**") || connectors[i].equals("**")){
                letra[i] = new Rectangle();
                letra[i].changeSize(30,30);
                letra[i].changeColor("lightGray");
                Circle f = new Circle();
                f.changeColor("lightGray");
                signo[i] = f;
                signo[i].changeSize(20);
            }else if(connectors[i].equals("00") || connectors[i].equals("00")){
                letra[i] = new Rectangle();
                letra[i].changeSize(30,30);
                letra[i].changeColor("white");
                Circle f = new Circle();
                f.changeColor("white");
                signo[i] = f;
                signo[i].changeSize(20);
            }
        }
    }

    /**
     * Me permite obtener las conecciones de la molecula
     */
    public String getConnector(char position) {
        return connectors[Integer.parseInt(String.valueOf(position))];
    }
    
    /**
     * Hacer visible a la molecula
     */
    public void makeVisible(){
        int x = 10;
        molecula.makeVisible();
        for (int i=0;i<4;i++){
            letra[i].moveHorizontal(x);
            letra[i].makeVisible();
            signo[i].moveUp();
            signo[i].moveHorizontal(x);
            signo[i].makeVisible();
            x += 50;
        }
    }
}
