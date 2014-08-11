using Microsoft.VisualStudio.TestTools.UnitTesting;
using Should;
using Yatzy.Model;
using Yatzy.Model.Beregnere;

namespace Yatzy.UnitTests.Model.Beregnere
{
    [TestClass]
    public class EnerBeregnerTests
    {
        [TestMethod]
        public void BeregnPoeng_KastUtenEnere_GirNullPoeng()
        {
			// Arrange
            EnerBeregner beregner = new EnerBeregner();
            var kastUtenEnere = new Kast(2, 3, 4, 5, 4);

			// Act
            var poeng = beregner.BeregnPoeng(kastUtenEnere);

			// Assert
			poeng.ShouldEqual(0);
        }

        [TestMethod]
        public void BeregnPoeng_KastMedTreEnere_GirTrePoeng()
        {
			// Arrange
            EnerBeregner beregner = new EnerBeregner();
            var kastMedTreEnere = new Kast(1, 3, 1, 1, 4);

			// Act
            var poeng = beregner.BeregnPoeng(kastMedTreEnere);

			// Assert
	        poeng.ShouldEqual(3);
        }
    }
}
