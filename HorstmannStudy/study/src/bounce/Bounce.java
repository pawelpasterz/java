package bounce;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Wyswietla animowana pilke
 */
public class Bounce {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new BounceFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

/**
 * Ramka zwierajaca komponent pilki i przyciski
 */
class BounceFrame extends JFrame {
    private BallComponent comp;
    public static final int STEPS = 1000;
    public static final int DELAY = 3;

    /**
     * Tworzy ramke z komponentem zawierajacym odijajaca sie pilke orz przyciski
     */
    public BounceFrame() {
        setTitle("Pilka");
        comp = new BallComponent();
        add(comp, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        addButton(buttonPanel, "Start", e -> addBall());
        addButton(buttonPanel, "Zamknij", e -> System.exit(0));
        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }

    /**
     * Dodaje przyciski do kontenera
     *
     * @param c        kontener
     * @param title    tytul przycisku
     * @param listener nasluchiwacz akcji
     */
    public void addButton(Container c, String title, ActionListener listener) {
        JButton button = new JButton(title);
        c.add(button);
        button.addActionListener(listener);
    }

    /**
     * Dodaje odbijajaca sie pilke do panelu i odija ja  1000 razy
     */
    public void addBall() {
        try {
            Ball ball = new Ball();
            comp.add(ball);

            for (int i = 1; i <= STEPS; i++) {
                ball.move(comp.getBounds());
                comp.paintComponent(comp.getGraphics());
                Thread.sleep(DELAY);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
