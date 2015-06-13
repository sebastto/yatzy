using StructureMap.Configuration.DSL;
using Yatzy.Model;
using Yatzy.Model.Beregnere;

namespace Yatzy.Framework
{
	public class YatzyRegistry : Registry
	{
		public YatzyRegistry()
		{
			For<IYatzyBeregner>().Singleton().Use<EnerBeregner>().Named(YatzyKombinasjon.Enere.ToString());
			For<IYatzyBeregner>().Singleton().Use<ToerBeregner>().Named(YatzyKombinasjon.Toere.ToString());
		}
	}
}
