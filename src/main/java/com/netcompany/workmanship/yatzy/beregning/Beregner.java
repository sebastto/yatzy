package com.netcompany.workmanship.yatzy.beregning;

import com.netcompany.workmanship.yatzy.domene.Kast;
import com.netcompany.workmanship.yatzy.domene.Yatzykombinasjon;

public class Beregner implements YatzyBeregner {

    @Override
    public Integer beregnPoengsum(Yatzykombinasjon yatzykombinasjon, Integer ... terninger) {
        final Kast kast = new Kast(terninger);
        return yatzykombinasjon.beregnPoengForKast(kast);
    }
}
