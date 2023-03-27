package domain;

import java.util.*;

/*No olviden adicionar la documentacion*/
public class CellularAutomata {
    static private int LENGTH = 30;
    private Item[][] automata;
    /**
     * Constructor de la clase CellularAutomata. Crea una nueva
     * instancia de la clase y establece un arreglo bidimensional
     * de objetos Item (automata) de tamaño LENGTH * LENGTH con
     * todas las posiciones establecidas como null. También llama
     * al método someItems() para agregar algunos elementos al
     * automata.
     */
    public CellularAutomata() {
        automata = new Item[LENGTH][LENGTH];
        for (int r = 0; r < LENGTH; r++) {
            for (int c = 0; c < LENGTH; c++) {
                automata[r][c] = null;
            }
        }
        someItems();
    }

    /**
     * Método público que devuelve la longitud del arreglo
     * bidimensional de objetos Item (automata).
     */
    public int getLength() {
        return LENGTH;
    }

    /**
     * Método público que devuelve el objeto Item en la posición
     * especificada (r,c) en el arreglo bidimensional de objetos
     * Item (automata).
     */
    public Item getItem(int r, int c) {
        return automata[r][c];
    }

    /**
     * Método público que establece el objeto Item en la posición
     * especificada (r,c) en el arreglo bidimensional de objetos
     * Item (automata).
     */
    public void setItem(int r, int c, Item e) {
        automata[r][c] = e;
    }

    /**
     * Método público que crea algunos objetos Cell y los agrega
     * al arreglo bidimensional de objetos Item (automata).
     */
    public void someItems() {
        Cell indiana = new Cell(this, 1, 1);
        Cell b007 = new Cell(this, 2, 2);
        Sociable agamenon = new Sociable(this, 1, 2);
        Sociable venus = new Sociable(this, 3, 2);
        Teleport johann = new Teleport(this,15,15);
        Teleport sebastian = new Teleport(this,29,29);
        Cancer nueva = new Cancer(this,20,20);
        Cancer nueva2 = new Cancer(this,0,20);
        Heater uno = new Heater(this,0,0);
        Heater dos = new Heater(this,29,29);
    }

    /**
     * Crea una matriz temporal para guardar el estado de las
     * células en el tiempo siguiente. Luego, recorre la matriz
     * actual y aplica reglas para decidir el estado de cada
     * célula en el tiempo siguiente. Finalmente, copia la matriz
     * temporal en la matriz actual para actualizar el estado
     * de las células.
     */
    public void ticTac() {
        for (int r = 0; r < LENGTH; r++) {
            for (int c = 0; c < LENGTH; c++) {
                Item currentCell = automata[r][c];
                if (currentCell != null) {
                    currentCell.decide();
                }
            }
        }
        for (int r = 0; r < LENGTH; r++) {
            for (int c = 0; c < LENGTH; c++) {
                Item currentCell = automata[r][c];
                if (currentCell != null) {
                    currentCell.change();
                }
            }
        }
    }
    
    /**
     * Let me erase a item
     */
    public void eraseItem(int row,int column){
        automata[row][column] = null;
    }
    /*
     * public void ticTac() {
     * // Creamos una matriz temporal para guardar los estados de las células en el
     * tiempo siguiente
     * Item[][] temp = new Item[LENGTH][LENGTH];
     * 
     * // Recorremos la matriz actual
     * for (int r = 0; r < LENGTH; r++) {
     * for (int c = 0; c < LENGTH; c++) {
     * Item currentCell = automata[r][c];
     * int aliveNeighbors = countAliveNeighbors(r, c);
     * 
     * // Aplicamos las reglas para decidir el estado de la célula en el tiempo
     * siguiente
     * if (currentCell == null) {
     * if (aliveNeighbors == 3) {
     * temp[r][c] = new Cell(this, r, c);
     * }
     * } else if (currentCell instanceof Cell) {
     * if (aliveNeighbors == 2 || aliveNeighbors == 3) {
     * temp[r][c] = currentCell;
     * }
     * }
     * 
     * // Si no se cumple ninguna de las reglas anteriores, la célula muere o
     * permanece muerta
     * }
     * }
     * 
     * // Copiamos la matriz temporal en la matriz actual
     * automata = temp;
     * }
     */
    /*
    /**
     * Cuenta el número de células vivas en el vecindario de una
     * célula dada. Recorre las células vecinas y aumenta un
     * contador si una célula está viva. Retorna el número total
     * de células vivas en el vecindario.
     */
    /*
     * public int countAliveNeighbors(int row, int col) {
     * int count = 0;
     * 
     * // Comprobamos las células vecinas en el vecindario de la célula actual
     * for (int r = row - 1; r <= row + 1; r++) {
     * for (int c = col - 1; c <= col + 1; c++) {
     * if (r >= 0 && r < LENGTH && c >= 0 && c < LENGTH && !(r == row && c == col))
     * {
     * Item cell = automata[r][c];
     * if (cell instanceof Cell) {
     * count++;
     * }
     * }
     * }
     * }
     * 
     * return count;
     * }
     */

    

}
