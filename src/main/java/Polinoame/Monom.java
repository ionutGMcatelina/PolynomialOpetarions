package Polinoame;

import java.text.DecimalFormat;

public class Monom implements Comparable {
    private int putere;
    private double coeficient;

    public Monom(double coeficient, int putere) {
        this.putere = putere;
        this.coeficient = coeficient;
    }

    void derivare(){                    // Derivate a unui monom
        coeficient *= putere;
        putere--;
    }

    void integrare(){                   // Integrare a unui monom
        putere++;
        coeficient /= putere;
    }

    void add(double coeficient){        // Adunare a unui coeficient la monom
        this.coeficient += coeficient;
    }

    Monom mull(Monom monom){                                             // Inmultire a 2 monoame
        return new Monom(this.coeficient * monom.coeficient, this.putere + monom.putere);
    }

    int getPutere() {
        return putere;
    }

    double getCoeficient() {
        return coeficient;
    }

    void setCoeficient(double coeficient) {
        this.coeficient = coeficient;
    }

    public int compareTo(Object o) {                                    // Metoda compareTo pentru folosirea treeSet-ului
        return ((Monom)o).putere - putere;
    }

    @Override
    public boolean equals(Object obj) {                                 // Metoda equals folosita pentru testare
        return coeficient == ((Monom)obj).coeficient && putere == ((Monom)obj).putere;
    }

    @Override
    public String toString() {                                          // Returnez monomul ca string
        DecimalFormat df = new DecimalFormat("#0.00");  // Afisez coeficientul cu 2 zecimale
        String coef;                                            // In coef retun coeficientul ca string

        if (coeficient == (double)Math.round(coeficient)){      // Daca numarul este intreg, afisez fara zecimale
            coef = "" + Math.round(coeficient);
        } else{
            coef = df.format(coeficient);
            if (coef.charAt(coef.length() - 1) == '0'){         // Daca daor prima zecimala este diferita de 0, afisez doar una
                coef = coef.substring(0, coef.length() - 1);
            }
        }

        switch (putere) {
            case 0:                                 // Daca puterea este 0, afisez dar coeficientul
                if (coeficient < 0)
                    return coef + "";
                else
                    return "+" + coef + "";         // Daca este pozitiv, pun + in fata lui
            case 1:                                 // Daca puterea este 1 afisez doar coeficientul si x (si semnul coeficientului)
                if (coeficient == 1) {
                    return "+x";
                } else if (coeficient == -1) {
                    return "-x";
                } else if (coeficient < 0) {
                    return coef + "x";
                } else {
                    return "+" + coef + "x";
                }
            default:                                // Altfel afisez monomul normal, in functie de coeficient si de semnul lui
                if (coeficient == 1) {
                return "+x^" + putere;
            } else if (coeficient == -1) {
                return "-x^" + putere;
            } else if (coeficient < 0) {
                return coef + "x^" + putere;
            } else {
                return "+" + coef + "x^" + putere;
            }
        }
    }
}
