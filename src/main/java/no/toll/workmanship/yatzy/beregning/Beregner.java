package no.toll.workmanship.yatzy.beregning;

import no.toll.workmanship.yatzy.domene.Kast;

public class Beregner implements YatzyBeregner {

    @Override
    public Integer beregnPoengsum(final Yatzykombinasjon yatzykombinasjon, final Integer ... terninger) {
        final Kast kast = new Kast(terninger);
        return yatzykombinasjon.beregnPoengForKast(kast);
    }
}