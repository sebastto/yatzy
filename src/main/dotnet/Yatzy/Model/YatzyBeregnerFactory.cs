using Yatzy.Model.Beregnere;

namespace Yatzy.Model
{
    public class YatzyBeregnerFactory
    {
        public IYatzyBeregner Beregner { get; set; }

        public IYatzyBeregner HentKombinasjonsBeregner(YatzyKombinasjon kombinasjon)
        {
            switch (kombinasjon)
            {
                case YatzyKombinasjon.Enere:
                    Beregner = new EnerBeregner();
                    break;

                //case YatzyKombinasjon.Toere:
                //    Beregner = new ToereBeregner();
                //    break;
                
                // [....]
            }

            return Beregner;
        }


    }
}
