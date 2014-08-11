using System.Collections.Generic;

namespace Yatzy.Framework
{
	public class PrimeFactor
	{
		public List<int> Generate(int number)
		{
			var primes		= new List<int>();

			for (int candidate = 2; number > 1; candidate++)
				for (; number % candidate == 0; number /= candidate)
					primes.Add(candidate);

			return primes;
		}
	}
}