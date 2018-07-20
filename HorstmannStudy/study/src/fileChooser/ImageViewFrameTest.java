package fileChooser;

import javax.swing.*;
import java.awt.*;

public class ImageViewFrameTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new ImageViewFrame();
            frame.setTitle("Wybor plikow");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
