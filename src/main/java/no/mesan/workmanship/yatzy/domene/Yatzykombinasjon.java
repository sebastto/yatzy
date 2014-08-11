package no.mesan.workmanship.yatzy.domene;


import no.mesan.workmanship.yatzy.beregning.EnereBeregner;
import no.mesan.workmanship.yatzy.beregning.KastBeregner;

public enum Yatzykombinasjon implements KastBeregner {
    ENERE("Enere", new EnereBeregner()),
    TOERE("Toere", null),
    TREERE("Treere", null),
    FIRERE("Firere", null),
    FEMMERE("Femmere", null),
    SEKSERE("Seksere", null),
    ETT_PAR("Ett par", null),
    TO_PAR("To par", null),
    TRE_LIKE("Tre like", null),
    FIRE_LIKE("Fire like", null),
    LITEN_STRAIGHT("Liten straight", null),
    STOR_STRAIGHT("Stor straight", null),
    HUS("Hus", null),
    SJANSE("Sjanse", null),
    YATZY("Yatzy", null);

    private final String navn;
    private KastBeregner faktiskBeregner;

    private Yatzykombinasjon(final String navn, final KastBeregner faktiskBeregner) {
        this.navn = navn;
        this.faktiskBeregner = faktiskBeregner;
    }

    @Override
    public Integer beregnPoengForKast(Kast kast) {
        return faktiskBeregner.beregnPoengForKast(kast);
    }

    KastBeregner getFaktiskBeregner() {
        return faktiskBeregner;
    }

    void setFaktiskBeregner(KastBeregner faktiskBeregner) {
        this.faktiskBeregner = faktiskBeregner;
    }

    @Override
    public String toString() {
        return navn;
    }
}
