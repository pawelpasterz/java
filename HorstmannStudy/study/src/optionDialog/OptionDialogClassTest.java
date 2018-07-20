package optionDialog;

import oracle.jrockit.jfr.JFR;

import javax.swing.*;
import java.awt.*;

public class OptionDialogClassTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new OptionDialogFrame();
            frame.setTitle("Okono dialogowe z roznymi zajebistymi opcjami");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
