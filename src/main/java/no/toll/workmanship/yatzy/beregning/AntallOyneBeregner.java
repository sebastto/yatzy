package no.toll.workmanship.yatzy.beregning;

public class AntallOyneBeregner implements YatzyBeregner {
    @Override
    public Integer beregnPoengsum(final Yatzykombinasjon yatzykombinasjon, final Integer... terninger) {
        int antallOyne = 0;
        for (final Integer terning : terninger) {
            antallOyne += terning;
        }
        return antallOyne;
    }
}