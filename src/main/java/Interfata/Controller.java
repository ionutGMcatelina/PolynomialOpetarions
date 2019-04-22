package Interfata;

import Polinoame.OperatiiPolinoame;
import Polinoame.Polinom;
import Parsare.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private View view;
    private Polinom polinom1;
    private Polinom polinom2;

    /*
    * La apasarea unui buton se parseaza string-ul introdus apoi se face operatia
    * Daca un string este invalid, se va afisa un mesaj de eroare*/

    public Controller(View view){
        this.view = view;

        view.addAddButtonListener(new AddButtonListener());
        view.addSubButtonListener(new SubButtonListener());
        view.addMullButtonListener(new MullButtonListener());
        view.addDivButtonListener(new DivButtonListener());
        view.addDerivButtonListener(new DerivButtonListener());
        view.addIntegButtonListener(new IntegButtonListener());
    }

    class AddButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            polinom1 = ParsareString.parsare(view.getInPolinom1().getText());
            polinom2 = ParsareString.parsare(view.getInPolinom2().getText());
            if (polinom1 != null && polinom2 != null) {
                view.setResult("" + OperatiiPolinoame.addPolinoame(polinom1, polinom2));
            } else {
                if (polinom1 == null)
                    view.showJOptionPane("Polinomul " + view.getInPolinom1().getText() + " este invalid!");
                else
                    view.showJOptionPane("Polinomul " + view.getInPolinom2().getText() + " este invalid!");
            }
        }
    }

    class SubButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            polinom1 = ParsareString.parsare(view.getInPolinom1().getText());
            polinom2 = ParsareString.parsare(view.getInPolinom2().getText());
            if (polinom1 != null && polinom2 != null) {
                view.setResult("" + OperatiiPolinoame.subPolinoame(polinom1, polinom2));
            } else {
                if (polinom1 == null)
                    view.showJOptionPane("Polinomul " + view.getInPolinom1().getText() + " este invalid!");
                else
                    view.showJOptionPane("Polinomul " + view.getInPolinom2().getText() + " este invalid!");
            }
        }
    }

    class MullButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            polinom1 = ParsareString.parsare(view.getInPolinom1().getText());
            polinom2 = ParsareString.parsare(view.getInPolinom2().getText());
            if (polinom1 != null && polinom2 != null) {
                view.setResult("" + OperatiiPolinoame.mullPolinoame(polinom1, polinom2));
            } else {
                if (polinom1 == null)
                    view.showJOptionPane("Polinomul " + view.getInPolinom1().getText() + " este invalid!");
                else
                    view.showJOptionPane("Polinomul " + view.getInPolinom2().getText() + " este invalid!");
            }
        }
    }

    class DivButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            polinom1 = ParsareString.parsare(view.getInPolinom1().getText());
            polinom2 = ParsareString.parsare(view.getInPolinom2().getText());
            if (polinom1 != null && polinom2 != null) {
                view.setResult("" + OperatiiPolinoame.divPolinoame(polinom1, polinom2));
            } else {
                if (polinom1 == null)
                    view.showJOptionPane("Polinomul " + view.getInPolinom1().getText() + " este invalid!");
                else
                    view.showJOptionPane("Polinomul " + view.getInPolinom2().getText() + " este invalid!");
            }
        }
    }

    class DerivButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            polinom1 = ParsareString.parsare(view.getInPolinom1().getText());
            if (polinom1 != null) {
                OperatiiPolinoame.derivare(polinom1);
                view.setResult("" + polinom1);
            } else {
                view.showJOptionPane("Polinomul " + view.getInPolinom2().getText() + " este invalid!");
            }
        }
    }

    class IntegButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            polinom1 = ParsareString.parsare(view.getInPolinom1().getText());
            if (polinom1 != null) {
                OperatiiPolinoame.integrare(polinom1);
                view.setResult("" + polinom1);
            } else {
                view.showJOptionPane("Polinomul " + view.getInPolinom1().getText() + " este invalid!");
            }
        }
    }
}
