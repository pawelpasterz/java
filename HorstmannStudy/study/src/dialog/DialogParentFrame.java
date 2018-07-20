package dialog;

import oracle.jrockit.jfr.JFR;

import javax.swing.*;
import java.awt.*;

public class DialogParentFrame extends JFrame {
    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 200;
    private AboutDialog dialog;

    public DialogParentFrame() {
        setSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));

        //Tworze menu 'Plik'
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu fileMenu = new JMenu("Plik");
        menuBar.add(fileMenu);

        //Tworzenie elementow o programie i zamknij
        //Element o programie wyswietli to zajebiste okno dialogowe
        JMenuItem aboutItem = new JMenuItem("O programie");
        aboutItem.addActionListener(event -> {
            if (dialog == null) //tylko gdy pierwszy raz
                dialog = new AboutDialog(DialogParentFrame.this);
            dialog.setVisible(true);
        });
        fileMenu.add(aboutItem);

        //Element zamknij
        JMenuItem exitItem = new JMenuItem("Zamknij");
        exitItem.addActionListener(event -> System.exit(0));
        fileMenu.add(exitItem);
    }

}
