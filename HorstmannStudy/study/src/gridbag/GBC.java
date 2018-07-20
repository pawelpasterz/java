package gridbag;

import java.awt.*;

public class GBC extends GridBagConstraints {
    /**
     * Tworzy obiekt typu GBC z podanymi wartosciami gridx i gridy oraz wszystkimi pozostalymi parametrami
     * ustawionymi na wartosci domyslne
     *
     * @param gridx wspolrzedna gridx
     * @param gridy wspolrzedna gridy
     */
    public GBC(int gridx, int gridy) {
        this.gridx = gridx;
        this.gridy = gridy;
    }

    /**
     * Tworzy obiekt typu GBC z podanymi wartosciami gridx, gridy, gridheight oraz gridweidth.
     * Pozostale paraetry przyjmuja wartosci domyslne.
     *
     * @param gridx      wspolrzedna gridx
     * @param gridy      wspolrzedna gridy
     * @param gridwidth  liczba zajmowanych komorek w poziomie
     * @param gridheight liczba zajmowanych komorek w pionie
     */
    public GBC(int gridx, int gridy, int gridwidth, int gridheight) {
        this.gridx = gridx;
        this.gridy = gridy;
        this.gridheight = gridheight;
        this.gridwidth = gridwidth;
    }

    /**
     * Ustawia parametr anchor (w klasie GridBagConstrains)
     *
     * @param anchor wartosc parametru anchor
     * @return this obiekt do dalszej modyfikacji
     */
    public GBC setAnchor(int anchor) {
        this.anchor = anchor;
        return this;
    }

    /**
     * Ustawia parametr fill
     *
     * @param fill wartosc parametru fill
     * @return this obiekt do dalszej modyfikacji
     */
    public GBC setFill(int fill) {
        this.fill = fill;
        return this;
    }

    /**
     * Ustawia parametry weight komorek
     *
     * @param weightx parametr weight w poziomie
     * @param weighty parametr weight w pionie
     * @return this obiekt do dalszej modyfikacji
     */
    public GBC setWeight(double weightx, double weighty) {
        this.weightx = weightx;
        this.weighty = weighty;
        return this;
    }

    /**
     * Ustawia dodatkowa pusta przestrzen w komorce
     *
     * @param distance dopelninie we wszystkich ierunkach
     * @return this obiekt do dalszej modyfikacji
     */
    public GBC setInsets(int distance) {
        this.insets = new Insets(distance, distance, distance, distance);
        return this;
    }

    /**
     * Utawia dopelnienia w komorce
     *
     * @param top    odstep od gornej krawedzi
     * @param left   odstep od lewej krawedzi
     * @param bottom odstep od dolnej krawedzi
     * @param right  odstep od prawej krawedzi
     * @return this obiekt do daleszej modyfikacji
     */
    public GBC setInsets(int top, int left, int bottom, int right) {
        this.insets = new Insets(top, left, bottom, right);
        return this;
    }

    /**
     * Ustawia dopelnieni wewnetrzne
     *
     * @param ipadx dopelnienie wenetrzne poziome
     * @param ipady dopelnieni zewnetrzne pionowe
     * @return this obiekt do dalszych modyfikacji
     */
    public GBC setIpad(int ipadx, int ipady) {
        this.ipadx = ipadx;
        this.ipady = ipady;
        return this;
    }
}
