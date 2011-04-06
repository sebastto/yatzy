using System;
using System.Text;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Yatzy.Model;

namespace Tester.Model
{
    [TestClass]
    public class KastTests
    {

        [TestMethod]
        public void Kast_TarVarePåTerninger()
        {
            int[] verdier = new int[] { 5, 2, 3, 1, 4 };
            Kast kast = new Kast(verdier);

            int i = 0;
            foreach (var terning in kast.Terninger)
            {
                Assert.AreEqual(verdier[i], terning.AntallØyne);
                i++;
            }
        }
    }
}
