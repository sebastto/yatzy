using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Yatzy.Model
{
    public class Terning
    {
        public int AntallØyne { get; private set; }

        public Terning(int antallØyne)
        {
            AntallØyne = antallØyne;
        }
    }
}
