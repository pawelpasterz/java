package button;

import javax.swing.*;

/**
 * Created by Pawel on 2017-07-19.
 */
public class PlatfFrame extends JFrame {
    private JPanel buttonPanel;

    public PlatfFrame() {
        buttonPanel = new JPanel();
        UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo info : infos)
            makeButton(info.getName(), info.getClassName());

        add(buttonPanel);
        pack();
    }

    private void makeButton(String name, String className) {
        JButton button = new JButton(name);
        buttonPanel.add(button);

        //button.addActionListener(() -> {
        //    try {
        //        UIManager.setLookAndFeel(className);
        //        SwingUtilities.updateComponentTreeUI(this);
        //        pack();
        //    }
        //    catch (Exception e) {
        //        e.printStackTrace();
        //    }
        //});
    }
}
