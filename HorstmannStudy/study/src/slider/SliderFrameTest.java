package slider;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Pawel on 2017-07-23.
 */
public class SliderFrameTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new SliderFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("W sumie pierwsza ramka na gita");
            frame.setVisible(true);
        });
    }
}
