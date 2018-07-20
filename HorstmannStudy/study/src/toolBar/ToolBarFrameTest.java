package toolBar;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Pawel on 2017-07-25.
 */
public class ToolBarFrameTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new ToolBarFrame();
            frame.setTitle("Ramka z tool barem");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
