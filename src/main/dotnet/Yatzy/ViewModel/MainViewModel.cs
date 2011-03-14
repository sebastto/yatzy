using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel;
using Yatzy.Model;
using System.Windows.Input;
using Yatzy.Framework;
using System.Collections.ObjectModel;
using System.Drawing;
using System.Collections;
using System.Timers;

namespace Yatzy.ViewModel
{
    public class MainViewModel : INotifyPropertyChanged
    {
        private readonly IYatzyBeregner _beregner;
        private int _antallKast = 0;
        Random random = new Random();

        public ICommand KastCommand { get; private set; }
        public ICommand NyRundeCommand { get; private set; }
        public ICommand BeregnPoengCommand { get; private set; }

        public event PropertyChangedEventHandler PropertyChanged;

        public MainViewModel() : this(new DummyYatzyBeregner()) { }

        public MainViewModel(IYatzyBeregner beregner)
        {
            _beregner = beregner;

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

        private YatzyKombinasjon _valgtKombinasjon = YatzyKombinasjon.NotSet;
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
            get { return Enum.GetNames(typeof(YatzyKombinasjon)).Where(o=>o !="NotSet") ?? new string[] { "Ingen kombinasjoner funnet" }; }
        }

        public string KastLabel
        {
            get
            {
                if (_antallKast == 0)
                    return "Let's start!";

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
            KastCommand = new SimpleCommand(this.KastTerninger, o => _antallKast < 3);
            NyRundeCommand = new SimpleCommand(this.NyRunde, o => true);
            BeregnPoengCommand = new SimpleCommand(this.BeregnPoengsum, o => _antallKast == 3 && _valgtKombinasjon != YatzyKombinasjon.NotSet);
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
            ValgtKombinasjon = YatzyKombinasjon.NotSet;
            Poengsum = 0;
            HoldTerninger = new bool[5];

            NotifyPropertyChanged("KastLabel");
        }

        private void BeregnPoengsum()
        {
            if (_valgtKombinasjon == YatzyKombinasjon.NotSet || AktivtKast == null)
                throw new InvalidOperationException("Kan ikke beregne poengsum uten et gyldig kast yatzykombinasjon");

            Poengsum = _beregner.BeregnResultat(ValgtKombinasjon, AktivtKast);
        }

        private void NotifyPropertyChanged(string propertyName)
        {
            if (PropertyChanged != null)
                PropertyChanged(this, new PropertyChangedEventArgs(propertyName));
        }
    }
}
