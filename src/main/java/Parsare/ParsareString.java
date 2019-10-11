package Parse;

import Polynomial.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseString {
    public static Polynomial parse(String polinom){                  // It returns a polynomial made from a string, or null if it cannot do that
        polinom = polinom.replaceAll(" ", "");     // The polynomial is formed by parsing the string into monomial
        Pattern pattern = Pattern.compile("([+-]?[^-+]+)");
        Matcher matcher = pattern.matcher(polinom);
        Polynomial newPolynomial = new Polynomial();

        while (matcher.find()){
            Monomial monomial = check(matcher.group());              // If each monomial (string) is correct, it creates a
                                                                     // Monomial object and put it into a list
            if (monomial == null){                                   // otherwise, the method returns null
                return null;
            }
            newPolynomial.addMonomial(monomial);
        }
        return newPolynomial;
    }

    public static Monomial check(String monomial){                   // It checks if a string is a monomial
        double newCoefficient = 0;
        int newPow = 0;
        int nr = 0;
        char op = ' ';
        int i = 0;
        if (monomial.charAt(0) == '+' || monomial.charAt(0) == '-') {
            i++;
        }
        if (monomial.charAt(i) == 'x'){
            newCoefficient = 1;
        }
        else {
            while (i < monomial.length() && monomial.charAt(i) != 'x') {
                if (monomial.charAt(i) < 48 || monomial.charAt(i) > 57) {
                    if (op == ' ' && (monomial.charAt(i) == '*' || monomial.charAt(i) == '/' || monomial.charAt(i) == '^')) {
                        newCoefficient = nr;
                        nr = 0;
                        op = monomial.charAt(i);

                    } else
                        return null;
                } else
                    nr = nr * 10 + (monomial.charAt(i) - 48);
                i++;
            }

            switch (op) {
                case ' ':
                    newCoefficient = nr;
                    break;
                case '*':
                    newCoefficient = newCoefficient * nr;
                    break;
                case '/':
                    newCoefficient = newCoefficient / nr;
                    break;
                case '^':
                    newCoefficient = Math.pow(newCoefficient, nr);
                    break;
            }
        }

        if (monomial.charAt(0) == '-') {
            newCoefficient = -newCoefficient;
        }
        if (monomial.contains("x")) {
            i++;
            if (i + 1 < monomial.length()) {
                if (monomial.charAt(i) != '^') {
                    return null;
                } else {
                    i++;
                    while (i < monomial.length()) {
                        if (monomial.charAt(i) < 48 || monomial.charAt(i) > 57) {
                            return null;
                        }
                        newPow = newPow * 10 + (monomial.charAt(i) - 48);
                        i++;
                    }
                }
            } else {
                if (i < monomial.length()) {
                    return null;
                } else {
                    newPow = 1;
                }
            }
        }
        return new Monomial(newCoefficient, newPow);
    }
}
