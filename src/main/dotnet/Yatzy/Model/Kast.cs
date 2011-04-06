using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Yatzy.Model
{
    public class Kast
    {
        private Random _randomGenerator = new Random();
        public Terning[] Terninger { get; set; }

        public Kast()
        {
            Terninger = new Terning[5];
            TrillTerninger();
        }

        public Kast(params int[] øyne)
        {
            Terninger = new Terning[øyne.Length];
            for (int i = 0; i < øyne.Length; i++)
                Terninger[i] = new Terning(øyne[i]);
        }

        /// <summary>
        /// Lag et nytt kast basert på et tidligere kast.
        /// </summary>
        /// <param name="kast"></param>
        public Kast(Kast kast)
        {
            Terninger = kast.Terninger;
            TrillTerninger();
        }

        private void TrillTerninger()
        {
            for (int i = 0; i < Terninger.Length; i++)
            {
                if (Terninger[i] == null)
                    Terninger[i] = TrillTerning();
            }
        }

        private Terning TrillTerning()
        {
            return new Terning(_randomGenerator.Next(1, 7));
        }
    }
}