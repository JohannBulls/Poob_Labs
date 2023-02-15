import java.util.HashMap;

/**
 * Let me create a galery
 *
 * @author Sebastian Zamora
 * @author Johann Amaya
 * @version 1.0
 */
public class Gallery
{
    private HashMap<String,Room> rooms = new HashMap();
    private int length;
    private String exepcion;
    private boolean confirm;
    private Sculpture sculpture;
    
    /**
     * Constructor for objects of class Galery.
     * @author length The length of the galery.
     * @author width The width of the galery.
     */
    public Gallery(int length,int width)
    {
        Canvas galeria = Canvas.getCanvas("Galeria",length,width);
        this.length = length;
        galeria.redraw1();
    }
    
    /**
     * Let me create a room.
     * @param color the color of the room's wall.
     * @param polygon the position of the vertices of the polygon 
     */
    public void buildRoom(String color, int[][] polygon){
        Room room = new Room(color,polygon,length);
        rooms.put(color,room);
    } 
    
    /**
     * Let me put a sculpture in a room.
     * @param room the color of the room.
     * @param x the x's position of the sculpture.
     * @param y the y's position of the sculpture.
     */
    public void displaySculpture(String room,int x,int y){
        sculpture = new Sculpture(room,x,y,length);
        sculpture.makeVisible();
    }
    
    public void arriveGuard(String room){
    
    }
    
    public void moveGuard(String room, int x, int y){
    
    }
    
    public void alarm(String room, boolean on){
    
    }
    
    /*public String[] rooms(){
    
    }
    
    public String[] roomsOnAlert(){
    
    }
    
    public int[] guardLocation(String room){
    
    }  
    
    public int[] sculptureLocation(String room){
    
    }*/
    
    /**
     * Let me make visible the rooms on the gallery
     */
    public void makeVisible(){
        for(Room i: R){    
            i.makeVisible();
        }
    }
    
    /**
     * Let me make visible the rooms on the gallery
     */
    public void makeInvisible(){
        room.makeInvisible();
    }
    
    public boolean ok(){
        if (exepcion != "ok"){
            System.out.println(exepcion);
            exepcion = "ok";
        }
        return confirm;
    }

    /**
     * Finish the simulator
     */
    public void finish(){
        System.exit(0);
    }
}

