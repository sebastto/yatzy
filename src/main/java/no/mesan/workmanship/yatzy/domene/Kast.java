package no.mesan.workmanship.yatzy.domene;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Kast implements Iterable<Terning> {

    private List<Terning> terninger = new ArrayList<Terning>();

    public Kast(Integer ... verdier) {
        for (int verdi : verdier) {
            terninger.add(new Terning(verdi));
        }
    }

    @Override
    public Iterator<Terning> iterator() {
        return terninger.iterator();
    }
}
