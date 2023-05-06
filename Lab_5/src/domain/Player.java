package domain;

import java.awt.Color;

import javax.swing.JButton;

public class Player {

    private Color color;

    /**
     * Let me create a player
     * 
     * @param color the color with it play
     */
    public Player(Color color) {
        this.color = color;
    }

    /**
     * Give me the color of the player
     * 
     * @return the color.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Let me verify if I win.
     * @param botones the JButton's matrix
     * @throws Connect4Exception if the player win
     */
    public void win(JButton[][] botones)throws Connect4Exception {
    	for(int i = 0; i< botones.length;i++) {
    		for(int j=0; j< botones[0].length;j++) {
    			if(botones[i][j].getBackground() == color) {
    				closeSearch(botones,i,j);
    			}
    		}
    	}
    }
    
    /**
     * verify if a piece has other pieces nearest
     * @param matriz	A JButton matrix
     * @param row		 the x-coordinate 
     * @param column	 the y-coordinate
     * @throws Connect4Exception	If the player win
     */
    public void closeSearch(JButton[][] matriz,int row,int column)throws Connect4Exception{
    	boolean win = false;
    	for(int i = row-1;i <= row+1;i++){
            for(int j = column-1;j<column+1;j++){
                if(i!=row || j!=column){
                    if(i>=0 && i<matriz.length && j>=0 && j<matriz[0].length){
                        if(matriz[i][j].getBackground() == color){
                            win = verifyPoles(matriz,i,j);
                            win = verifyDiagonals(matriz,i,j);
                        }
                    }
                }
            }
        }
    	if(win)throw new Connect4Exception(Connect4Exception.WIN);
    }
    
    /**
     * Verify if the matrix in that position to the north, south, east, or west has 3 pieces of the same color.
     * @param matriz A JButton matrix.
     * @param i	the x-coordinate.
     * @param j	the y-coordinate.
     * @return	if one of these ways has 3 pieces.
     */
    private boolean verifyPoles(JButton[][] matriz,int i,int j) {
    	boolean win = false; 
    	if(i-3 > 0){
            if(matriz[i-1][j].getBackground() == color && matriz[i-2][j].getBackground() == color && matriz[i-3][j].getBackground() == color) {
            	win = true;
            }
        }
        else if(i+3 < matriz.length){
            if(matriz[i+1][j].getBackground() == color && matriz[i+2][j].getBackground() == color && matriz[i+3][j].getBackground() == color) {
            	win = true;
            }
        }
        else if(j-3 > 0){
            if(matriz[i][j-1].getBackground() == color && matriz[i][j-2].getBackground() == color && matriz[i][j-3].getBackground() == color) {
            	win = true;
            }
        }
        else if(j+3 < matriz[i].length){
            if(matriz[i][j+1].getBackground() == color && matriz[i][j+2].getBackground() == color && matriz[i][j+3].getBackground() == color) {
            	win = true;
            }
        }
    	return win;
    }
    
    /**
     * Verify if the matrix in that position to the diagonals has 3 pieces of the same color.
     * @param matriz A JButton matrix.
     * @param i	the x-coordinate.
     * @param j	the y-coordinate.
     * @return	if one of these ways has 3 pieces.
     */
    private boolean verifyDiagonals(JButton[][] matriz,int i,int j) {
    	boolean win = false;
    	if(j-3 > 0 && i+3 < matriz.length){
            if(matriz[i+1][j-1].getBackground() == color && matriz[i+2][j-2].getBackground() == color && matriz[i+3][j-3].getBackground() == color) {
            	win = true;
            }
        }
        else if(j+3 < matriz[i].length && i+3 < matriz.length){
            if(matriz[i+1][j+1].getBackground() == color && matriz[i+2][j+2].getBackground() == color && matriz[i+3][j+3].getBackground() == color) {
            	win = true;
            }
        }
    	return win;
    }

}