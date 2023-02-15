import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class Room here.
 *
 * @author Sebastian Zamora
 * @author Johann Amaya
 * @version 1.0
 */
public class Room
{
    private int[][] walls;
    private boolean isVisible = false;
    private List<Wall> lines = new ArrayList<>();
    private String color;
    private Guard guardia;
    private int length;
    /*private Sculpture escultura;*/
    /**
     * Constructor for objects of class Room
     */
    public Room(String color,int[][] polygon,int length)
    {
        walls = polygon;
        this.color = color;
        this.length =length;
        buildWalls(walls);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    private void buildWalls(int[][] polygon)
    {
        for(int i=1;i<polygon.length;i++){
            Wall line = new Wall(walls[i-1][0],length-walls[i-1][1],walls[i][0],length-walls[i][1]);
            lines.add(line);
        }
        Wall line = new Wall(walls[0][0],length-walls[0][1],walls[walls.length-1][0],length-walls[walls.length-1][1]);
        lines.add(line);
    }
    
    /**
     * Let me show the walls
     */
    public void makeVisible(){
        isVisible = true;
        if(isVisible){
            for(Wall i: lines){
                i.draw(color);
            }
        }
        /*escultura.makeVisible();*/
    }
    
    /**
     * Let me erase the view of the walls
     */
    public void makeInvisible(){
        isVisible = false;
        if(!isVisible){
            for(Wall i: lines){
                i.erase();
            }
        }
        /*escultura.makeInvisble();*/
    }
    
    /**
     * Let me put a sculpture in a room.
     * @param x the x's position of the sculpture.
     * @param y the y's position of the sculpture.
     */
    public void displaySculpture(int x,int y){
        /*escultura = new Sculpture(x,y);*/
    }
}
