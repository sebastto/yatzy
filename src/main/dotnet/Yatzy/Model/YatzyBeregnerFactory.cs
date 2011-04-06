using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Yatzy.Model.Beregnere;

namespace Yatzy.Model
{
    public class YatzyBeregnerFactory
    {
        public IYatzyBeregner Beregner { get; set; }

        public IYatzyBeregner LagBeregnerForKombinasjon(YatzyKombinasjon kombinasjon)
        {
            switch (kombinasjon)
            {
                case YatzyKombinasjon.Enere:
                    Beregner = new EnereBeregner();
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
