# Yatzy

Utgangspunkt for kursene "Tvungen OO" og TDD

## Regler'

Man kan ha lange og lite gode diskusjoner om reglene i Yatzy. De som har betydning for vår implementasjon kommer her:
1.	det spilles med 5 terninger
2.	det gjøres 3 kast i hver runde
3.	det er 15 runder per deltaker per omgang
4.	man kan holde igjen og/eller kaste på nytt så mange terninger man vil etter første og andre kast (så ved å holde igjen alle avslutter man runden)
5.	man velger hvor resultatet føres for runden etter siste kast; dersom kastet ikke er gyldig for gitt kategori, settes poengsummen til 0 (man «stryker» verdien)
6.	brettet er delt i 2 deler, øvre og nedre; det beregnes en delsum for øvre del av brettet, dersom denne er >=63 tildeles en ekstra bonus på 50 poeng
7.	den vinner omgangen som har flest poeng etter siste runde

### Øvre del

| Navn | Validering | Kalkulasjon |
| ---- | ---- | ---- |
|Enere | Kun terninger som viser 1 teller med | Summen av de 0-5 gyldige terningene|
|Toere | Kun terninger som viser 2 teller med | Summen av de 0-5 gyldige terningene|
|Treere | Kun terninger som viser 3 teller med | Summen av de 0-5 gyldige terningene|
|Firere | Kun terninger som viser 4 teller med | Summen av de 0-5 gyldige terningene|
|Femmere | Kun terninger som viser 5 teller med | Summen av de 0-5 gyldige terningene|
|Seksere | Kun terninger som viser 6 teller med | Summen av de 0-5 gyldige terningene|
|(Bonus) | n/a | 50 hvis summen av de foregående >=63, ellers 0|

### Nedre del
| Navn | Validering | Kalkulasjon |
| ---- | ---- | ---- |
| Par | 2 terninger må vise samme verdi, ingen andre par av like terninger gir høyere verdi | Summen av de 2 gyldige terningene |
| To par | To og to terninger må vise samme verdi (som kan være lik for alle 4), den siste terningen ignoreres | Summen av de 4 gyldige terningene |
| Tre like | Minst 3 terninger må vise samme verdi, de øvrige ignoreres | Summen av de 3 gyldige terningene |
| Fire like | Minst 4 terninger må vise samme verdi, den siste ignoreres | Summen av de 4 gyldige terningene |
| Hus | 3 av terningene må ha samme verdi, de 2 resterende må ha lik verdi, som ikke kan være lik de 3 andre (omdiskutert ;) | Summen av de 5 gyldige terningene |
| Liten straight | Terningene må ha verdi 1-2-3-4-5 | Summen av de 5 gyldige terningene |
| Stor straight | Terningene må ha verdi 2-3-4-5-6 | Summen av de 5 gyldige terningene |
| Sjanse | Alt er gyldig | Summen av de 5 gyldige terningene |
| Yatzy | Alle 5 terninger må ha samme verdi | 50 poeng |
| Sum | n/a | Summen av de 15 rundene + bonus |
