package no.mesan.workmanship.yatzy.domene;

import org.junit.Test;

import static org.junit.Assert.*;

public class KastTest {
    @Test
    public void nyttKastSkalTaVarePaTerninger() throws Exception {
        Integer[] verdier = new Integer[]{5,2,3,1,4};
        final Kast kast = new Kast(verdier);

        int i = 0;
        for (Terning terning : kast) {
            assertEquals(verdier[i], terning.asInt());
            i++;
        }
    }
}
