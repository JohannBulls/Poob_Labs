import lang.stride.*;
import java.awt.*;
import java.awt.geom.*;

/**
 * A circle that can be manipulated and that draws itself on a canvas.
 * @author  Michael Kolling and David J. Barnes @version 1.0.  (15 July 2000)
 */
public class Circle
{
    private static final double PI = 3.14159265359;
    private static int diameter;
    private int xPosition;
    private int yPosition;
    private String color;
    private boolean isVisible;
    private double perimtre;

    /**
     * 
     */
    public Circle()
    {
        diameter = 30;
        xPosition = 70;
        yPosition = 15;
        color = "blue";
        isVisible = false;
        perimtre = perimeter();
    }

    /**
     * 
     */
    public void makeVisible()
    {
        isVisible = true;
        draw();
    }

    /**
     * 
     */
    public void makeInvisible()
    {
        erase();
        isVisible = false;
    }

    /**
     * 
     */
    private void draw()
    {
        if (isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color,  new  Ellipse2D.Double(xPosition, yPosition, diameter, diameter));
            canvas.wait(10);
        }
    }

    /**
     * 
     */
    private void erase()
    {
        if (isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }

    /**
     * Move the circle a few pixels to the right.
     */
    public void moveRight()
    {
        moveHorizontal(20);
    }

    /**
     * Move the circle a few pixels to the left.
     */
    public void moveLeft()
    {
        moveHorizontal(-20);
    }

    /**
     * Move the circle a few pixels up.
     */
    public void moveUp()
    {
        moveVertical(-20);
    }

    /**
     * Move the circle a few pixels down.
     */
    public void moveDown()
    {
        moveVertical(20);
    }

    /**
     * Move the circle horizontally. @param distance the desired distance in pixels
     */
    public void moveHorizontal(int distance)
    {
        erase();
        xPosition = xPosition + distance;
        draw();
    }

    /**
     * Move the circle vertically. @param distance the desired distance in pixels
     */
    public void moveVertical(int distance)
    {
        erase();
        yPosition = yPosition + distance;
        draw();
    }

    /**
     * Slowly move the circle horizontally. @param distance the desired distance in pixels
     */
    public void slowMoveHorizontal(int distance)
    {
        int delta;
        if (distance < 0) {
            delta = -1;
            distance =  - distance;
        }
        else {
            delta = 1;
        }
        int i = 0;
        while (i < distance) {
            xPosition = xPosition + delta;
            draw();
            i = i + 1;
        }
    }

    /**
     * Slowly move the circle vertically @param distance the desired distance in pixels
     */
    public void slowMoveVertical(int distance)
    {
        int delta;
        if (distance < 0) {
            delta = -1;
            distance =  - distance;
        }
        else {
            delta = 1;
        }
        int i = 0;
        while (i < distance) {
            yPosition = yPosition + delta;
            draw();
            i = i + 1;
        }
    }

    /**
     * Change the size. @param newDiameter the new size (in pixels). Size must be >=0.
     */
    public void changeSize(int newDiameter)
    {
        erase();
        if (newDiameter > 0) {
            diameter = newDiameter;
            draw();
        }
        else {
            System.out.println("El numero del diametro es menor a cero, No se puede realizar dicha funcion");
        }
    }

    /**
     * Change the color. @param color the new color. Valid colors are "red", "yellow", "blue", "green", "magenta" and "black".
     */
    public void changeColor(String newColor)
    {
        color = newColor;
        draw();
    }
    
    public double perimeter(){
        perimtre = PI*diameter;
        return (perimtre);
    }
    
    public void zoom(String c){
        double valor = perimtre/2;
        if (c.equals("+")){
            diameter=(int)((valor+perimtre)/PI);
        } else if (c.equals("-")){
            diameter=(int)((perimtre-valor)/PI);
        }
        changeSize(diameter);
    }
    
    public void jump(int times){
        if(times > 0){
            for(int i= 0;i<times;i++){
                makeInvisible();
                moveVertical(20);
                makeVisible();
                makeInvisible();
                moveVertical(-20);
                makeVisible();
            }
        }
    }
    
    public void moveSlowlydiagolal(){
        for(int i=0;i<10;i++){
            makeInvisible();
            moveHorizontal(10);
            moveVertical(10);
            makeVisible();
            }
    }
}
