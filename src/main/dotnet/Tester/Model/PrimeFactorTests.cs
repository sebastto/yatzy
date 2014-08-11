using System.Collections.Generic;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Should;
using Yatzy.Framework;

namespace Yatzy.UnitTests.Model
{
	[TestClass]
	public class PrimeFactorTests
	{
		private PrimeFactor _instance;

		[TestInitialize]
		public void Before_Each()
		{
			_instance = new PrimeFactor();
		}

		[TestMethod]
		public void Faktoriser_Verdien1_GirBlankListe()
		{
			// Act
			var result = _instance.Generate(1);

			// Assert			
			result.ShouldBeEmpty();
		}

		[TestMethod]
		public void Generate_ValueIs2_ResultIs_2()
		{
			// Arrange
			var expected = new List<int> { 2 };

			// Act
			var result = _instance.Generate(2);

			// Assert
			result.ShouldEqual(expected);
		}

		[TestMethod]
		public void Generate_ValueIs3_ResultIs_3()
		{
			// Arrange
			var expected = new List<int> {3};

			// Act
			var result = _instance.Generate(3);

			// Assert
			result.ShouldEqual(expected);
		}

		[TestMethod]
		public void Generate_ValueIs4_ResultIs_2_2()
		{
			// Arrange
			var expected = new List<int> { 2, 2 };

			// Act
			var result = _instance.Generate(4);

			// Assert
			result.ShouldEqual(expected);
		}

		[TestMethod]
		public void Generate_ValueIs6_ResultIs_2_3()
		{
			// Arrange
			var expected = new List<int> {2, 3};

			// Act
			var result = _instance.Generate(6);

			// Assert
			result.ShouldEqual(expected);
		}

		[TestMethod]
		public void Generate_ValueIs8_ResultIs_2_2_2()
		{
			// Arrange
			var expected = new List<int> { 2, 2, 2 };

			// Act
			var result = _instance.Generate(8);

			// Assert
			result.ShouldEqual(expected);
		}

		[TestMethod]
		public void Generate_ValueIs9_ResultIs_3_3()
		{
			// Arrange
			var expected = new List<int> { 3, 3 };

			// Act
			var result = _instance.Generate(9);

			// Assert
			result.ShouldEqual(expected);
		}
	}
}
