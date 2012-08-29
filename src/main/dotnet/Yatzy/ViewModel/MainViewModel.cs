using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Windows.Input;
using Yatzy.Framework;
using Yatzy.Model;

namespace Yatzy.ViewModel
{
    public class MainViewModel : INotifyPropertyChanged
    {
        private readonly YatzyBeregnerFactory _beregnerFactory = new YatzyBeregnerFactory();
        private int _antallKast = 0;

        public ICommand KastCommand { get; private set; }
        public ICommand NyRundeCommand { get; private set; }
        public ICommand BeregnPoengCommand { get; private set; }

        public event PropertyChangedEventHandler PropertyChanged;

        public MainViewModel()
        {
            CreateCommands();
        }

        private Kast _aktivtKast;

		public Kast AktivtKast
        {
            get { return _aktivtKast; }
            private set
            {
                _aktivtKast = value;
                NotifyPropertyChanged("AktivtKast");
                NotifyPropertyChanged("TerningVerdier");
            }
        }

        public string[] TerningVerdier
        {
            get
            {
                if (AktivtKast == null)
                    return new string[] { "0", "0", "0", "0", "0" };
                else
                {
                    string[] terninger = new string[5];
                    for (int i = 0; i < AktivtKast.Terninger.Length; i++)
                        terninger[i] = AktivtKast.Terninger[i].AntallØyne.ToString();

                    return terninger;
                }
            }
        }

        private int _poengsum = 0;

        public int Poengsum
        {
            get { return _poengsum; }
            set
            {
                if (_poengsum == value)
                    return;

                _poengsum = value;
                NotifyPropertyChanged("Poengsum");
            }
        }

        private YatzyKombinasjon _valgtKombinasjon = YatzyKombinasjon.Ukjent;
       
		public YatzyKombinasjon ValgtKombinasjon
        {
            get { return _valgtKombinasjon; }
            set
            {
                if (_valgtKombinasjon == value)
                    return;

                _valgtKombinasjon = value;
                NotifyPropertyChanged("ValgtKombinasjon");
            }
        }

        public IEnumerable<string> YatzyKombinasjoner
        {
            get { return Enum.GetNames(typeof(YatzyKombinasjon)).Where(o=>o !="Ukjent") ?? new string[] { "Ingen kombinasjoner funnet" }; }
        }

        public string KastLabel
        {
            get
            {
                if (_antallKast == 0)
                    return "Diz iz how I roll";

                return string.Format("{0}. kast", _antallKast);
            }
        }

        private bool[] _holdTerninger = new bool[5];

		public bool[] HoldTerninger
        {
            get { return _holdTerninger; }
            set
            {
                _holdTerninger = value;
                NotifyPropertyChanged("HoldTerninger");
            }
        }

        private void CreateCommands()
        {
            KastCommand			= new SimpleCommand(KastTerninger, o => _antallKast < 3);
            NyRundeCommand		= new SimpleCommand(NyRunde, o => true);
            BeregnPoengCommand	= new SimpleCommand(BeregnPoengsum, o => _antallKast == 3 && _valgtKombinasjon != YatzyKombinasjon.Ukjent);
        }

        private void KastTerninger()
        {
            _antallKast++;

            if (AktivtKast == null)
                AktivtKast = new Kast();
            else
            {
                for (int i = 0; i < AktivtKast.Terninger.Length; i++)
                {
                    if (!HoldTerninger[i])
                        AktivtKast.Terninger[i] = null;
                }
                AktivtKast = new Kast(AktivtKast);
            }

            NotifyPropertyChanged("KastLabel");
        }

        private void NyRunde()
        {
            _antallKast = 0;
            AktivtKast = null;
            ValgtKombinasjon = YatzyKombinasjon.Ukjent;
            Poengsum = 0;
            HoldTerninger = new bool[5];

            NotifyPropertyChanged("KastLabel");
        }

        private void BeregnPoengsum()
        {
            if (_valgtKombinasjon == YatzyKombinasjon.Ukjent || AktivtKast == null)
                throw new InvalidOperationException("Kan ikke beregne poengsum uten et gyldig kast yatzykombinasjon");

            Poengsum = _beregnerFactory
						.HentKombinasjonsBeregner(ValgtKombinasjon)
						.BeregnPoeng(AktivtKast);
        }

        private void NotifyPropertyChanged(string propertyName)
        {
            if (PropertyChanged != null)
                PropertyChanged(this, new PropertyChangedEventArgs(propertyName));
        }
    }
}
