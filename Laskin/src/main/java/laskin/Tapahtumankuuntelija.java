package laskin;

import komennot.*;
import java.util.HashMap;
import java.util.Map;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Tapahtumankuuntelija implements EventHandler {

    private final TextField tuloskentta;
    private final TextField syotekentta;
    private final Button nollaa;
    private final Button undo;
    private final Sovelluslogiikka sovellus;
    private final Map<Button, Komento> komennot;
    private Komento edellinen;

    public Tapahtumankuuntelija(TextField tuloskentta, TextField syotekentta, Button plus, Button miinus, Button nollaa, Button undo) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = new Sovelluslogiikka();
        this.komennot = new HashMap();
        edellinen = null;
        komennot.put(nollaa, new Nollaa(sovellus, syotekentta, tuloskentta));
        komennot.put(plus, new Plus(sovellus, syotekentta, tuloskentta));
        komennot.put(miinus, new Miinus(sovellus, syotekentta, tuloskentta));

    }

    @Override
    public void handle(Event event) {
        Button valittuNappi = (Button) event.getTarget();
        if (valittuNappi != undo) {
            komennot.get(valittuNappi).suorita();
            edellinen = komennot.get(valittuNappi);
            undo.disableProperty().set(false);
            
            syotekentta.setText("");
            tuloskentta.setText("" + sovellus.tulos());

            if (sovellus.tulos() == 0) {
                nollaa.disableProperty().set(true);
            } else {
                nollaa.disableProperty().set(false);
            }
            

        } else {
            edellinen.peru();
            undo.disableProperty().set(true);
        }
    }

}
