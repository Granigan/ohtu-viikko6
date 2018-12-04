package komennot;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import laskin.Sovelluslogiikka;

public class Miinus implements Komento {
    private final Sovelluslogiikka sovellus;
    private final TextField syotekentta;
    private final TextField tuloskentta;
    private final Button nollaa;
    private final Button undo;

    private String previousResult;

    
    public Miinus(Sovelluslogiikka sovellus, TextField syotekentta, TextField tuloskentta, Button nollaa, Button undo) {
        this.sovellus = sovellus;
        this.syotekentta = syotekentta;
        this.tuloskentta = tuloskentta;
        this.nollaa = nollaa;
        this.undo = undo;
    }
    
    @Override
    public void suorita() {
        previousResult = tuloskentta.getText();
        sovellus.miinus(Integer.parseInt(syotekentta.getText()));
        undo.disableProperty().set(false);
        syotekentta.setText("");
        tuloskentta.setText("" + sovellus.tulos());
        setNollaState();
    }

    @Override
    public void peru() {
        sovellus.setTulos(Integer.parseInt(previousResult));
        tuloskentta.setText("" + previousResult);
        syotekentta.setText("");
    }

        private void setNollaState() {
        if (sovellus.tulos() == 0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }

    }

}