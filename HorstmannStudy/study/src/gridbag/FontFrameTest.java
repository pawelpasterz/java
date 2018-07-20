package gridbag;

import javax.swing.*;
import java.awt.*;
import java.util.EventListener;

public class FontFrameTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new FontFrame();
            frame.setTitle("Smieszna ramka z duzym wyborem");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
