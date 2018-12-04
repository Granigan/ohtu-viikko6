package komennot;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import laskin.Sovelluslogiikka;

public class Nollaa extends YhdenParametrinLaskutoimitus {

    public Nollaa(Sovelluslogiikka sovellus, TextField syotekentta, TextField tuloskentta, Button nollaa, Button undo) {
        super(sovellus, syotekentta, tuloskentta, nollaa, undo);
    }

    @Override
    public void suorita() {
        super.tallennaTulos();
        sovellus.nollaa();
        super.yleinenSuoritus();
    }

}
