using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Yatzy.Model
{
   public  interface IYatzyBeregner
    {
        int BeregnResultat(YatzyKombinasjon kombinasjon, Kast kast);
    }
}
