package slider;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.Dictionary;
import java.util.Hashtable;

/**
 * Created by Pawel on 2017-07-22.
 */
public class SliderFrame extends JFrame {
    private JPanel sliderPanel;
    private JTextField textField;
    private ChangeListener listener;

    public SliderFrame() {
        sliderPanel = new JPanel();
        sliderPanel.setLayout(new GridBagLayout());

        //Wspolny nasluchiwacz
        listener = event -> {
            //Aktualizacja pola tekstowego w odpowiedzi na zmiane pozycji suwaka
            JSlider source = (JSlider) event.getSource();
            textField.setText("" + source.getValue());
        };

        //Zwykly suwak
        JSlider slider = new JSlider();
        addSlider(slider, "Zwykly");

        //Suwak z podzialka
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        addSlider(slider, "Podzialka");

        //Suwak z dosuwaniem galki do najblizszej kreski
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setSnapToTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        addSlider(slider, "Dosuwany");

        //Suwak bez prowadnicy
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(false);
        addSlider(slider, "Bez prowadnicy");

        //Suwak o odwroconym dzialaniu
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setInverted(true);
        addSlider(slider, "Odwrocony");

        //Suwak z etykietami liczbowymi
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        addSlider(slider, "Etykiety");

        //Suwak z etykietami literowymi
        slider = new JSlider();
        slider.setSnapToTicks(true);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);

        Dictionary<Integer, Component> labelTabel = new Hashtable<>();
        labelTabel.put(0, new JLabel("A"));
        labelTabel.put(20, new JLabel("B"));
        labelTabel.put(40, new JLabel("C"));
        labelTabel.put(60, new JLabel("D"));
        labelTabel.put(80, new JLabel("E"));
        labelTabel.put(1000, new JLabel("F"));

        slider.setLabelTable(labelTabel);
        addSlider(slider, "Niesteandardowe eytkiety");

        //Suwak z etykietami ikonowymi
        slider = new JSlider();
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setSnapToTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(20);

        labelTabel = new Hashtable<>();

        //DOdawanie obrazkow do kart
        labelTabel.put(0, new JLabel(new ImageIcon("nine.gif")));
        labelTabel.put(20, new JLabel(new ImageIcon("ten.gif")));
        labelTabel.put(40, new JLabel(new ImageIcon("jack.gif")));
        labelTabel.put(60, new JLabel(new ImageIcon("queen.gif")));
        labelTabel.put(80, new JLabel(new ImageIcon("king.gif")));
        labelTabel.put(100, new JLabel(new ImageIcon("ace.gif")));

        slider.setLabelTable(labelTabel);
        addSlider(slider, "Ikony");

        //Dodawanie pola tekstowego,ktore wyswietla zawartosc ustawiona na suwaku

        textField = new JTextField();
        add(sliderPanel, BorderLayout.CENTER);
        add(textField, BorderLayout.SOUTH);
        pack();
    }

    private void addSlider(JSlider s, String description) {
        s.addChangeListener(listener);
        JPanel panel = new JPanel();
        panel.add(s);
        panel.add(new JLabel(description));
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = sliderPanel.getComponentCount();
        gbc.anchor = GridBagConstraints.WEST;
        sliderPanel.add(panel, gbc);
    }
}
