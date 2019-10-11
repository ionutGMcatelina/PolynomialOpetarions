import Parse.ParseString;
import org.junit.Test;
import static org.junit.Assert.*;

import Polynomial.*;

public class TestJunit {

    @Test
    public void testAdd(){
        Polynomial polynomial1 = ParseString.parse("x^2+3x+2");
        Polynomial polynomial2 = ParseString.parse("4x+5");
        assertEquals("x^2+7x+7", "" + PolynomialOperations.addPolynomials(polynomial1, polynomial2));

        Polynomial polynomial3 = ParseString.parse("x^3+2");
        Polynomial polynomial4 = ParseString.parse("4x^3+5x^2+1");
        assertEquals("5x^3+5x^2+3", "" + PolynomialOperations.addPolynomials(polynomial3, polynomial4));

        Polynomial polynomial5 = ParseString.parse("-x^2+3x+2x+2");
        Polynomial polynomial6 = ParseString.parse("x^2+5x-5");
        assertEquals("10x-3" ,"" + PolynomialOperations.addPolynomials(polynomial5, polynomial6));

        Polynomial polynomial7 = ParseString.parse("x^2-2x+1");
        Polynomial polynomial8 = ParseString.parse("-x^2+2x-1");
        assertEquals("0", "" + PolynomialOperations.addPolynomials(polynomial7, polynomial8));
    }

    @Test
    public void testSub(){
        Polynomial polynomial1 = ParseString.parse("x^2+3x+2");
        Polynomial polynomial2 = ParseString.parse("4x+5");
        assertEquals("x^2-x-3", "" + PolynomialOperations.subPolynomials(polynomial1, polynomial2));

        Polynomial polynomial3 = ParseString.parse("x^3+6x+2");
        Polynomial polynomial4 = ParseString.parse("4x^2+5x+1");
        assertEquals("x^3-4x^2+x+1", "" + PolynomialOperations.subPolynomials(polynomial3, polynomial4));

        Polynomial polynomial5 = ParseString.parse("x^2+3x+2x+2");
        Polynomial polynomial6 = ParseString.parse("x^2+5x-5");
        assertEquals("7", "" + PolynomialOperations.subPolynomials(polynomial5, polynomial6));

        Polynomial polynomial7 = ParseString.parse("x^2-2x+1");
        Polynomial polynomial8 = ParseString.parse("x^2-2x+1");
        assertEquals("0", "" + PolynomialOperations.subPolynomials(polynomial7, polynomial8));
    }

    @Test
    public void testMull(){
        Polynomial polynomial1 = ParseString.parse("x+2");
        Polynomial polynomial2 = ParseString.parse("x+2");
        assertEquals("x^2+4x+4", "" + PolynomialOperations.mullPolynomials(polynomial1, polynomial2));

        Polynomial polynomial3 = ParseString.parse("x^2+3x+5");
        Polynomial polynomial4 = ParseString.parse("2x-3");
        assertEquals("2x^3+3x^2+x-15", "" + PolynomialOperations.mullPolynomials(polynomial3, polynomial4));

        Polynomial polynomial5 = ParseString.parse("x^4+3x+5");
        Polynomial polynomial6 = ParseString.parse("x^2+1");
        assertEquals("x^6+x^4+3x^3+5x^2+3x+5", "" + PolynomialOperations.mullPolynomials(polynomial5, polynomial6));

        Polynomial polynomial7 = ParseString.parse("-x^2-2x+5");
        Polynomial polynomial8 = ParseString.parse("x^3-4");
        assertEquals("-x^5-2x^4+5x^3+4x^2+8x-20", "" + PolynomialOperations.mullPolynomials(polynomial7, polynomial8));
    }

    @Test
    public void testMullMonomial(){
        Polynomial polynomial1 = ParseString.parse("x+2");
        Monomial monomial1 = new Monomial(1, 1);
        assertEquals("x^2+2x", "" + PolynomialOperations.mullPolynomials(polynomial1, monomial1));

        Polynomial polynomial2 = ParseString.parse("x^2-3x+5");
        Monomial monomial2 = new Monomial(3, 2);
        assertEquals("3x^4-9x^3+15x^2", "" + PolynomialOperations.mullPolynomials(polynomial2, monomial2));

        Polynomial polynomial3 = ParseString.parse("x^4+3x+5");
        Monomial monomial3 = new Monomial(1, 2);
        assertEquals("x^6+3x^3+5x^2", "" + PolynomialOperations.mullPolynomials(polynomial3, monomial3));

        Polynomial polynomial4 = ParseString.parse("-x^2-2x+5");
        Monomial monomial4 = new Monomial(-4, 0);
        assertEquals("4x^2+8x-20", "" + PolynomialOperations.mullPolynomials(polynomial4, monomial4));
    }

