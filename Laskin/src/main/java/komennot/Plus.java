package komennot;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import laskin.Sovelluslogiikka;

public class Plus extends Operaatio {

    public Plus(Sovelluslogiikka sovellus, TextField syotekentta, TextField tuloskentta, Button nollaa, Button undo) {
        super(sovellus, syotekentta, tuloskentta, nollaa, undo);
    }

    @Override
    public void suorita() {
        super.tallennaTulos();
        super.sovellus.plus(Integer.parseInt(super.syotekentta.getText()));
        super.yleinenSuoritus();
    }

}
