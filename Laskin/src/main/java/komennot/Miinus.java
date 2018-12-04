package komennot;

import javafx.scene.control.TextField;
import laskin.Komento;
import laskin.Sovelluslogiikka;

public class Miinus implements Komento {
    private final Sovelluslogiikka sovellus;
    private final TextField syotekentta;
    
    public Miinus(Sovelluslogiikka sovellus, TextField syotekentta) {
        this.sovellus = sovellus;
        this.syotekentta = syotekentta;
    }
    
    @Override
    public void suorita() {
        sovellus.miinus(Integer.parseInt(syotekentta.getText()));
    }

}
