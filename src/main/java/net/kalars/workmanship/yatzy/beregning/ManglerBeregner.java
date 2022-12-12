package net.kalars.workmanship.yatzy.beregning;

import net.kalars.workmanship.yatzy.domene.Kast;

public class ManglerBeregner implements KastBeregner {

    private final String hva;

    public ManglerBeregner(final String hva) {
        this.hva = hva;
    }

    @Override
    public Integer beregnPoengForKast(final Kast kast) {
        System.out.println(hva);
        return 0;
    }
}