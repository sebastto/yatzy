package com.netcompany.workmanship.yatzy.domene;

import com.netcompany.workmanship.yatzy.beregning.EnereBeregner;
import com.netcompany.workmanship.yatzy.beregning.KastBeregner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class YatzyKombinasjonTest {
    @Test
    public void enereSkalBrukeEnereBeregner() {
        final KastBeregner enereBeregner = Yatzykombinasjon.ENERE.getFaktiskBeregner();
        assertTrue(enereBeregner instanceof EnereBeregner);
    }

    @Test
    public void kombinasjonSkalDelegereTilFaktiskBeregner() {
        Kast kast = mock(Kast.class);
        final KastBeregner beregner = mock(KastBeregner.class);
        when(beregner.beregnPoengForKast(kast)).thenReturn(5);

        final Yatzykombinasjon enere = Yatzykombinasjon.ENERE;
        enere.setFaktiskBeregner(beregner);

        final int beregnetVerdi = enere.beregnPoengForKast(kast);

        assertEquals(5, beregnetVerdi);
        verify(beregner).beregnPoengForKast(kast);
        // reset
        enere.setFaktiskBeregner(new EnereBeregner());
    }
}
