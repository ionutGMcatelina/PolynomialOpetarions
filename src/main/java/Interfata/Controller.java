package Interfata;

import Polynomial.PolynomialOperations;
import Polynomial.Polynomial;
import Parse.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private View view;
    private Polynomial polynomial1;
    private Polynomial polynomial2;

    public Controller(View view){
        this.view = view;

        view.addAddButtonListener(new AddButtonListener());
        view.addSubButtonListener(new SubButtonListener());
        view.addMullButtonListener(new MullButtonListener());
        view.addDivButtonListener(new DivButtonListener());
        view.addDerivationButtonListener(new DerivButtonListener());
        view.addIntegrationButtonListener(new IntegButtonListener());
    }

    class AddButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            polynomial1 = ParseString.parse(view.getInPolynomial1().getText());
            polynomial2 = ParseString.parse(view.getInPolynomial2().getText());
            if (polynomial1 != null && polynomial2 != null) {
                view.setResult("" + PolynomialOperations.addPolynomials(polynomial1, polynomial2));
            } else {
                if (polynomial1 == null)
                    view.showJOptionPane("The polynomial " + view.getInPolynomial1().getText() + " is incorrect!");
                else
                    view.showJOptionPane("The polynomial " + view.getInPolynomial2().getText() + " is incorrect!");
            }
        }
    }

    class SubButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            polynomial1 = ParseString.parse(view.getInPolynomial1().getText());
            polynomial2 = ParseString.parse(view.getInPolynomial2().getText());
            if (polynomial1 != null && polynomial2 != null) {
                view.setResult("" + PolynomialOperations.subPolynomials(polynomial1, polynomial2));
            } else {
                if (polynomial1 == null)
                    view.showJOptionPane("The polynomial " + view.getInPolynomial1().getText() + " is incorrect!");
                else
                    view.showJOptionPane("The polynomial " + view.getInPolynomial2().getText() + " is incorrect!");
            }
        }
    }

    class MullButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            polynomial1 = ParseString.parse(view.getInPolynomial1().getText());
            polynomial2 = ParseString.parse(view.getInPolynomial2().getText());
            if (polynomial1 != null && polynomial2 != null) {
                view.setResult("" + PolynomialOperations.mullPolynomials(polynomial1, polynomial2));
            } else {
                if (polynomial1 == null)
                    view.showJOptionPane("The polynomial " + view.getInPolynomial1().getText() + " is incorrect!");
                else
                    view.showJOptionPane("The polynomial " + view.getInPolynomial2().getText() + " is incorrect!");
            }
        }
    }

    class DivButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            polynomial1 = ParseString.parse(view.getInPolynomial1().getText());
            polynomial2 = ParseString.parse(view.getInPolynomial2().getText());
            if (polynomial1 != null && polynomial2 != null) {
                view.setResult("" + PolynomialOperations.divPolynomials(polynomial1, polynomial2));
            } else {
                if (polynomial1 == null)
                    view.showJOptionPane("The polynomial " + view.getInPolynomial1().getText() + " is incorrect!");
                else
                    view.showJOptionPane("The polynomial " + view.getInPolynomial2().getText() + " is incorrect!");
            }
        }
    }

    class DerivButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            polynomial1 = ParseString.parse(view.getInPolynomial1().getText());
            if (polynomial1 != null) {
                PolynomialOperations.derivation(polynomial1);
                view.setResult("" + polynomial1);
            } else {
                view.showJOptionPane("The polynomial " + view.getInPolynomial2().getText() + " is incorrect!");
            }
        }
    }

    class IntegButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            polynomial1 = ParseString.parse(view.getInPolynomial1().getText());
            if (polynomial1 != null) {
                PolynomialOperations.integration(polynomial1);
                view.setResult("" + polynomial1);
            } else {
                view.showJOptionPane("The polynomial " + view.getInPolynomial1().getText() + " is incorrect!");
            }
        }
    }
}
