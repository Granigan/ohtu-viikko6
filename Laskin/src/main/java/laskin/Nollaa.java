package laskin;

public class Nollaa implements Komento {
    private Sovelluslogiikka sovellus;

    public Nollaa (Sovelluslogiikka sovellus) {
        this.sovellus = sovellus;
    }
    
    @Override
    public void suorita() {
        sovellus.nollaa();
    }
    
}
