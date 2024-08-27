package no.toll.workmanship.yatzy.beregning;

import no.toll.workmanship.yatzy.domene.Kast;
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
}
