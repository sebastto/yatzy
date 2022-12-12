package net.kalars.workmanship.yatzy.domene;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KastTest {
    @Test
    public void nyttKastSkalTaVarePaTerninger() throws Exception {
        final Integer[] verdier = new Integer[]{5,2,3,1,4};
        final Kast kast = new Kast(verdier);

        int i = 0;
        for (final Terning terning : kast) {
            assertEquals(verdier[i], terning.asInt());
            i++;
        }
    }
}