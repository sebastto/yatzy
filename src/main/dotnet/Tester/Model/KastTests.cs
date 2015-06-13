using Microsoft.VisualStudio.TestTools.UnitTesting;
using Yatzy.Model;

namespace Yatzy.UnitTests.Model
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
