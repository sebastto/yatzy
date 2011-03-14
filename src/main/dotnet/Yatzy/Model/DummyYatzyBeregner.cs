using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Yatzy.Model
{
    public class DummyYatzyBeregner : IYatzyBeregner
    {
        public int BeregnResultat(YatzyKombinasjon kombinasjon, Kast kast)
        {
            int resultat = 0;
            foreach (var terning in kast.Terninger)
                resultat += terning.AntallØyne;

            return resultat;
        }
    }
}
