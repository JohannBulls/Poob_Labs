package presentation;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowListener;
import java.io.File;
import java.awt.event.WindowEvent;
import java.awt.GridLayout;

public class GameGUI extends JFrame {
    private static final Dimension dimencion = Toolkit.getDefaultToolkit().getScreenSize();
    private int sizeX;
    private int sizeY;
    private Color Jugador1, Jugador2, colorEnJuego, colorDefecto;
    private JPanel juego;
    private JButton[][] botones;
    private static final int fichas = 21;
    private JMenu menu, configuracion;
    private JMenuBar barra;
    private JMenuItem salvarPartida, cargarPartida, salir, cambiarColorJ1, cambiarColorJ2, changeSize;
    private JFileChooser selecArchivo;

    public GameGUI(int sizeX, int sizeY, Color Jugador1, Color Jugador2) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.Jugador1 = Jugador1;
        this.Jugador2 = Jugador2;
        prepareElements();
        prepareActions();
    }

    public void prepareElements() {
        setSize(dimencion.width, dimencion.height);
        setLocationRelativeTo(null);
        prepareElementsMenu();
        botones = new JButton[sizeY][sizeX];
        JPanel casillas = prepareTablero();
        colorDefecto = botones[0][0].getBackground();
        add(casillas);
    }

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

    private void prepareActionsMenu() {
        salir.addActionListener(e -> exit());
        cargarPartida.addActionListener(e -> cargarPartida());
        salvarPartida.addActionListener(e -> guardarPartida());
    }

    /**
     * Me permite cargar una partida que tenia guardadas
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
     * Me permite guardar partidas.
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

    private void exit() {
        if (JOptionPane.showConfirmDialog(rootPane, "Esta seguro que desea salir?", "Salir del sistema",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public JPanel prepareTablero() {
        juego = new JPanel();
        juego.setLayout(new GridLayout(sizeY, sizeX));
        int width = dimencion.width / sizeX - 50;
        int heigth = dimencion.height / sizeY - 50;
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                JButton boton = new JButton();
                boton.setBackground(Color.white);
                boton.setSize(width, heigth);
                botones[i][j] = boton;
                juego.add(boton);
                juego.validate();
                juego.repaint();
            }
        }
        return juego;
    }

    public void prepareActionsTablero() {
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                int x = i;
                int y = j;
                botones[i][j].addActionListener(e -> click(x, y));
            }

        }
    }

    private void click(int i, int j) {
        int posY = 0;
        boolean flag = false;
        for (int k = sizeY - 1; k >= 0; k--) {
            if (botones[k][j].getBackground() == colorDefecto && !flag) {
                posY = k;
                flag = true;
            }
        }
        for (int k = 0; k < posY; k++) {
            tick(colorEnJuego, k, j);
            tick(colorDefecto, k, j);
        }
        botones[posY][j].setBackground(colorEnJuego);
        juego.revalidate();
        juego.repaint();
    }

    public void repaint() {
        juego.removeAll();
        juego.setLayout(new GridLayout(sizeY, sizeX));
        for (JButton[] i : botones) {
            for (JButton j : i) {
                juego.add(j);
                juego.revalidate();
                juego.repaint();
            }
        }
    }

    public void tick(Color color, int i, int j) {
        botones[i][j].setBackground(color);
        juego.revalidate();
        juego.repaint();
    }

}