package com.netcompany.workmanship.yatzy.domene;

public interface YatzyBrett {
    /**
     * Tar imot et kast og en kombinasjon. Plasserer kastet på denne kombinasjonen om mulig, kaster IllegalArgumentException
     * om det ikke er mulig.
     *
     * @param kast Ferdig trillet kast.
     * @param kombinasjon Kombinasjon som skal brukes.
     */
    void plasserKast(Kast kast, Yatzykombinasjon kombinasjon);

    /**
     * Henter poengsum for gitt kombinasjon.
     *
     * @param kombinasjon Kombinasjon.
     * @return Poengsum for kombinasjon. 0 returneres dersom kast ikke er plassert for kombinasjon.
     */
    int poengForKombinasjon(Yatzykombinasjon kombinasjon);

    /**
     * Regner ut poengsum for poeng over streken (1-6)
     * @return Poengsum.
     */
    int sumOverStreken();

    /**
     * Regner ut bonussum. Gir 50 poeng dersom sum over streken er 63 eller bedre, 0 ellers.
     * @return Bonussum.
     */
    int bonusSum();

    /**
     * Regner ut totalsum for hele brettet.
     *
     * @return Total poengsum oppnådd.
     */
    int totalSum();
}
