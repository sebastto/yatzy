using System;
using System.Text;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Yatzy.Model;
using Yatzy.Model.Beregnere;
using Moq;

namespace Tester.Model
{
    [TestClass]
    public class YatzyBeregnerFactoryTests
    {
        private YatzyBeregnerFactory _factory = new YatzyBeregnerFactory();

        [TestMethod]
        public void LagBeregnerForKombinasjon_MedEnereKombinasjon_ReturnererEnereBeregner()
        {
            var enereBeregner = _factory.LagBeregnerForKombinasjon(YatzyKombinasjon.Enere);
            Assert.IsInstanceOfType(enereBeregner, typeof(EnereBeregner));
        }

        [TestMethod]
        public void BeregnerDelegererTilFaktiskBeregner()
        {
            var kastMock = new Mock<Kast>();
            var beregnerMock = new Mock<IYatzyBeregner>();

            beregnerMock.Setup(o => o.BeregnPoeng(kastMock.Object)).Returns(5);

            _factory.Beregner = beregnerMock.Object;
            var poeng = _factory.Beregner.BeregnPoeng(kastMock.Object);

            Assert.AreEqual(5, poeng);
            //verify(beregner).beregnPoengForKast(kast);
            beregnerMock.Verify(o => o.BeregnPoeng(kastMock.Object), Times.Once());
        }
    }
}
