package no.mesan.workmanship.yatzy.domene;


public enum Yatzykombinasjon {
	ENERE("Enere"),
	TOERE("Toere"),
	TREERE("Treere"),
	FIRERE("Firere"),
	FEMMERE("Femmere"),
	SEKSERE("Seksere"),
	ETT_PAR("Ett par"),
	TO_PAR("To par"),
	TRE_LIKE("Tre like"),
	FIRE_LIKE("Fire like"),
	LITEN_STRAIGHT("Liten straight"),
	STOR_STRAIGHT("Stor straight"),
	HUS("Hus"),
	SJANSE("Sjanse"),
	YATZY("Yatzy");
	
	private final String navn;

	private Yatzykombinasjon(final String navn) {
		this.navn = navn;
	}
	
	@Override
	public String toString() {
		return navn;
	}
}
