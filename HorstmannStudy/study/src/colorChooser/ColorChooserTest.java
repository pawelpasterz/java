package colorChooser;

import javax.swing.*;
import java.awt.*;

public class ColorChooserTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame();
            JPanel panel = new ColorChooserPanel();
            panel.setPreferredSize(new Dimension(300, 300));
            frame.setLayout(new BorderLayout());
            frame.add(panel, BorderLayout.NORTH);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Wybor koloru");
            frame.pack();
            frame.setVisible(true);
        });
    }
}
