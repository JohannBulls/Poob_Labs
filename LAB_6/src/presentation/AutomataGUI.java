package presentation;

import domain.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class AutomataGUI extends JFrame {
    public static final int SIDE = 21;
    public static final int SIZE = 31;

    private JButton buttonTicTac;
    private JPanel panelControl;
    private PhotoAutomata photo;
    private JMenu menu;
    private JMenuItem open, save, inport, export, iniciar, exit;
    private JMenuBar barra;
    private JFileChooser selecArchivo;
    private CellularAutomata automata;

    private AutomataGUI() {
        automata = new CellularAutomata();
        prepareElements();
        prepareActions();
    }

    private void prepareElements() {
        setTitle("Automata celular");
        selecArchivo = new JFileChooser();
        photo = new PhotoAutomata(this);
        buttonTicTac = new JButton("Tic-tac");
        setLayout(new BorderLayout());
        add(photo, BorderLayout.NORTH);
        add(buttonTicTac, BorderLayout.SOUTH);
        setSize(new Dimension(SIDE * SIZE, SIDE * SIZE + 50));
        setResizable(false);
        photo.repaint();
        prepareElementsMenu();
    }

    private void prepareActions() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        buttonTicTac.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        buttonTicTacAction();
                    }
                });
        prepareActionsMenu();

    }

    private void prepareElementsMenu() {
        menu = new JMenu("Menu");
        open = new JMenuItem("Open");
        save = new JMenuItem("Save");
        inport = new JMenuItem("Import");
        export = new JMenuItem("Export");
        iniciar = new JMenuItem("New");
        exit = new JMenuItem("Exit");

        menu.add(iniciar);
        menu.add(new JSeparator());
        menu.add(open);
        menu.add(save);
        menu.add(inport);
        menu.add(export);
        menu.add(new JSeparator());
        menu.add(exit);

        barra = new JMenuBar();
        barra.add(menu);
        setJMenuBar(barra);
    }

    private void buttonTicTacAction() {
        automata.ticTac();
        photo.repaint();
    }

    public CellularAutomata getAutomata() {
        return automata;
    }

    private void prepareActionsMenu() {
        iniciar.addActionListener(e -> optionNew());
        open.addActionListener(e -> optionOpen());
        save.addActionListener(e -> optionSave());
        inport.addActionListener(e -> optionImport());
        export.addActionListener(e -> optionExport());
        exit.addActionListener(e -> optionExit());
    }

    /**
     * Let me create a new Automata as Object.
     */
    private void optionNew() {
        if (JOptionPane.showConfirmDialog(rootPane, "Esta seguro que desea iniciar uno nuevo desde 0?",
                "Iniciar Nuevo Automata",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            AutomataGUI nueva = new AutomataGUI();
            nueva.setVisible(true);
            this.dispose();
        }
    }

    /**
     * Let me open an automata that it's save in the computer as an Object.
     */
    private void optionOpen() {
        int archivo = selecArchivo.showOpenDialog(open);
        if (archivo == JFileChooser.APPROVE_OPTION) {
            File doc = selecArchivo.getSelectedFile();
            try {
                automata.open(doc);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(open, e.getMessage(), "En Construccion", archivo);
            }
        }
    }

    /**
     * Let me save an Automata on the computer as an Object.
     */
    private void optionSave() {
        int archivo = selecArchivo.showOpenDialog(save);
        if (archivo == JFileChooser.APPROVE_OPTION) {
            File doc = selecArchivo.getSelectedFile();
            try {
                automata.save(doc);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(open, e.getMessage(), "En Construccion", archivo);
            }
        }
    }

    /**
     * Let me open an Automata on the computer as plain Text.
     */
    private void optionImport() {
        int archivo = selecArchivo.showOpenDialog(inport);
        if (archivo == JFileChooser.APPROVE_OPTION) {
            File doc = selecArchivo.getSelectedFile();
            try {
                automata.importar(doc);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(open, e.getMessage(), "En Construccion", archivo);
            }
        }
    }

    /**
     * Let me save an Automata on the computer as plain Text.
     */
    private void optionExport() {
        int archivo = selecArchivo.showOpenDialog(export);
        if (archivo == JFileChooser.APPROVE_OPTION) {
            File doc = selecArchivo.getSelectedFile();
            try {
                automata.export(doc);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(open, e.getMessage(), "En Construccion", archivo);
            }
        }
    }

    /**
     * Let me close the automata
     */
    private void optionExit() {
        if (JOptionPane.showConfirmDialog(rootPane, "Esta seguro que desea salir?", "Salir del sistema",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        AutomataGUI ca = new AutomataGUI();
        ca.setVisible(true);
    }
}

class PhotoAutomata extends JPanel {
    private AutomataGUI gui;

    public PhotoAutomata(AutomataGUI gui) {
        this.gui = gui;
        setBackground(Color.white);
        setPreferredSize(new Dimension(gui.SIDE * gui.SIZE, gui.SIDE * gui.SIZE));
    }

    public void paintComponent(Graphics g) {
        CellularAutomata automata = gui.getAutomata();
        super.paintComponent(g);

        for (int f = 0; f <= automata.getLength(); f++) {
            g.drawLine(f * gui.SIDE, 0, f * gui.SIDE, automata.getLength() * gui.SIDE);
        }
        for (int c = 0; c <= automata.getLength(); c++) {
            g.drawLine(0, c * gui.SIDE, automata.getLength() * gui.SIDE, c * gui.SIDE);
        }
        for (int f = 0; f < automata.getLength(); f++) {
            for (int c = 0; c < automata.getLength(); c++) {
                if (automata.getItem(f, c) != null) {
                    g.setColor(automata.getItem(f, c).getColor());
                    if (automata.getItem(f, c).shape() == Item.SQUARE) {
                        if (automata.getItem(f, c).isAlive()) {
                            g.fillRoundRect(gui.SIDE * c + 1, gui.SIDE * f + 1, gui.SIDE - 2, gui.SIDE - 2, 2, 2);
                        } else {
                            g.drawRoundRect(gui.SIDE * c + 1, gui.SIDE * f + 1, gui.SIDE - 2, gui.SIDE - 2, 2, 2);
                        }
                    } else {
                        if (automata.getItem(f, c).isAlive()) {
                            g.fillOval(gui.SIDE * c + 1, gui.SIDE * f + 1, gui.SIDE - 2, gui.SIDE - 2);
                        } else {
                            g.drawOval(gui.SIDE * c + 1, gui.SIDE * f + 1, gui.SIDE - 2, gui.SIDE - 2);
                        }
                    }
                }
            }
        }
    }
}