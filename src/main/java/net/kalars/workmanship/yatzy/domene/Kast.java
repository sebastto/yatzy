package net.kalars.workmanship.yatzy.domene;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Kast implements Iterable<Terning> {

    private final List<Terning> terninger = new ArrayList<>();

    public Kast(final Integer ... verdier) {
        for (final int verdi : verdier) {
            this.terninger.add(new Terning(verdi));
        }
    }

    @Override
    public Iterator<Terning> iterator() {
        return this.terninger.iterator();
    }
}