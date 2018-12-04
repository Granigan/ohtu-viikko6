package laskin;

import komennot.Komento;
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
        komennot.put(nollaa, new Nollaa(sovellus, syotekentta, tuloskentta, nollaa, undo));
        komennot.put(plus, new Plus(sovellus, syotekentta, tuloskentta, nollaa, undo));
        komennot.put(miinus, new Miinus(sovellus, syotekentta, tuloskentta, nollaa, undo));

    }

    @Override
    public void handle(Event event) {
        Button valittuNappi = (Button) event.getTarget();
        if (valittuNappi != undo) {
            komennot.get(valittuNappi).suorita();
            edellinen = komennot.get(valittuNappi);
        } else {
            edellinen.peru();
            undo.disableProperty().set(true);
        }
    }

}
