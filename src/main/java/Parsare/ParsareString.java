package Parsare;

import Polinoame.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParsareString {
    public static Polinom parsare(String polinom){                  // Transforma un string intr-un polinom, daca nu poate va returna null
        polinom = polinom.replaceAll(" ", "");    // Sterg toate spatiile
        Pattern pattern = Pattern.compile("([+-]?[^-+]+)");         // Parsez stringul dupa + sau -
        Matcher matcher = pattern.matcher(polinom);
        Polinom newPolinom = new Polinom();

        while (matcher.find()){
            Monom monom = verificare(matcher.group());              // Pargurg fiecare subStrung rezultat si verific daca este un monom valid
            if (monom == null){                                     // Daca gasesc unul care nu este, returnez null
                return null;
            }
            newPolinom.addMonom(monom);                             // Adaug monoamele intr-un polinom pe care il returnez
        }
        return newPolinom;
    }

    public static Monom verificare(String monom){
        double newCoeficient = 0;
        int newPutere = 0;
        int nr = 0;
        char op = ' ';
        int i = 0;
        if (monom.charAt(0) == '+' || monom.charAt(0) == '-') {     // Transforma un string intr-un monom, daca nu poate va returna null
            i++;                                                    // Daca primul caracter ii + sau - sar peste el
        }
        if (monom.charAt(i) == 'x'){                                // Daca primul caracter ii x, coeficientul ii 1
            newCoeficient = 1;
        }
        else {
            while (i < monom.length() && monom.charAt(i) != 'x') {            // Parcurg caracterele pana la x sau pana la finalul sirului si formez un coeficient din cifre
                if (monom.charAt(i) < 48 || monom.charAt(i) > 57) {
                    if (op == ' ' && (monom.charAt(i) == '*' || monom.charAt(i) == '/' || monom.charAt(i) == '^')) {
                        newCoeficient = nr;
                        nr = 0;
                        op = monom.charAt(i);                       // Daca se gasesc unul din caracterele *(inmultire), /(impartire)
                                                                    // sau ^(ridicare la putere) retin numarul de pana acum in altceva si continui cu numarul de la 0
                    } else                                          // Daca caracterul nu este nici o operatie, nici o cifra returnez null
                        return null;
                } else
                    nr = nr * 10 + (monom.charAt(i) - 48);
                i++;
            }

            switch (op) {                                           // Calculez coeficientul dupa caz
                case ' ':
                    newCoeficient = nr;
                    break;
                case '*':
                    newCoeficient = newCoeficient * nr;
                    break;
                case '/':
                    newCoeficient = newCoeficient / nr;
                    break;
                case '^':
                    newCoeficient = Math.pow(newCoeficient, nr);
                    break;
            }
        }

        if (monom.charAt(0) == '-') {                               // Daca primul caracter este -, schimb semnul coeficientului
            newCoeficient = -newCoeficient;
        }
        if (monom.contains("x")) {
            i++;
            if (i + 1 < monom.length()) {                           // Verific daca sunt caractere dupa x
                if (monom.charAt(i) != '^') {                       // Daca primul caraccter dupa x nu ii ^, returnez null
                    return null;
                } else {
                    i++;
                    while (i < monom.length()) {                    // Parcurg caracterele si formez puterea
                        if (monom.charAt(i) < 48 || monom.charAt(i) > 57) {
                            return null;                            // Daca caracterul nu este nici o operatie, nici o cifra returnez null
                        }
                        newPutere = newPutere * 10 + (monom.charAt(i) - 48);
                        i++;
                    }
                }
            } else {
                if (i < monom.length()) {                           // Daca dupa ^ nu sunt cifre, returnez null
                    return null;
                } else {
                    newPutere = 1;                                  // Daca nu este nimic dupa x, puterea este 1
                }
            }
        }
        return new Monom(newCoeficient, newPutere);                 // Returnez un monom cu coeficientul si puterea calculate
    }
}
