package robot;

import button.ButtonFrame;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

public class RobotTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            ButtonFrame frame = new ButtonFrame();
            frame.setTitle("Button test via robot");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
        //Powiazanie robota z ekranem
        GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice screen = environment.getDefaultScreenDevice();

        try {
            final Robot robot = new Robot(screen);
            robot.waitForIdle();
            new Thread(() ->
                    runTest(robot)
            ).start();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    /**
     * Uruchamia procedure startowa
     *
     * @param robot robot zwiazany z ekranem
     */
    public static void runTest(Robot robot) {
        //Symulacja nacisniecia spacji
        robot.keyPress(' ');
        robot.keyRelease(' ');

        //Symulacja nacisniecia klawisza Tab i spacji
        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(' ');
        robot.keyRelease(' ');

        //Symulacja kliniecia mysza prawego przycisku w oknie
        robot.delay(2000);
        robot.mouseMove(220, 40);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);

        //Zrobienie zrzutu ekranu i wyswietlenie wynikow
        robot.delay(2000);
        BufferedImage image = robot.createScreenCapture(new Rectangle(0, 0, 400, 300));

        ImageFrame frame = new ImageFrame(image);
        frame.setVisible(true);
    }
}

/**
 * Ramka zawierajaca  wyswietlany obraz
 */
class ImageFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 450;
    private static final int DEFAULT_HEIGHT = 350;

    public ImageFrame(Image image) {
        setTitle("Zrzut ekranu");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        JLabel label = new JLabel(new ImageIcon(image));
        add(label);
    }
}
