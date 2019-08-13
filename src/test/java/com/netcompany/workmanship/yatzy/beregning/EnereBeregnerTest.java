package com.netcompany.workmanship.yatzy.beregning;

import com.netcompany.workmanship.yatzy.domene.Kast;
import org.junit.Test;

import static org.junit.Assert.*;

public class EnereBeregnerTest {
    @Test
    public void beregnPoengForKast_medIngenEnere_skalGiNullPoeng() {
        final EnereBeregner beregner = new EnereBeregner();
        final Kast kastUtenEnere = new Kast(2, 3, 5, 6, 4);

        final int poeng = beregner.beregnPoengForKast(kastUtenEnere);

        assertEquals(0, poeng);
    }
}
