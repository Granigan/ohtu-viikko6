package komennot;

import javafx.scene.control.TextField;
import laskin.Komento;
import laskin.Sovelluslogiikka;

public class Miinus implements Komento {
    private final Sovelluslogiikka sovellus;
    private final TextField syotekentta;
    private final TextField tuloskentta;
    private String previousResult;

    
    public Miinus(Sovelluslogiikka sovellus, TextField syotekentta, TextField tuloskentta) {
        this.sovellus = sovellus;
        this.syotekentta = syotekentta;
        this.tuloskentta = tuloskentta;
    }
    
    @Override
    public void suorita() {
        previousResult = tuloskentta.getText();
        sovellus.miinus(Integer.parseInt(syotekentta.getText()));
    }

    @Override
    public void peru() {
        sovellus.setTulos(Integer.parseInt(previousResult));
        tuloskentta.setText("" + previousResult);
        syotekentta.setText("");
    }

}
