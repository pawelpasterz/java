package colorChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Panel z przyciskami uruchamiajacymi trzy tryby okien
 */
public class ColorChooserPanel extends JPanel {
    public ColorChooserPanel() {
        JButton modalButton = new JButton("Modalne");
        modalButton.addActionListener(new ModalListener());
        add(modalButton);

        JButton modelessButton = new JButton("Niemodalne");
        modelessButton.addActionListener(new ModelessListener());
        add(modelessButton);

        JButton immediateButton = new JButton("Natychmiastowe");
        immediateButton.addActionListener(new ImmediateListener());
        add(immediateButton);
    }

    /**
     * Nasluchiwacz wyswietla okno modalne
     */
    private class ModalListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Color defaultColor = getBackground();
            Color selected = JColorChooser.showDialog(ColorChooserPanel.this, "Ustaw kolor tla", defaultColor);
            if (selected != null) setBackground(selected);
        }
    }

    /**
     * Ten nasluchiwacz wyswietla okno niemodalen. Kolortla zmiani sie po kliknieciu OK
     */
    private class ModelessListener implements ActionListener {
        private JDialog dialog;
        private JColorChooser chooser;

        public ModelessListener() {
            chooser = new JColorChooser();
            dialog = JColorChooser.createDialog(ColorChooserPanel.this, "Backgroud color", false, chooser,
                    event -> setBackground(chooser.getColor()), null);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            chooser.setColor(getBackground());
            dialog.setVisible(true);
        }
    }

    /**
     * Nasluchiwacz wyswietla okno niemodalne. Kolor tla panelu zmienia sie bezposrednio po wybraniu koloru
     */
    private class ImmediateListener implements ActionListener {
        private JDialog dialog;
        private JColorChooser chooser;

        public ImmediateListener() {
            chooser =  new JColorChooser();
            chooser.getSelectionModel().addChangeListener(event -> setBackground(chooser.getColor()));

            dialog = new JDialog((Frame)null, false);
            dialog.add(chooser);
            dialog.pack();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            chooser.setColor(getBackground());
            dialog.setVisible(true);
        }
    }
}
