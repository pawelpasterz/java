package button;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Pawel on 2017-07-18.
 */
public class TestButtonFrame {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new ActionFrame();
            frame.setTitle("Fajne okienko");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
