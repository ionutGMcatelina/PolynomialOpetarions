package Polynomial;

public class PolynomialOperations {
    public static Polynomial addPolynomials(Polynomial polynomial1, Polynomial polynomial2){ // Metoda care aduna 2 polinoame
        Polynomial newPolynomial = new Polynomial();
        newPolynomial.addMonomials(polynomial1.getMonomials());
        for (Monomial monomial1 : polynomial2.getMonomials()){
           newPolynomial.addMonomial(monomial1);
        }
        return newPolynomial;
    }

    public static Polynomial subPolynomials(Polynomial polynomial1, Polynomial polynomial2){
        Polynomial newPolynomial = new Polynomial();
        newPolynomial.addMonomials(polynomial1.getMonomials());
        for (Monomial monomial1 : polynomial2.getMonomials()){
            monomial1.setCoefficient(-monomial1.getCoefficient());
            newPolynomial.addMonomial(monomial1);
        }
        return newPolynomial;
    }

    public static Polynomial mullPolynomials(Polynomial polynomial1, Polynomial polynomial2){
        Polynomial newPolynomial = new Polynomial();
        for (Monomial monomial1 : polynomial1.getMonomials()){
            for (Monomial monomial2 : polynomial2.getMonomials()){
                Monomial newMonomial = monomial1.mull(monomial2);
                newPolynomial.addMonomial(newMonomial);
            }
        }
        return newPolynomial;
    }

    public static Polynomial mullPolynomials(Polynomial polynomial, Monomial monomial){
        Polynomial newPolynomial = new Polynomial();
        for (Monomial monomial1 : polynomial.getMonomials()){
            Monomial newMonomial = monomial1.mull(monomial);
            newPolynomial.addMonomial(newMonomial);
        }
        return newPolynomial;
    }

    public static void derivation(Polynomial polynomial){
        for (Monomial monomial : polynomial.getMonomials()){
            monomial.derivation();
            if (monomial.getCoefficient() == 0){
                polynomial.getMonomials().remove(monomial);
            }
        }
    }

    public static void integration(Polynomial polynomial){
        for (Monomial monomial : polynomial.getMonomials()){
            monomial.integration();
        }
    }

    public static String divPolynomials(Polynomial polynomial1, Polynomial polynomial2){
        if (polynomial1.getMonomials().size() == 0){
            if (polynomial2.getMonomials().size() == 0){
                return "CANNOT DO THE OPERATION";
            }
            return "RESULT: " + "0" + "    REST: " + polynomial2;
        }

        if (polynomial2.getMonomials().size() == 0){
            return "RESULT: " + "inf" + "    REST: 0";
        }

        if (polynomial1.getMonomials().first().getPow() < polynomial2.getMonomials().first().getPow()){
            Polynomial aux = polynomial1;
            polynomial1 = polynomial2;
            polynomial2 = aux;
        }

        Polynomial result = new Polynomial();

        while (polynomial1.getMonomials().size() != 0 && polynomial1.getMonomials().first().getPow() >= polynomial2.getMonomials().first().getPow()){
            double coefficient = polynomial1.getMonomials().first().getCoefficient() / polynomial2.getMonomials().first().getCoefficient();
            int pow = polynomial1.getMonomials().first().getPow() - polynomial2.getMonomials().first().getPow();
            Monomial m = new Monomial(coefficient, pow);
            result.addMonomial(m);
            polynomial1 = subPolynomials(polynomial1, mullPolynomials(polynomial2, m));
        }
        return "RESULT: " + result + "    REST: " + polynomial1;
    }
}
