package presentation;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
    private JPanel[][] tablero = new JPanel[7][6];
    private CircularButton[][] botones = new CircularButton[7][6];
    private static final int fichas = 21;
    private JMenu menu, configuracion;
    private JMenuBar barra;
    private JMenuItem salvarPartida, cargarPartida, salir, cambiarColorJ1, cambiarColorJ2, changeSize;
    private JFileChooser selecArchivo;

    public GameGUI() {
        prepareElements();
        prepareActions();
    }

    public void prepareElements() {
        setSize(dimencion.width / 1.5, dimencion.height / 1.5);
        setLocationRelativeTo(null);
        prepareElementsMenu();
        JPanel casillas = prepareTablero();
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
        JPanel juego = new JPanel();
        juego.setBackground(Color.BLACK);
        juego.setLayout(new GridLayout(7, 6));
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                CircularButton boton = new CircularButton(null, 50, 50);
                tablero[i][j] = new JPanel();
                boton.setOpaque(false);
                boton.setContentAreaFilled(false);
                boton.setBorderPainted(true);
                tablero[i][j].add(boton);
                botones[i][j] = boton;
                juego.add(tablero[i][j]);
            }
        }
        return juego;
    }

    public void prepareActionsTablero() {
        for (CircularButton[] i : botones) {
            for (CircularButton j : i) {
                j.addActionListener(e -> click());
            }

        }
    }

}