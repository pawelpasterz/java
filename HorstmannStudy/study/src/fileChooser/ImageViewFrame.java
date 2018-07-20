package fileChooser;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileFilter;
import java.io.*;

/**
 * Ramka z menu zawierajacym opcje Otworzz i obszarem do prezentacji otwartych obrazow
 */
public class ImageViewFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEAFAULT_HEIGHT = 400;
    private JLabel label;
    private JFileChooser chooser;

    public ImageViewFrame() {
        setSize(DEFAULT_WIDTH, DEAFAULT_HEIGHT);

        //pasek menu
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu file = new JMenu("Plik");
        menuBar.add(file);

        JMenuItem openItem = new JMenuItem("Otworz");
        file.add(openItem);
        openItem.addActionListener(event -> {
            chooser.setCurrentDirectory(new File("."));
            //Okno wyboru plikow
            int result = chooser.showOpenDialog(ImageViewFrame.this);
            //Jesli plik zstanie zaakceptowany ustaw go jako ikone
            if (result == JFileChooser.APPROVE_OPTION) {
                String name = chooser.getSelectedFile().getPath();
                label.setIcon(new ImageIcon(name));
                pack();
            }
        });

        JMenuItem exitItem = new JMenuItem("Zamknij");
        exitItem.addActionListener(event -> System.exit(0));
        file.add(exitItem);

        //Etykieta do wsywietlania obrazow
        label = new JLabel();
        add(label);

        //Utworzenie akceorium do wyboru plikow
        chooser = new JFileChooser();

        //Akceptuje wszystkie pliki obrazow zrozszezeniem .jpg .jpeg .gif
        FileFilter filter = new FileNameExtensionFilter("Images filter", "jpg", "jpeg", "gif");
        chooser.setFileFilter(filter);
        chooser.setAccessory(new ImagePreview(chooser));
        chooser.setFileView(new FileIconView(filter, new ImageIcon("palette.gif")));
    }
}
