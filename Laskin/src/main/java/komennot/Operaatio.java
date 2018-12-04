package komennot;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import laskin.Sovelluslogiikka;

public abstract class Operaatio implements Komento {

    protected final Sovelluslogiikka sovellus;
    protected final TextField syotekentta;
    private final TextField tuloskentta;
    private final Button nollaa;
    private final Button undo;

    private String previousResult;

    public Operaatio(Sovelluslogiikka sovellus, TextField syotekentta, TextField tuloskentta, Button nollaa, Button undo) {
        this.sovellus = sovellus;
        this.syotekentta = syotekentta;
        this.tuloskentta = tuloskentta;
        this.nollaa = nollaa;
        this.undo = undo;
    }

    public void yleinenSuoritus() {
        undo.disableProperty().set(false);
        syotekentta.setText("");
        tuloskentta.setText("" + sovellus.tulos());
        asetaNollaaTila();

    }

    @Override
    public void peru() {
        sovellus.setTulos(Integer.parseInt(previousResult));
        tuloskentta.setText("" + previousResult);
        syotekentta.setText("");
    }

    private void asetaNollaaTila() {
        if (sovellus.tulos() == 0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }

    }

    protected void tallennaTulos() {
        previousResult = tuloskentta.getText();
    }

}
