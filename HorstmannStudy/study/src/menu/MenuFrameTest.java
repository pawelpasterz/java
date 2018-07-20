package menu;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Pawel on 2017-07-23.
 */
public class MenuFrameTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new MenuFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Smiszna ramka lol do kwadratu");
            frame.setVisible(true);
        });
    }
}
