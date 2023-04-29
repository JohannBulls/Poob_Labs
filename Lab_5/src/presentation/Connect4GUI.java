package presentation;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowListener;
import java.io.File;
import javax.swing.*;

public class Connect4GUI extends JDialog {
    private static final Dimension dimencion = Toolkit.getDefaultToolkit().getScreenSize();
    private JMenu menu, configuracion;
    private static int sizeX = 7;
    private static int sizeY = 6;
    private Color Jugador1 = Color.YELLOW;
    private Color Jugador2 = Color.RED;
    private JMenuBar barra;
    private JMenuItem salvarPartida, cargarPartida, salir, cambiarColor, changeSize;
    private JFileChooser selecArchivo;
    private JButton iniciar;
    private int width = dimencion.width;
    private int height = dimencion.width;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_4;
    private JLabel lblNewLabel_5;
    private JLabel titulo;
    private JLabel lblNewLabel;
    private JLabel titulo_1;
    private JLabel lblNewLabel_6;
    private JLabel lblNewLabel_7;
    private JLabel lblNewLabel_8;
    private JLabel lblNewLabel_9;
    private JLabel lblNewLabel_10;
    private JLabel lblNewLabel_11;

    public Connect4GUI() {
        prepareElements();
        prepareActions();
    }

    public void prepareElements() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLUE);
        setSize(dimencion.width / 2, dimencion.height / 2);
        setLocationRelativeTo(null);
        setResizable(false);
        prepareElementsMenu();
        panel.setLayout(new GridLayout(4, 4, 0, 0));

        lblNewLabel_1 = new JLabel("");
        panel.add(lblNewLabel_1);

        lblNewLabel_11 = new JLabel("");
        panel.add(lblNewLabel_11);

        lblNewLabel_2 = new JLabel("");
        panel.add(lblNewLabel_2);

        lblNewLabel_10 = new JLabel("");
        panel.add(lblNewLabel_10);

        lblNewLabel_9 = new JLabel("");
        panel.add(lblNewLabel_9);

        titulo = new JLabel("CONENCT");
        titulo.setHorizontalAlignment(SwingConstants.RIGHT);
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Dialog", Font.BOLD, 47));
        panel.add(titulo);

        titulo_1 = new JLabel("4");
        titulo_1.setHorizontalAlignment(SwingConstants.LEFT);
        titulo_1.setForeground(Color.RED);
        titulo_1.setFont(new Font("Dialog", Font.BOLD, 47));
        panel.add(titulo_1);

        lblNewLabel_8 = new JLabel("");
        panel.add(lblNewLabel_8);

        lblNewLabel_7 = new JLabel("");
        panel.add(lblNewLabel_7);

        lblNewLabel_6 = new JLabel("");
        panel.add(lblNewLabel_6);
        iniciar = new JButton("INICIAR PARTIDA");
        iniciar.setBounds(width/2-100,height/2,200,50);
        panel.add(iniciar);
        
        lblNewLabel = new JLabel("");
        panel.add(lblNewLabel);
        
        lblNewLabel_3 = new JLabel("");
        panel.add(lblNewLabel_3);
        
        lblNewLabel_5 = new JLabel("");
        panel.add(lblNewLabel_5);
        
        lblNewLabel_4 = new JLabel("");
        panel.add(lblNewLabel_4);
        getContentPane().add(panel);
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
        cambiarColor = new JMenuItem("Cambiar Color Fichas");
        changeSize = new JMenuItem("Cambiar Tamaño");

        menu.add(salvarPartida);
        menu.add(cargarPartida);
        menu.add(salir);
        configuracion.add(cambiarColor);
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
    	prueba juego = new prueba(sizeX, sizeY, Jugador1, Jugador2);
        juego.setVisible(true);
        this.dispose();
    }

    public static void main(String[] args) {
        Connect4GUI connect4 = new Connect4GUI();
        connect4.setTitle("CONNECT4");
        connect4.setVisible(true);
    }
}