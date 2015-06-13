package no.mesan.workmanship.yatzy.beregning;

import no.mesan.workmanship.yatzy.domene.Kast;
import no.mesan.workmanship.yatzy.domene.Yatzykombinasjon;

public class Beregner implements YatzyBeregner {

    @Override
    public Integer beregnPoengsum(Yatzykombinasjon yatzykombinasjon, Integer ... terninger) {
        final Kast kast = new Kast(terninger);
        return yatzykombinasjon.beregnPoengForKast(kast);
    }
}
