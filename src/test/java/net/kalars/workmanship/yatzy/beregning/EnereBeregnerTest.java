package net.kalars.workmanship.yatzy.beregning;

import net.kalars.workmanship.yatzy.domene.Kast;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnereBeregnerTest {
    @Test
    public void beregnPoengForKast_medIngenEnere_skalGiNullPoeng() {
        final EnereBeregner beregner = new EnereBeregner();
        final Kast kastUtenEnere = new Kast(2, 3, 5, 6, 4);

        final int poeng = beregner.beregnPoengForKast(kastUtenEnere);

        assertEquals(0, poeng);
    }
}