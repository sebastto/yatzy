package no.mesan.workmanship.yatzy.presentasjon;

import junit.framework.Assert;
import no.mesan.workmanship.yatzy.beregning.YatzyBeregner;
import no.mesan.workmanship.yatzy.domene.Yatzykombinasjon;

import org.junit.Before;
import org.junit.Test;


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
		Assert.assertFalse(presMod.nyRundeAction().isEnabled());
	}
	
	@Test
	public void vedStartSkalKastVaerePaa() {
		Assert.assertTrue(presMod.kastAction().isEnabled());
	}
	
	@Test
	public void etterTreKastSkalKastVaereAvOgNyRundePaa() {
		presMod.kastAction().actionPerformed(null);
		presMod.kastAction().actionPerformed(null);
		presMod.kastAction().actionPerformed(null);
		Assert.assertFalse(presMod.kastAction().isEnabled());
		Assert.assertTrue(presMod.nyRundeAction().isEnabled());
	}
	
	@Test
	public void holdtTerningSkalLaasesVedKast() {
		presMod.kastAction().actionPerformed(null);
		presMod.holdTerningModeller()[0].setValue(true);
		presMod.kastAction().actionPerformed(null);
		Assert.assertFalse(presMod.holdTerningModeller()[0].isEnabled());
	}
	
	/** TODO **/
}
