package button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by Pawel on 2017-07-19.
 */
public class ActionFrame extends JFrame {
    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public ActionFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        buttonPanel = new JPanel();

        //Definicje akcji
        Action yellowAction = new ColorAction("Zolty", new ImageIcon("yellow-ball.gif"), Color.YELLOW);
        Action blueAction =  new ColorAction("Niebieski", new ImageIcon("blue-ball.gif"), Color.BLUE);
        Action redAction = new ColorAction("Czerwony", new ImageIcon("red-ball.gif"), Color.RED);

        //Dodanie przyciskow dla akcji
        buttonPanel.add(new JButton(yellowAction));
        buttonPanel.add(new JButton(blueAction));
        buttonPanel.add(new JButton(redAction));

        //DOdanie panelu do ramki
        add(buttonPanel);

        //Powiazanie klawiszy z,n i c z nazwami
        InputMap imap = buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        imap.put(KeyStroke.getKeyStroke("ctrl Z"), "panel.yellow");
        imap.put(KeyStroke.getKeyStroke("ctrl N"), "panel.blue");
        imap.put(KeyStroke.getKeyStroke("ctrl C"), "panel.red");

        //Powiazanie nazw z akcjami
        ActionMap amap = buttonPanel.getActionMap();
        amap.put("panel.yellow", yellowAction);
        amap.put("panel.blue", blueAction);
        amap.put("panel.red", redAction);
    }
    public class ColorAction extends AbstractAction {
        /**
         * Tworzy akcje zmiany koloru
         * @param name nazwa, ktora pojawi sie na prycisku
         * @param icon ikona, ktora pojawi sie na przycisku
         * @param c kolor tla
         */
        public ColorAction(String name, Icon icon, Color c) {
           putValue(Action.NAME, name);
           putValue(Action.SMALL_ICON, icon);
           putValue(Action.SHORT_DESCRIPTION, "Ustaw kolor tla na " + name.toLowerCase());
           putValue("color", c);
        }

        public void actionPerformed(ActionEvent event) {
            Color c = (Color) getValue("color");
            buttonPanel.setBackground(c);
        }
    }
}
