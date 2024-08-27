package no.toll.workmanship.yatzy.beregning;

import no.toll.workmanship.yatzy.domene.Kast;

public class EnereBeregner implements KastBeregner {

    @Override
    public Integer beregnPoengForKast(final Kast kast) {
        var sum = 0;
        for (var terning : kast) {
            if (terning.asInt() == 1) {
                sum += 1;
            }
        }
        return sum;
    }
}