    @Test
    public void testDerivation(){
        Polynomial polynomial1 = ParseString.parse("x+2");
        PolynomialOperations.derivation(polynomial1);
        assertEquals("1", "" + polynomial1);

        Polynomial polynomial2 = ParseString.parse("x^5-3x^4+2x^2+3");
        PolynomialOperations.derivation(polynomial2);
        assertEquals("5x^4-12x^3+4x", "" + polynomial2);

        Polynomial polynomial3 = ParseString.parse("x^2-x+5");
        PolynomialOperations.derivation(polynomial3);
        assertEquals("2x-1", "" + polynomial3);

        Polynomial polynomial4 = ParseString.parse("10");
        PolynomialOperations.derivation(polynomial4);
        assertEquals("0", "" + polynomial4);
    }

    @Test
    public void testIntegration(){
        Polynomial polynomial1 = ParseString.parse("x+2");
        PolynomialOperations.integration(polynomial1);
        assertEquals("0.5x^2+2x", "" + polynomial1);

        Polynomial polynomial2 = ParseString.parse("4x^3+x^2-3x+1");
        PolynomialOperations.integration(polynomial2);
        assertEquals("x^4+0.33x^3-1.5x^2+x", "" + polynomial2);

        Polynomial polynomial3 = ParseString.parse("x^4-3x+5");
        PolynomialOperations.integration(polynomial3);
        assertEquals("0.2x^5-1.5x^2+5x", "" + polynomial3);

        Polynomial polynomial4 = ParseString.parse("-20x^4");
        PolynomialOperations.integration(polynomial4);
        assertEquals("-4x^5", "" + polynomial4);
    }

    @Test
    public void testDiv(){
        Polynomial polynomial1 = ParseString.parse("x^2+2");
        Polynomial polynomial2 = ParseString.parse("x^2+2");
        assertEquals("CAT: 1    REST: 0", "" + PolynomialOperations.divPolynomials(polynomial1, polynomial2));

        Polynomial polynomial3 = ParseString.parse("x^2+6x+12");
        Polynomial polynomial4 = ParseString.parse("x+3");
        assertEquals("CAT: x+3    REST: 3", "" + PolynomialOperations.divPolynomials(polynomial3, polynomial4));

        Polynomial polynomial5 = ParseString.parse("x^3-6x^2+5x-3");
        Polynomial polynomial6 = ParseString.parse("x-2");
        assertEquals("CAT: x^2-4x-3    REST: -9", "" + PolynomialOperations.divPolynomials(polynomial5, polynomial6));

        Polynomial polynomial7 = ParseString.parse("x^4-7x^3+2x^2-3x+11");
        Polynomial polynomial8 = ParseString.parse("3x^2+4x+7");
        assertEquals("CAT: 0.33x^2-2.78x+3.59    REST: 2.07x-14.15", "" + PolynomialOperations.divPolynomials(polynomial7, polynomial8));
    }

    @Test
    public void testCheckMonomial1(){
        Monomial monomial1 = new Monomial(3, 5);
        Monomial monomial2 = ParseString.check("3x^5");
        assertEquals(monomial1,monomial2);

        Monomial monomial3 = new Monomial(-18, 0);
        Monomial monomial4 = ParseString.check("-3*6");
        assertEquals(monomial3,monomial4);

        Monomial monomial5 = new Monomial(5, 2);
        Monomial monomial6 = ParseString.check("20/4x^2");
        assertEquals(monomial5,monomial6);
    }

    @Test
    public void testCheckMonomial2(){
        assertNull(ParseString.check("3ax^2"));
        assertNull(ParseString.check("3x^^2"));
        assertNull(ParseString.check("1x^"));
        assertNull(ParseString.check("abcd"));
        assertNull(ParseString.check("xx^2"));
    }

    @Test
    public void testParsePolynomial(){
        Polynomial polynomial1 = new Polynomial();
        polynomial1.addMonomial(new Monomial(2, 3));
        polynomial1.addMonomial(new Monomial(-1, 2));
        polynomial1.addMonomial(new Monomial(5, 1));
        polynomial1.addMonomial(new Monomial(-7, 0));
        Polynomial polynomial2 = ParseString.parse("2x^3-2x^2+5x-7");
        for (Monomial m : polynomial1.getMonomials()){
            assertTrue(polynomial2.getMonomials().contains(m));
            assertEquals(polynomial1.getMonomials().size(), polynomial2.getMonomials().size());
        }

        Polynomial polynomial3 = new Polynomial();
        polynomial1.addMonomial(new Monomial(-1, 2));
        polynomial1.addMonomial(new Monomial(2, 1));
        polynomial1.addMonomial(new Monomial(8, 0));
        Polynomial polynomial4 = ParseString.parse("-x^2+5x-2x+8");
        for (Monomial m : polynomial3.getMonomials()){
            assertTrue(polynomial4.getMonomials().contains(m));
            assertEquals(polynomial3.getMonomials().size(), polynomial4.getMonomials().size());
        }
    }
}
