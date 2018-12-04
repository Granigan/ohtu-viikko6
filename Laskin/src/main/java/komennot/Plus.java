package komennot;

import javafx.scene.control.TextField;
import laskin.Komento;
import laskin.Sovelluslogiikka;

public class Plus implements Komento {

    private final Sovelluslogiikka sovellus;
    private final TextField syotekentta;

    public Plus(Sovelluslogiikka sovellus, TextField syotekentta) {
        this.sovellus = sovellus;
        this.syotekentta = syotekentta;
    }

    @Override
    public void suorita() {
        sovellus.plus(Integer.parseInt(syotekentta.getText()));
    }

}
