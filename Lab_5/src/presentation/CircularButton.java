package presentation;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class CircularButton extends JButton {
    public CircularButton(String label, int width, int height) {
        super(label);
        setPreferredSize(new Dimension(width, height));
        setContentAreaFilled(false);
    }

    protected void makeCircular(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.cyan);
        } else {
            g.setColor(getBackground());
        }
        g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);
        super.paintComponent(g);
    }

    // Dibuja el borde del botón como un círculo
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawOval(0, 0, getSize().width - 1, getSize().height - 1);
    }

    // Establece la forma del botón como un círculo
    Shape shape;

    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
        }
        return shape.contains(x, y);
    }

    @Override
    public void setBackground(Color color) {
        super.setBackground(color);
        repaint();
    }
}