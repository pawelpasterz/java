package optionDialog;

import com.sun.deploy.panel.JavaPanel;

import javax.swing.*;

public class ButtonPanel extends JPanel {
    private ButtonGroup group;

    /**
     * Tworzy panel przysciskow
     *
     * @param title   Tytul wyswietlany w obramowaniu
     * @param options Tablica eytkiet rzelacznikow
     */
    public ButtonPanel(String title, String... options) {
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), title));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        group = new ButtonGroup();

        //Utworzenie po jednym przelaczniku dla kazdej opcji
        for (String option : options) {
            JRadioButton b = new JRadioButton(option);
            b.setActionCommand(option);
            add(b);
            group.add(b);
            b.setSelected(option == options[0]);
        }
    }

    /**
     * Pobiera aktualnie wybrana opcje
     *
     * @return Zwraca etykiete aktualnie wybranego przelacznika
     */
    public String getSelection() {
        return group.getSelection().getActionCommand();
    }
}
