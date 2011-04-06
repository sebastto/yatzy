using System;
using System.Text;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Yatzy.Model;

namespace Tester.Model
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
