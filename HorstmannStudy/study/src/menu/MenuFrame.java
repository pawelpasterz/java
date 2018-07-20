package menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Pawel on 2017-07-23.
 */
public class MenuFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    private Action saveAction;
    private Action saveAsAction;
    private JCheckBoxMenuItem readonlyItem;
    private JPopupMenu popup;

    /**
     * Przykladowa akcja, ktora drukuje nazwe akcji do wyjscia System.out
     */
    class TestAction extends AbstractAction {
        public TestAction(String name) {
            super(name);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Wybrano " + getValue(Action.NAME));
        }
    }

    public MenuFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        JMenu fileMenu = new JMenu("Plik");
        fileMenu.add(new TestAction("Nowy"));

        //Akceleratory
        JMenuItem openItem = fileMenu.add(new TestAction("Otworz"));
        openItem.setAccelerator(KeyStroke.getKeyStroke("ctrl 0"));

        fileMenu.addSeparator();

        saveAction = new TestAction("Zapisz");
        JMenuItem saveItem = fileMenu.add(new TestAction("Zapisz"));
        saveItem.setAccelerator(KeyStroke.getKeyStroke("ctrl s"));

        saveAsAction = new TestAction("Zapisz jako");
        fileMenu.add(saveAsAction);
        fileMenu.addSeparator();

        fileMenu.add(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        //Menu z polem wyboru i przelacznikami
        readonlyItem = new JCheckBoxMenuItem("Tylko do odczytu");
        readonlyItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean saveOk = !readonlyItem.isSelected();
                saveAction.setEnabled(saveOk);
                saveAsAction.setEnabled(saveOk);
            }
        });

        ButtonGroup group = new ButtonGroup();

        JRadioButtonMenuItem insertItem = new JRadioButtonMenuItem("Wstawianie");
        insertItem.setSelected(true);
        JRadioButtonMenuItem overtypeItem = new JRadioButtonMenuItem("Nadpisywanie");

        group.add(insertItem);
        group.add(overtypeItem);

        Action cutAction = new TestAction("Wytnij");
        cutAction.putValue(Action.SMALL_ICON, new ImageIcon("copy.gif"));
        Action copyAction = new TestAction("Kopiuj");
        copyAction.putValue(Action.SMALL_ICON, new ImageIcon("copy.gif"));
        Action pasteAction = new TestAction("Wklej");
        pasteAction.putValue(Action.SMALL_ICON, new ImageIcon("paste.gif"));

        JMenu editMenu = new JMenu("Edycja");
        editMenu.add(cutAction);
        editMenu.add(copyAction);
        editMenu.add(pasteAction);

        //Zagniezdzone menu
        JMenu optionMenu = new JMenu("Opcje");
        optionMenu.add(readonlyItem);
        optionMenu.addSeparator();
        optionMenu.add(insertItem);
        optionMenu.add(overtypeItem);

        editMenu.addSeparator();
        editMenu.add(optionMenu);

        //Mnemoniki
        JMenu helpMenu = new JMenu("Pomoc");
        helpMenu.setMnemonic('P');

        JMenuItem indexItem = new JMenuItem("Indeks");
        indexItem.setMnemonic('I');
        helpMenu.add(indexItem);

        //Mnemoniki dod do akcji
        Action aboutAction = new TestAction("O programie");
        aboutAction.putValue(Action.MNEMONIC_KEY, new Integer('O'));
        helpMenu.add(aboutAction);

        //DOdanie wszystkich menu najwyzszego rzedu do paska menu
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        //Menu kontekstowe
        popup = new JPopupMenu();
        popup.add(cutAction);
        popup.add(copyAction);
        popup.add(pasteAction);

        JPanel panel = new JPanel();
        panel.setComponentPopupMenu(popup);
        add(panel);
    }
}
