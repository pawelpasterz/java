package dataExchange;

import javax.swing.*;
import java.awt.*;

public class PasswordChooser extends JPanel {
    private JTextField username;
    private JPasswordField password;
    private JButton okButton;
    private boolean ok;
    private JDialog dialog;

    /**
     * Elementy sluzace do podania hasla i nazwy zytkownika ktore widac w oknie dialogowym
     */
    public PasswordChooser() {
        setLayout(new BorderLayout());

        //Utworzenie panelu z polami nazwa uzytkownia i haslo
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));
        panel.add(new JLabel("Nazwa uzytkownia:"));
        panel.add(username = new JTextField(""));
        panel.add(new JLabel("Haslo:"));
        panel.add(password = new JPasswordField(""));
        add(panel, BorderLayout.CENTER);

        //Utworzenie przyciskow OK i Anuluj, ktore zamykaja okno
        okButton = new JButton("OK");
        okButton.addActionListener(event -> {
            ok = true;
            dialog.setVisible(false);
        });
        JButton cancel = new JButton("Anuluj");
        cancel.addActionListener(event -> {
            dialog.setVisible(false);
        });

        //Dodawanie przyciskow w poblizu poludniowej krawedzi
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(okButton);
        buttonPanel.add(cancel);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    /**
     * Ustawia wartosci domyslne okna dialogowego
     *
     * @param u domyslne informacje uzytkownika
     */
    public void setUser(User u) {
        username.setText(u.getName());
    }

    /**
     * Pobiera dane podane w oknie dialogowym
     *
     * @return obiekt typu User, ktorego stan reprezentuje dane wprowadzane w oknie dialogowym
     */
    public User getUser() {
        return new User(username.getText(), password.getPassword());
    }

    /**
     * WYswietla panel z elementami przyjmujacymi dane od uzytkownika w oknie dialogowym
     *
     * @param parent komponent w ramce nadrzednej lub wartosc null
     * @param title  tytul okna dialogowego
     * @return
     */
    public boolean showDialog(Component parent, String title) {
        ok = false;

        //Lokalizacja ramki nadrzenej
        Frame owner = null;
        if (parent instanceof Frame)
            owner = (Frame) parent;
        else
            owner = (Frame) SwingUtilities.getAncestorOfClass(Frame.class, parent);

        //Jesli to pierwszy raz lub zmienil sie uzytkownik, utworzenie nowego okna dialogowego
        if (dialog == null || dialog.getOwner() != owner) {
            dialog = new JDialog(owner, true);
            dialog.add(this);
            dialog.getRootPane().setDefaultButton(okButton);
            dialog.pack();
        }

        //Ustawienie tytulu i wyswietlenie okna dialogowego
        dialog.setTitle(title);
        dialog.setVisible(true);
        return ok;
    }
}
