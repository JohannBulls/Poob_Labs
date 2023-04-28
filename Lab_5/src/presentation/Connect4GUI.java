package presentation;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowListener;
import java.io.File;
import java.awt.event.WindowEvent;

public class Connect4GUI extends JDialog {
    private static final Dimension dimencion = Toolkit.getDefaultToolkit().getScreenSize();
    private JMenu menu, configuracion;
    private static int sizeX = 7;
    private static int sizeY = 6;
    private Color Jugador1 = Color.YELLOW;
    private Color Jugador2 = Color.RED;
    private JMenuBar barra;
    private JMenuItem salvarPartida, cargarPartida, salir, cambiarColorJ1, cambiarColorJ2, changeSize;
    private JFileChooser selecArchivo;
    private JButton iniciar;
    private int width = dimencion.width;
    private int height = dimencion.width;

    public Connect4GUI() {
        prepareElements();
        prepareActions();
    }

    public void prepareElements() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        setSize(dimencion.width / 2, dimencion.height / 2);
        setLocationRelativeTo(null);
        setResizable(false);
        prepareElementsMenu();
        JLabel titulo = new JLabel("CONENCT 4");
        titulo.setFont(new Font("Madison Street", Font.BOLD, 100));
        iniciar = new JButton("INICIAR PARTIDA");
        iniciar.setBounds(width / 2 - 100, height / 2, 200, 50);
        panel.add(titulo);
        panel.add(iniciar);
        add(panel);
    }

    public void prepareActions() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        WindowListener Cerrar = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int Confirmacion = JOptionPane.showConfirmDialog(null, "¿desea cerrar el juego?");
                if (Confirmacion == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        };
        this.addWindowListener(Cerrar);
        prepareActionsMenu();
        iniciar.addActionListener(e -> iniciarPartida());

    }

    private void prepareElementsMenu() {
        barra = new JMenuBar();
        setJMenuBar(barra);
        menu = new JMenu("MENU");
        configuracion = new JMenu("CONFIGURACION");

        cargarPartida = new JMenuItem("Cargar Partida");
        salvarPartida = new JMenuItem("Salvar Partida");
        salir = new JMenuItem("Salir");
        cambiarColorJ1 = new JMenuItem("Cambiar Color Jugador 1");
        cambiarColorJ2 = new JMenuItem("Cambiar Color Jugador 2");
        changeSize = new JMenuItem("Cambiar Tamaño");

        menu.add(salvarPartida);
        menu.add(cargarPartida);
        menu.add(salir);
        configuracion.add(cambiarColorJ1);
        configuracion.add(cambiarColorJ2);
        configuracion.add(changeSize);

        barra.add(menu);
        barra.add(configuracion);

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

    private void iniciarPartida() {
        GameGUI juego = new GameGUI(sizeX, sizeY, Jugador1, Jugador2);
        juego.setVisible(true);
        this.dispose();
    }

    public static void main(String[] args) {
        Connect4GUI connect4 = new Connect4GUI();
        connect4.setTitle("CONNECT4");
        connect4.setVisible(true);
    }
}