package no.mesan.workmanship.yatzy.beregning;

import no.mesan.workmanship.yatzy.domene.Kast;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EnereBeregnerTest {
    @Test
    public void skalGiNullPoengForKastUtenEnere() throws Exception {
        final EnereBeregner beregner = new EnereBeregner();

        final Kast kastUtenEnere = new Kast(2, 3, 4, 5, 4);
        final int kastVerdi = beregner.beregnPoengForKast(kastUtenEnere);
        assertEquals(0, kastVerdi);
    }
}
