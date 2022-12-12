package no.toll.workmanship.yatzy.domene;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TerningTest {
    @Test
    public void terningTarVarePaVerdi() {
        final Terning t1 = new Terning(1);
        assertEquals(1, t1.asInt().intValue());

        final Terning t3 = new Terning(3);
        assertEquals(3, t3.asInt().intValue());
    }

}