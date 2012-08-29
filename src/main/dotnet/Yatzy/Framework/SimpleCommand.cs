using System;
using System.Windows.Input;

namespace Yatzy.Framework
{
    public class SimpleCommand : ICommand
    {
        Action _commandToExecute;
        Predicate<object> _canExecute;
        public event EventHandler CanExecuteChanged
        {
            add { CommandManager.RequerySuggested += value; }
            remove { CommandManager.RequerySuggested -= value; }
        }

        public SimpleCommand(Action commandToExecute, Predicate<object> canExecute)
        {
            _commandToExecute = commandToExecute;
            _canExecute = canExecute;
        }

        public bool CanExecute(object parameter)
        {
            if (_canExecute != null)
                return _canExecute(parameter);

            return true;
        }


        public void Execute(object parameter)
        {
            if (_commandToExecute != null)
                _commandToExecute();
        }
    }
}
