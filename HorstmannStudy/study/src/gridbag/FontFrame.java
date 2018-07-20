package gridbag;

import com.sun.xml.internal.bind.v2.TODO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Ramka zawiera komponenty ustawiajace wlasnosci czcionki w rozkladzie GridBagLayout
 */
public class FontFrame extends JFrame {
    public static final int TEXT_ROWS = 10;
    public static final int TEXT_COLUMNS = 20;

    private JComboBox<String> face;
    private JComboBox<Integer> size;
    private JCheckBox bold;
    private JCheckBox italic;
    private JTextArea sample;

    public FontFrame() {
        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);
        setAlwaysOnTop(true);

        ActionListener listener = event -> updateSample();

        //Tworzenie komponentow
        JLabel faceLabel = new JLabel("Kroj: ");
        face = new JComboBox<>(new String[]{"Serif", "SansSerif", "Monospaced", "Dialog", "DialogInput"});
        face.addActionListener(listener);

        JLabel sizeLabel = new JLabel("Rozmiar: ");
        size = new JComboBox<>(new Integer[]{8, 10, 12, 15, 18, 24, 36, 48});
        size.addActionListener(listener);

        bold = new JCheckBox("Bold");
        bold.addActionListener(listener);

        italic = new JCheckBox("Italic");
        italic.addActionListener(listener);

        sample = new JTextArea(TEXT_ROWS, TEXT_COLUMNS);
        sample.setText("Arek nakurwial kilometry biegajac a Tomek jezdzac rowerem, Lukasz cisnal na silce!");
        sample.setEditable(false);
        sample.setLineWrap(true);
        sample.setBorder(BorderFactory.createEtchedBorder());

        //Dodawanie komponentow do siatki przy uzyciu klasy pomocniczej GBC
        add(faceLabel, new GBC(0, 0).setAnchor(GBC.EAST));
        add(face, new GBC(1, 0).setFill(GBC.HORIZONTAL).setWeight(100, 0).setInsets(1));
        add(sizeLabel, new GBC(0, 1).setAnchor(GBC.EAST));
        add(size, new GBC(1, 1).setFill(GBC.HORIZONTAL).setWeight(100, 100).setInsets(1));
        add(bold, new GBC(0, 2, 2, 1).setAnchor(GBC.CENTER).setWeight(100, 100));
        add(italic, new GBC(0, 3, 2, 1).setAnchor(GBC.CENTER).setWeight(100, 100));
        add(sample, new GBC(2, 0, 1, 4).setFill(GBC.BOTH).setWeight(100, 100));
        pack();
        updateSample();
    }

    private void updateSample() {
        String fontFace = (String) face.getSelectedItem();
        int fontStyle = (bold.isSelected() ? Font.BOLD : 0) + (italic.isSelected() ? Font.ITALIC : 0);
        int fontSize = size.getItemAt(size.getSelectedIndex());
        Font font = new Font(fontFace, fontStyle, fontSize);
        sample.setFont(font);
        sample.repaint();
    }
}
