
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
    private String[] letras = {"A+","B+","C+","D+","E+","F+","G+","**","00","A-","B-","C-","D-","E-","F-","G-"};
    private Circle[] signo = new Circle[4];
    private Rectangle[] letra = new Rectangle[4];
    private Integer[][] posiciones = {{60,0},{120,60},{60,120},{0,60}};
    private Integer[][] posInicial = {{70,15}};
    /**
     * Constructor for objects of class Molecula
     */
    public Molecula()
    {
        String[] start ={"00","C+","B-","C+"}; 
        molecula = new Rectangle();
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
        molecula.changeSize(150,150);
        molecula.changeColor("black");
        organize();
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
            }else if(connectors[i].equals("G+") || connectors[i].equals("G-")){
                letra[i] = new Rectangle();
                letra[i].changeSize(30,30);
                letra[i].changeColor("gray");
                Circle g = new Circle();
                signo[i].changeSize(20);
                if(connectors[i].equals("G+")){
                    g.changeColor("yellow");
                }else{
                    g.changeColor("red");
                }
                signo[i] = g;
                signo[i].changeSize(20);
            }else if(connectors[i].equals("**")){
                letra[i] = new Rectangle();
                letra[i].changeSize(30,30);
                letra[i].changeColor("lightGray");
                Circle f = new Circle();
                f.changeColor("lightGray");
                signo[i] = f;
                signo[i].changeSize(20);
            }else if(connectors[i].equals("00")){
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
    public String getConnector(byte position) {
        String coneccion= "";
        if (position == 12){
            coneccion =connectors[0];
        }else if(position == 3){
            coneccion =connectors[1];
        }else if(position == 6){
            coneccion =connectors[2];
        }else if(position == 9){
            coneccion =connectors[3];
        }
        return coneccion;
    }
    
    /**
     * Hacer visible a la molecula
     */
    public void makeVisible(){
        molecula.makeVisible();
        for (int i=0;i<4;i++){
            letra[i].moveHorizontal(posiciones[i][0]);
            letra[i].moveVertical(posiciones[i][1]);
            signo[i].moveHorizontal(posiciones[i][0]+5);
            signo[i].moveVertical(posiciones[i][1]+5);
            letra[i].makeVisible();
            signo[i].makeVisible();
        }
    }
    
    /**
     * Hacer invisible la molecula
     */
    public void makeInvisible(){
        for (int i=0;i<4;i++){
            letra[i].makeInvisible();
            signo[i].makeInvisible();
        }
        molecula.makeInvisible();
    }
    
    /**
     * Cambio a la siguiente letra 
     */
    public void change(){
       for (int i=0;i<4;i++){
            if(connectors[i].equals("G+")){
                connectors[i] = letras[0];
            }else if(connectors[i].equals("G-")){
                connectors[i] = letras[9];
            }else if(!connectors[i].equals("**") &&  !connectors[i].equals("00")){
                for (int j=0;j<16;j++){
                    if(connectors[i].equals(letras[j])){
                        connectors[i] = letras[j+1];
                        j=16;
                    }
                }
            }
        }
        organize();
        makeVisible();
    }
    
    /**
     * Refleja la molecula en vertical 
     */
    public void reflect(){
       String k=connectors[0];
        connectors[0]=connectors[2];
       connectors[2]=k;
        organize();
       makeVisible();
    }
    
     /**
     * Rota la molecula hacia las manecillas del reloj
     */
    public void rotate(){
        String[] rotar = new String[4];
        for(int i =0;i<4;i++){
            rotar[i] = connectors[i];
        }
        for(int i =0;i<3;i++){
            connectors[i] = rotar[i+1];
        }
        connectors[0] = rotar[3];
        organize();
       makeVisible();
    }
}
