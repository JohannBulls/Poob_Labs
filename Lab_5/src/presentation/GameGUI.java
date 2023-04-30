package presentation;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowListener;
import java.io.File;
import javax.swing.*;
import domain.*;

public class GameGUI extends JFrame {
    private static final Dimension dimencion = Toolkit.getDefaultToolkit().getScreenSize();
    private int sizeX;
    private int sizeY;
    private Color colorEnJuego, colorDefecto;
    private JPanel juego;
    private JButton[][] botones;
    private JMenu menu;
    private JMenuBar barra;
    private JMenuItem salvarPartida, cargarPartida, salir;
    private JFileChooser selecArchivo;
    private Player Jugador1, Jugador2;

    /**
     * Let me create the table to play.
     * 
     * @param sizeX    the rows's number.
     * @param sizeY    the columns's number.
     * @param Jugador1 the first player's color
     * @param Jugador2 the second player's color
     */
    public GameGUI(int sizeX, int sizeY, Color Jugador1, Color Jugador2) {
        setTitle("CONNECT4");
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.Jugador1 = new Player(Jugador1);
        this.Jugador2 = new Player(Jugador2);
        colorEnJuego = this.Jugador1.getColor();
        prepareElements();
        prepareActions();
    }

    /**
     * Create and configurate all visible elements.
     */
    public void prepareElements() {
        setSize(dimencion.width, dimencion.height);
        setLocationRelativeTo(null);
        prepareElementsMenu();
        botones = new JButton[sizeY][sizeX];
        JPanel casillas = prepareTablero();
        colorDefecto = botones[0][0].getBackground();
        add(casillas);
    }

    /**
     * Configurare all actions that the game would do.
     */
    public void prepareActions() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        WindowListener Cerrar = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int Confirmacion = JOptionPane.showConfirmDialog(rootPane, "Esta seguro que desea salir?",
                        "Salir del sistema",
                        JOptionPane.YES_NO_OPTION);
                if (Confirmacion == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        };
        this.addWindowListener(Cerrar);
        prepareActionsMenu();
        prepareActionsTablero();
    }

    /**
     * Create all visible items on the menu.
     */
    private void prepareElementsMenu() {
        barra = new JMenuBar();
        setJMenuBar(barra);
        menu = new JMenu("MENU");
        cargarPartida = new JMenuItem("Cargar Partida");
        salvarPartida = new JMenuItem("Salvar Partida");
        salir = new JMenuItem("Salir");

        menu.add(salvarPartida);
        menu.add(cargarPartida);
        menu.add(salir);

        barra.add(menu);

    }

    /**
     * Configure the menu's actions.
     */
    private void prepareActionsMenu() {
        salir.addActionListener(e -> exit());
        cargarPartida.addActionListener(e -> cargarPartida());
        salvarPartida.addActionListener(e -> guardarPartida());
    }

    /**
     * Let me open a game that it's save later.
     */
    public void cargarPartida() {
        selecArchivo = new JFileChooser();
        selecArchivo.setVisible(true);
        int action = selecArchivo.showOpenDialog(cargarPartida);
        if (action == JFileChooser.APPROVE_OPTION) {
            File archivo = selecArchivo.getSelectedFile();
            JOptionPane.showMessageDialog(cargarPartida,
                    "El archivo de nombre " + archivo.getName() + " que se trata de abrir en la ruta " + archivo
                            + "\n NO se pudo abrir ya que esta funcion se encuentra en construccion.");
        }
        selecArchivo.setVisible(false);
    }

    /**
     * Let me save a game.
     */
    public void guardarPartida() {
        selecArchivo = new JFileChooser();
        selecArchivo.setVisible(true);
        int action = selecArchivo.showSaveDialog(salvarPartida);
        if (action == JFileChooser.APPROVE_OPTION) {
            File archivo = selecArchivo.getSelectedFile();
            JOptionPane.showMessageDialog(salvarPartida,
                    "El archivo de nombre " + archivo.getName() + " que se trata de abrir en la ruta " + archivo
                            + "\n NO se pudo abrir ya que esta funcion se encuentra en construccion.");
        }
        selecArchivo.setVisible(false);
    }

    /**
     * Let me close the game.
     */
    private void exit() {
        if (JOptionPane.showConfirmDialog(rootPane, "Esta seguro que desea salir?", "Salir del sistema",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    /**
     * Create the button's matrix that we use like a board.
     * 
     * @return a button's matrix
     */
    public JPanel prepareTablero() {
        juego = new JPanel();
        juego.setLayout(new GridLayout(sizeY, sizeX));
        int width = dimencion.width / sizeX - 50;
        int heigth = dimencion.height / sizeY - 50;
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                JButton boton = new JButton();
                boton.setBackground(Color.white);
                boton.setToolTipText(Integer.toString(i) + "," + Integer.toString(j));
                boton.setSize(width, heigth);
                botones[i][j] = boton;
                juego.add(boton);
                juego.validate();
                juego.repaint();
            }
        }
        return juego;
    }

    /**
     * Configure the buttons actions in the board.
     */
    public void prepareActionsTablero() {
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                int x = i;
                int y = j;
                botones[i][j].addActionListener(e -> {
                    try {
                        click(x, y);
                    } catch (Connect4Exception e1) {
                        JOptionPane.showMessageDialog(rootPane, e1.getMessage());
                    }
                });
            }

        }

    }

    /**
     * Let me put the piece in a specific position on the board.
     * 
     * @param i the x-coordinate
     * @param j the y-coordinate
     * @throws Connect4Exception
     */
    private void click(int i, int j) throws Connect4Exception {
        int posY = 0;
        boolean flag = false;
        if (botones[0][j].getBackground() != colorDefecto) {
            throw new Connect4Exception(Connect4Exception.NO_SPACE);
        }
        for (int k = sizeY - 1; k >= 0; k--) {
            if (botones[k][j].getBackground() == colorDefecto && !flag) {
                posY = k;
                flag = true;
            }
        }
        botones[posY][j].setBackground(colorEnJuego);
        juego.revalidate();
        juego.repaint();
        changeTurn();
    }

    /**
     * Let me chage the turn between the two players.
     */
    private void changeTurn() {
        if (Jugador1.getColor() == colorEnJuego) {
            colorEnJuego = Jugador2.getColor();
            Jugador1.win(botones);
        } else {
            colorEnJuego = Jugador1.getColor();
            Jugador2.win(botones);
        }
    }
}