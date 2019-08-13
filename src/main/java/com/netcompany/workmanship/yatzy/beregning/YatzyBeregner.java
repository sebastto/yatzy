package com.netcompany.workmanship.yatzy.beregning;

import com.netcompany.workmanship.yatzy.domene.Yatzykombinasjon;

public interface YatzyBeregner {
    Integer beregnPoengsum(Yatzykombinasjon yatzykombinasjon, Integer... terninger);
}
