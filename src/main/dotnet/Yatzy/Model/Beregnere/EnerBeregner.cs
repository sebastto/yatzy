using System;
using System.Linq;

namespace Yatzy.Model.Beregnere
{
	public class TallBeregner : IYatzyBeregner
	{
		private int _tall;
		public TallBeregner(int tall)
		{
			if(tall <= 0 || tall > 6)
				throw  new ArgumentException("Ugyldig tall for beregner");

			_tall = tall;
		}

		public int BeregnPoeng(Kast kast)
		{
			return kast.Terninger.Sum(o => o.AntallØyne == _tall ? _tall : 0);
		}
	}

    public class EnerBeregner : TallBeregner
    {
	    public EnerBeregner()
			: base(1)
	    {		    
	    }
    }
}
