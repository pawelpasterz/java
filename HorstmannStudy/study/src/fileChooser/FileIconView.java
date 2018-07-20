package fileChooser;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileView;
import java.io.File;

/**
 * Widok plikow wyswietlajacy ikone obok wsystkich plikow zaakceptowanych przez filtr
 */
public class FileIconView extends FileView {
    private FileFilter filter;
    private Icon icon;

    /**
     * Tworzy obiekt FIleIconView
     *
     * @param filter jako filtr plikow - wszystkie pliki zaakaceptowane przez ten filtr beda mialy ikone
     * @param icon   ikona wyswietlana obok wszystkich zaakceptowanych plikow
     */
    public FileIconView(FileFilter filter, Icon icon) {
        this.filter = filter;
        this.icon = icon;
    }

    public Icon getIcon(File f) {
        if (!f.isDirectory() && filter.accept(f)) return icon;
        else return null;
    }
}
