package no.mesan.workmanship.yatzy.presentasjon;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import no.mesan.workmanship.yatzy.beregning.YatzyBeregner;
import no.mesan.workmanship.yatzy.domene.Yatzykombinasjon;


public class YatzyPresentasjonsmodellImplTest {
    private YatzyPresentasjonsmodellImpl presMod;

    @Before
    public void settOpp() {
        presMod = new YatzyPresentasjonsmodellImpl(new YatzyBeregner() {
            @Override
            public Integer beregnPoengsum(Yatzykombinasjon yatzykombinasjon, Integer... terninger) {
                return 0;
            }
        });
    }

    @Test
    public void vedStartSkalNyRundeVaereAv() {
        assertFalse(presMod.nyRundeAction().isEnabled());
    }

    @Test
    public void vedStartSkalKastVaerePaa() {
        assertTrue(presMod.kastAction().isEnabled());
    }

    @Test
    public void etterTreKastSkalKastVaereAvOgNyRundePaa() {
        presMod.kastAction().actionPerformed(null);
        presMod.kastAction().actionPerformed(null);
        presMod.kastAction().actionPerformed(null);
        assertFalse(presMod.kastAction().isEnabled());
        assertTrue(presMod.nyRundeAction().isEnabled());
    }

    @Test
    public void holdtTerningSkalLaasesVedKast() {
        presMod.kastAction().actionPerformed(null);
        presMod.holdTerningModeller()[0].setValue(true);
        presMod.kastAction().actionPerformed(null);
        assertFalse(presMod.holdTerningModeller()[0].isEnabled());
    }

    /** TODO **/
}
