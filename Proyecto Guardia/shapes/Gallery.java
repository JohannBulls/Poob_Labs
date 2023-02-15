 

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
    private HashMap<String,Room> rooms = new HashMap<>();
    /**
     * Constructor for objects of class Galery.
     * @author length The length of the galery.
     * @author width The width of the galery.
     */
    public Gallery(int length,int width)
    {
        Canvas galeria = Canvas.getCanvas("Galeria",length,width);
        galeria.redraw1();
    }
    
    /**
     * Let me create a room.
     * @param color the color of the room's wall.
     * @param polygon the position of the vertices of the polygon 
     */
    public void buildRoom(String color, int[][] polygon){
        Room k = new Room(color,polygon);
        rooms.put(color,k);
    }
    
    /**
     * Let me put a sculpture in a room.
     * @param room the color of the room.
     * @param x the x's position of the sculpture.
     * @param y the y's position of the sculpture.
     */
    public void displaySculpture(String room,int x,int y){
        
    }
    
    /**
     * Let me make visible the rooms on the gallery
     */
    public void makeVisible(){
        for(String i: rooms.keySet()){
            rooms.get(i).makeVisible();
        }
    }
    
    /**
     * Let me make visible the rooms on the gallery
     */
    public void makeInvisible(){
        for(String i: rooms.keySet()){
            rooms.get(i).makeInvisible();
        }
    }
}
