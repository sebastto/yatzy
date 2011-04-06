using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Yatzy.Model
{
   public  interface IYatzyBeregner
    {
        int BeregnPoeng(Kast kast);
    }
}
