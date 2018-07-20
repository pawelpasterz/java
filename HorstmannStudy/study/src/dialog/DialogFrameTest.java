package dialog;

import javax.swing.*;
import java.awt.*;

public class DialogFrameTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new DialogParentFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Kolejna, super zajebista ramka");
            frame.setVisible(true);
        });
    }
}
