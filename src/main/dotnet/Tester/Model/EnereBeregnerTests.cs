using System;
using System.Text;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Yatzy.Model.Beregnere;
using Yatzy.Model;

namespace Tester.Model
{
    [TestClass]
    public class EnereBeregnerTests
    {
        [TestMethod]
        public void BeregnPoeng_KastUtenEnere_GirNullPoeng()
        {
            EnereBeregner beregner = new EnereBeregner();
            var kastUtenEnere = new Kast(2, 3, 4, 5, 4);
            var poeng = beregner.BeregnPoeng(kastUtenEnere);

            Assert.AreEqual(0, poeng);
        }

        [TestMethod]
        public void BeregnPoeng_KastMedTreEnere_GirTrePoeng()
        {
            EnereBeregner beregner = new EnereBeregner();
            var kastMedTreEnere = new Kast(1, 3, 1, 1, 4);
            var poeng = beregner.BeregnPoeng(kastMedTreEnere);

            Assert.AreEqual(3, poeng);
        }
    }
}
