package com.netcompany.workmanship.yatzy.beregning;

import com.netcompany.workmanship.yatzy.domene.Yatzykombinasjon;

public class AntallOyneBeregner implements YatzyBeregner {
    @Override
    public Integer beregnPoengsum(Yatzykombinasjon yatzykombinasjon, Integer... terninger) {
        int antallOyne = 0;
        for (Integer terning : terninger) {
            antallOyne += terning;
        }
        return antallOyne;
    }
}
