package fileChooser;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Akcesorium wyswietlajace podglad obrazkow
 */
public class ImagePreview extends JLabel {
    /**
     * Tworzy obiekt ImagePreview
     *
     * @param chooser okno wybory plikow, kotrego wlasnosc zmienia sie, powoduje zmiane obrazu w tym podgladzie
     */
    public ImagePreview(JFileChooser chooser) {
        setPreferredSize(new Dimension(100, 100));
        setBorder(BorderFactory.createEtchedBorder());
        chooser.addPropertyChangeListener(event -> {
            if (event.getPropertyName() == JFileChooser.SELECTED_FILE_CHANGED_PROPERTY) {
                //Uzytkownik wybral inny plik
                File f = (File) event.getNewValue();
                if (f == null) {
                    setIcon(null);
                    return;
                }

                //Wczytanie obrazu jako ikony
                ImageIcon icon = new ImageIcon(f.getPath());

                //Skalowanie obrazu jesli jest zbyt duzy na ikone
                if (icon.getIconWidth() > getWidth())
                    icon = new ImageIcon(icon.getImage().getScaledInstance(getWidth(), -1, Image.SCALE_DEFAULT));
                setIcon(icon);
            }
        });
    }
}
