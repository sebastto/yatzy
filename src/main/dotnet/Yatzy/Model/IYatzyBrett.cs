
namespace Yatzy.Model
{
    public interface IYatzyBrett
    {
        /// <summary>
        /// Tar imot et kast og en kombinasjon. Plasserer kastet på denne kombinasjonen om mulig, kaster ArgumentException om det ikke er mulig.
        /// </summary>
        /// <param name="kast">Ferdig trillet kast.</param>
        /// <param name="kombinasjon">Kombinasjon som skal brukes.</param>
        void PlasserKast(Kast kast, YatzyKombinasjon kombinasjon);

        /// <summary>
        /// Henter poengsum for gitt kombinasjon.
        /// </summary>
        /// <param name="kombinasjon">Kombinasjon.</param>
        /// <returns>Poengsum for kombinasjon. 0 returneres dersom kast ikke er plassert for kombinasjon.</returns>
        int PoengForKombinasjon(YatzyKombinasjon kombinasjon);

        /// <summary>
        /// Regner ut poengsum for poeng over streken (1-6)
        /// </summary>
        /// <returns>Poengsum.</returns>
        int SumOverStreken();


        /// <summary>
        /// Regner ut bonussum. Gir 50 poeng dersom sum over streken er 63 eller bedre, 0 ellers.
        /// </summary>
        /// <returns>Bonussum.</returns>
        int BonusSum();

        /// <summary>
        /// Regner ut totalsum for hele brettet.
        /// </summary>
        /// <returns>Total poengsum oppnådd.</returns>
        int TotalSum();
    }

}
