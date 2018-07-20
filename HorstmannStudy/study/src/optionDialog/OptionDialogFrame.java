package optionDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Date;

public class OptionDialogFrame extends JFrame {
    private ButtonPanel typePanel;
    private ButtonPanel messagePanel;
    private ButtonPanel messageTypePanel;
    private ButtonPanel optionTypePanel;
    private ButtonPanel optionsPanel;
    private ButtonPanel inputPanel;
    private String messageString = "Komunikat";
    private Icon messageIcon = new ImageIcon("blue-ball.gif");
    private Object messageObject = new Date();
    private Component messageComponent = new SampleComponent();

    public OptionDialogFrame() {
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(2, 3));

        typePanel = new ButtonPanel("Typ", "Komunikat", "Potwierdzenie", "Opcja", "Dane wejsciowe");
        messageTypePanel = new ButtonPanel("Ty komuniktu", "ERROR_MESSAGE", "INFORMATION_MESSAGE", "WARNING_MESSAGE", "QUESTION_MESSAGE", "PLAIN_MESSAGE");
        messagePanel = new ButtonPanel("Komunikat", "Lancuc", "Ikona", "Komponent", "Inny", "Object[]");
        optionTypePanel = new ButtonPanel("Potwierdzenie", "DEFAULT_OPTION", "YES_NO_OPTION", "YES_NO_CANCEL_OPTION", "OK_CANCEL_OPTION");
        optionsPanel = new ButtonPanel("Opcja", "String[]", "Icon[]", "Objec[]");
        inputPanel = new ButtonPanel("Dane wejsciowe", "Pole Tekstowe", "Pole Kombi");

        gridPanel.add(typePanel);
        gridPanel.add(messageTypePanel);
        gridPanel.add(messagePanel);
        gridPanel.add(optionTypePanel);
        gridPanel.add(optionsPanel);
        gridPanel.add(inputPanel);

        //Dodanie panelu z przyciskiem 'pokaz'
        JPanel showPanel = new JPanel();
        JButton showButton = new JButton("Pokaz");
        showButton.addActionListener(new ShowAction());
        showPanel.add(showButton);

        add(gridPanel, BorderLayout.CENTER);
        add(showPanel, BorderLayout.SOUTH);
        pack();
    }

    /**
     * Pobiera wybrany komunikat lub typ opcji
     *
     * @param panel Typ komunikatu lub panel Potwierdzenie
     * @return wybrana stala xxx_MESSAGE lub xxx_Option z klasy JOptionPane
     */
    public int getType(ButtonPanel panel) {
        String s = panel.getSelection();
        try {
            return JOptionPane.class.getField(s).getInt(null);
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * Pobiera aktualnie wybrane opcje
     *
     * @return tablica lancuchow/tablica ikon/tablica obiektow w zaleznosci od wyboru w panelu Opcja
     */
    public Object[] getOptions() {
        String s = optionsPanel.getSelection();
        if (s.equals("String[]")) return new String[]{"Zolty", "Niebieski", "Czerwony"};
        else if (s.equals("Icon[]"))
            return new Icon[]{new ImageIcon("yellow-ball.gif"), new ImageIcon("blue-ball.gif"), new ImageIcon("red-ball.gif")};
        else if (s.equals("Object[]")) return new Object[]{messageString, messageIcon, messageComponent, messageObject};
        else return null;
    }

    /**
     * Pobiera aktualnie wybrany komunikat
     *
     * @return lancuch/ikona/komponent/tablica obiektow, w zaleznosci od wyboru w panelu Komponent
     */
    public Object getMessage() {
        String s = messagePanel.getSelection();
        if (s.equals("Lancuch")) return messageString;
        else if (s.equals("Ikona")) return messageIcon;
        else if (s.equals("Komponent")) return messageComponent;
        else if (s.equals("Object[]")) return new Object[]{messageString, messageIcon, messageComponent, messageObject};
        else if (s.equals("Inny")) return messageObject;
        else return null;
    }

    /**
     * Nasluchiwacz akcji przycisku 'pokaz', wyswietla okno dialogowe potwierdzenia, danych wejsciowych
     * komunikatu lub opcji w zaleznosci od wyboru typu panelu
     */
    private class ShowAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (typePanel.getSelection().equals("Potwierdzenie"))
                JOptionPane.showConfirmDialog(OptionDialogFrame.this, getMessage(), "Tytul", getType(optionTypePanel), getType(messageTypePanel));
            else if (typePanel.getSelection().equals("Dane wejsciowe")) {
                if (inputPanel.getSelection().equals("Pole tekstowe"))
                    JOptionPane.showInputDialog(OptionDialogFrame.this, getMessage(), "Tytul", getType(messageTypePanel));
                else
                    JOptionPane.showInputDialog(OptionDialogFrame.this, getMessage(), "Tytul", getType(messageTypePanel), null, new String[]{
                            "Zolty", "Niebieski", "Czerwony"
                    }, "Niebieski");
            } else if (typePanel.getSelection().equals("Komunikat"))
                JOptionPane.showMessageDialog(OptionDialogFrame.this, getMessage(), "Tytul", getType(messageTypePanel));
            else if (typePanel.getSelection().equals("Opcja"))
                JOptionPane.showOptionDialog(OptionDialogFrame.this, getMessage(), "Tytul", getType(optionTypePanel), getType(messageTypePanel), null, getOptions(), getOptions()[0]);
        }
    }

    /**
     * Komponent z pomalowana powierzchnia
     */
    class SampleComponent extends JComponent {
        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            Rectangle2D rect = new Rectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1);
            g2.setPaint(Color.YELLOW);
            g2.fill(rect);
            g2.setPaint(Color.BLUE);
            g2.draw(rect);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(10, 10);
        }
    }
}
