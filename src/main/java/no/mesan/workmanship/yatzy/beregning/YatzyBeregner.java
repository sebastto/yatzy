package no.mesan.workmanship.yatzy.beregning;

import no.mesan.workmanship.yatzy.domene.Yatzykombinasjon;


public interface YatzyBeregner {
	Integer beregnPoengsum(Yatzykombinasjon yatzykombinasjon, Integer... terninger);
}
