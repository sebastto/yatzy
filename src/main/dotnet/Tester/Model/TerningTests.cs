using Microsoft.VisualStudio.TestTools.UnitTesting;
using Yatzy.Model;

namespace Yatzy.UnitTests.Model
{
    [TestClass]
    public class TerningTests
    {
        [TestMethod]
        public void Terning_TarVarePåVerdi()
        {
            var t1 = new Terning(1);
            Assert.AreEqual(1, t1.AntallØyne);

            var t3 = new Terning(3);
            Assert.AreEqual(3, t3.AntallØyne);
        }
    }
}
