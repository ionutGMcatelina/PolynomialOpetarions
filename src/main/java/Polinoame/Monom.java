package Polynomial;

import java.text.DecimalFormat;

public class Monomial implements Comparable {
    private int pow;
    private double coefficient;

    public Monomial(double coefficient, int pow) {
        this.pow = pow;
        this.coefficient = coefficient;
    }

    void derivation(){
        coefficient *= pow;
        pow--;
    }

    void integration(){
        pow++;
        coefficient /= pow;
    }

    void add(double coefficient){
        this.coefficient += coefficient;
    }

    Monomial mull(Monomial monomial){
        return new Monomial(this.coefficient * monomial.coefficient, this.pow + monomial.pow);
    }

    int getPow() {
        return pow;
    }

    double getCoefficient() {
        return coefficient;
    }

    void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public int compareTo(Object o) {
        return ((Monomial)o).pow - pow;
    }

    @Override
    public boolean equals(Object obj) {
        return coefficient == ((Monomial)obj).coefficient && pow == ((Monomial)obj).pow;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#0.00");
        String coeff;

        if (coefficient == (double)Math.round(coefficient)){
            coeff = "" + Math.round(coefficient);
        } else{
            coeff = df.format(coefficient);
            if (coeff.charAt(coeff.length() - 1) == '0'){
                coeff = coeff.substring(0, coeff.length() - 1);
            }
        }

        switch (pow) {
            case 0:
                if (coefficient < 0)
                    return coeff + "";
                else
                    return "+" + coeff + "";
            case 1:
                if (coefficient == 1) {
                    return "+x";
                } else if (coefficient == -1) {
                    return "-x";
                } else if (coefficient < 0) {
                    return coeff + "x";
                } else {
                    return "+" + coeff + "x";
                }
            default:
                if (coefficient == 1) {
                return "+x^" + pow;
            } else if (coefficient == -1) {
                return "-x^" + pow;
            } else if (coefficient < 0) {
                return coeff + "x^" + pow;
            } else {
                return "+" + coeff + "x^" + pow;
            }
        }
    }
}
