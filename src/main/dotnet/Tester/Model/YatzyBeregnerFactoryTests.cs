using Microsoft.VisualStudio.TestTools.UnitTesting;
using Should;
using Yatzy.Model;
using Yatzy.Model.Beregnere;

namespace Yatzy.UnitTests.Model
{
    [TestClass]
    public class YatzyBeregnerFactoryTests
    {
        private YatzyBeregnerFactory _factory = new YatzyBeregnerFactory();

        [TestMethod]
        public void LagBeregnerForKombinasjon_MedEnereKombinasjon_ReturnererEnereBeregner()
        {
			// act
            var enerBeregner = _factory.HentKombinasjonsBeregner(YatzyKombinasjon.Enere);

			// Assert
	        enerBeregner.ShouldBeType<EnerBeregner>();            
        }
    }
}
