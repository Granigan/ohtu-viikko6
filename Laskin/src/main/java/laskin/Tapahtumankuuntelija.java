package laskin;

import java.util.HashMap;
import java.util.Map;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Tapahtumankuuntelija implements EventHandler {
    private final TextField tuloskentta; 
    private final TextField syotekentta; 
    private final Button plus;
    private final Button miinus;
    private final Button nollaa;
    private final Button undo;
    private final Sovelluslogiikka sovellus;
    private Map<Button, Komento> komennot;

    public Tapahtumankuuntelija(TextField tuloskentta, TextField syotekentta, Button plus, Button miinus, Button nollaa, Button undo) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.plus = plus;
        this.miinus = miinus;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = new Sovelluslogiikka();
        this.komennot = new HashMap();
        komennot.put(this.nollaa, new Nollaa(sovellus));
        
    }
    
    @Override
    public void handle(Event event) {
        
        int arvo = 0;
 
        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
 
        if (event.getTarget() == plus) {
            sovellus.plus(arvo);
        } else if (event.getTarget() == miinus) {
            sovellus.miinus(arvo);
        } else if (event.getTarget() == nollaa) {
            komennot.get(event.getTarget()).suorita();
//            sovellus.nollaa();
        } else {
            System.out.println("undo pressed");
        }
        
        int laskunTulos = sovellus.tulos();
        
        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);
        
        if ( laskunTulos==0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(false);
    }

}
