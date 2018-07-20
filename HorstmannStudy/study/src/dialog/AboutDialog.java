package dialog;

import javax.swing.*;
import java.awt.*;

/**
 * Moje wlasne okienko dialogowe, lol, kilknij ok a stanie sie magia
 */
public class AboutDialog extends JDialog {
    public AboutDialog(JFrame owner) {
        super(owner, "Test wlasnego okienka dialogowego", true);

        //Dodanie etykiety html
        add(new JLabel("<html><h1><i>NAJS LONE!</i></h1><hr>Ulepil: Pawel Pasterz"), BorderLayout.CENTER);
        //Przycisk ok zamyka okno (robi niewidoczne)
        JButton ok = new JButton("OK!!!");
        ok.addActionListener(event -> setVisible(false));

        //Usawienie przycisku przy krawedzi poludniowe
        JPanel panel = new JPanel();
        panel.add(ok);
        add(panel, BorderLayout.SOUTH);

        //pack() zawsze na koncu musi byc!
        pack();
    }
}
