using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Yatzy.Model
{
    [System.ComponentModel.DefaultValue(null)]
    public enum YatzyKombinasjon
    {
        NotSet,
        Enere,
        Toere,
        Treere,
        Firere,
        Femmere,
        Seksere,
        EttPar,
        ToPar,
        TreLike,
        FireLike,
        LitenStraight,
        StorStraight,
        Hus,
        Sjanse,
        Yatzy
    }
}
