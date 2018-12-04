package komennot;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import laskin.Sovelluslogiikka;

public class Miinus extends YhdenParametrinLaskutoimitus {

    public Miinus(Sovelluslogiikka sovellus, TextField syotekentta, TextField tuloskentta, Button nollaa, Button undo) {
        super(sovellus, syotekentta, tuloskentta, nollaa, undo);
    }

    @Override
    public void suorita() {
        super.tallennaTulos();
        sovellus.miinus(Integer.parseInt(syotekentta.getText()));
        super.yleinenSuoritus();
    }

}
