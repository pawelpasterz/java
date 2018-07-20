package dataExchange;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DataExchangeFrame extends JFrame {
    public static final int TEXT_ROWS = 20;
    public static final int TEXT_COLUMNS = 40;
    private PasswordChooser dialog = null;
    private JTextArea textArea;

    public DataExchangeFrame() {
        //Tworzenie menu plik
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu fileMenu = new JMenu("Plik");
        menuBar.add(fileMenu);

        //Tworzenie elementow 'Polacz' i 'Zamknij'
        JMenuItem connect = new JMenuItem("Polacz");
        JMenuItem exitItem = new JMenuItem("Zamknij");
        connect.addActionListener(new ConnectAction());
        exitItem.addActionListener(event -> System.exit(0));
        fileMenu.add(connect);
        fileMenu.add(exitItem);

        textArea = new JTextArea(TEXT_ROWS, TEXT_COLUMNS);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        pack();
    }

    /**
     * Akcja Connect wyswietla okno dialogowe z polem hasla
     */
    private class ConnectAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            //Jesli to jest pierwszy raz, tworzy nowe okno dialogowe
            if (dialog == null) dialog = new PasswordChooser();

            //Ustawianie wartosci domyslnych
            dialog.setUser(new User("Twoja nazwa", (String) null));

            //WYswietlanie okna dialogowego
            if (dialog.showDialog(DataExchangeFrame.this, "Polacz")) {
                //Pobranie danych uzytkownika w przypadku zatwierdzenia
                User u = dialog.getUser();
                textArea.append("nazwa uzytkownia = " + u.getName() + "\nHaslo: " + u.getPassword() + "\n");
            }
        }
    }
}
