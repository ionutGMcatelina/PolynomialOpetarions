import Parsare.ParsareString;
import org.junit.Test;
import static org.junit.Assert.*;

import Polinoame.*;

public class TestJunit {

    @Test
    public void testAdunare(){
        Polinom polinom1 = ParsareString.parsare("x^2+3x+2");
        Polinom polinom2 = ParsareString.parsare("4x+5");
        assertEquals("x^2+7x+7", "" + OperatiiPolinoame.addPolinoame(polinom1, polinom2));

        Polinom polinom3 = ParsareString.parsare("x^3+2");
        Polinom polinom4 = ParsareString.parsare("4x^3+5x^2+1");
        assertEquals("5x^3+5x^2+3", "" + OperatiiPolinoame.addPolinoame(polinom3, polinom4));

        Polinom polinom5 = ParsareString.parsare("-x^2+3x+2x+2");
        Polinom polinom6 = ParsareString.parsare("x^2+5x-5");
        assertEquals("10x-3" ,"" + OperatiiPolinoame.addPolinoame(polinom5, polinom6));

        Polinom polinom7 = ParsareString.parsare("x^2-2x+1");
        Polinom polinom8 = ParsareString.parsare("-x^2+2x-1");
        assertEquals("0", "" + OperatiiPolinoame.addPolinoame(polinom7, polinom8));
    }

    @Test
    public void testScadere(){
        Polinom polinom1 = ParsareString.parsare("x^2+3x+2");
        Polinom polinom2 = ParsareString.parsare("4x+5");
        assertEquals("x^2-x-3", "" + OperatiiPolinoame.subPolinoame(polinom1, polinom2));

        Polinom polinom3 = ParsareString.parsare("x^3+6x+2");
        Polinom polinom4 = ParsareString.parsare("4x^2+5x+1");
        assertEquals("x^3-4x^2+x+1", "" + OperatiiPolinoame.subPolinoame(polinom3, polinom4));

        Polinom polinom5 = ParsareString.parsare("x^2+3x+2x+2");
        Polinom polinom6 = ParsareString.parsare("x^2+5x-5");
        assertEquals("7", "" + OperatiiPolinoame.subPolinoame(polinom5, polinom6));

        Polinom polinom7 = ParsareString.parsare("x^2-2x+1");
        Polinom polinom8 = ParsareString.parsare("x^2-2x+1");
        assertEquals("0", "" + OperatiiPolinoame.subPolinoame(polinom7, polinom8));
    }

    @Test
    public void testInmultire(){
        Polinom polinom1 = ParsareString.parsare("x+2");
        Polinom polinom2 = ParsareString.parsare("x+2");
        assertEquals("x^2+4x+4", "" + OperatiiPolinoame.mullPolinoame(polinom1, polinom2));

        Polinom polinom3 = ParsareString.parsare("x^2+3x+5");
        Polinom polinom4 = ParsareString.parsare("2x-3");
        assertEquals("2x^3+3x^2+x-15", "" + OperatiiPolinoame.mullPolinoame(polinom3, polinom4));

        Polinom polinom5 = ParsareString.parsare("x^4+3x+5");
        Polinom polinom6 = ParsareString.parsare("x^2+1");
        assertEquals("x^6+x^4+3x^3+5x^2+3x+5", "" + OperatiiPolinoame.mullPolinoame(polinom5, polinom6));

        Polinom polinom7 = ParsareString.parsare("-x^2-2x+5");
        Polinom polinom8 = ParsareString.parsare("x^3-4");
        assertEquals("-x^5-2x^4+5x^3+4x^2+8x-20", "" + OperatiiPolinoame.mullPolinoame(polinom7, polinom8));
    }

    @Test
    public void testInmultireMonom(){
        Polinom polinom1 = ParsareString.parsare("x+2");
        Monom monom1 = new Monom(1, 1);
        assertEquals("x^2+2x", "" + OperatiiPolinoame.mullPolinoame(polinom1, monom1));

        Polinom polinom2 = ParsareString.parsare("x^2-3x+5");
        Monom monom2 = new Monom(3, 2);
        assertEquals("3x^4-9x^3+15x^2", "" + OperatiiPolinoame.mullPolinoame(polinom2, monom2));

        Polinom polinom3 = ParsareString.parsare("x^4+3x+5");
        Monom monom3 = new Monom(1, 2);
        assertEquals("x^6+3x^3+5x^2", "" + OperatiiPolinoame.mullPolinoame(polinom3, monom3));

        Polinom polinom4 = ParsareString.parsare("-x^2-2x+5");
        Monom monom4 = new Monom(-4, 0);
        assertEquals("4x^2+8x-20", "" + OperatiiPolinoame.mullPolinoame(polinom4, monom4));
    }

    @Test
    public void testDerivare(){
        Polinom polinom1 = ParsareString.parsare("x+2");
        OperatiiPolinoame.derivare(polinom1);
        assertEquals("1", "" + polinom1);

        Polinom polinom2 = ParsareString.parsare("x^5-3x^4+2x^2+3");
        OperatiiPolinoame.derivare(polinom2);
        assertEquals("5x^4-12x^3+4x", "" + polinom2);

        Polinom polinom3 = ParsareString.parsare("x^2-x+5");
        OperatiiPolinoame.derivare(polinom3);
        assertEquals("2x-1", "" + polinom3);

        Polinom polinom4 = ParsareString.parsare("10");
        OperatiiPolinoame.derivare(polinom4);
        assertEquals("0", "" + polinom4);
    }

    @Test
    public void testIntegrare(){
        Polinom polinom1 = ParsareString.parsare("x+2");
        OperatiiPolinoame.integrare(polinom1);
        assertEquals("0.5x^2+2x", "" + polinom1);

        Polinom polinom2 = ParsareString.parsare("4x^3+x^2-3x+1");
        OperatiiPolinoame.integrare(polinom2);
        assertEquals("x^4+0.33x^3-1.5x^2+x", "" + polinom2);

        Polinom polinom3 = ParsareString.parsare("x^4-3x+5");
        OperatiiPolinoame.integrare(polinom3);
        assertEquals("0.2x^5-1.5x^2+5x", "" + polinom3);

        Polinom polinom4 = ParsareString.parsare("-20x^4");
        OperatiiPolinoame.integrare(polinom4);
        assertEquals("-4x^5", "" + polinom4);
    }

    @Test
    public void testImpartire(){
        Polinom polinom1 = ParsareString.parsare("x^2+2");
        Polinom polinom2 = ParsareString.parsare("x^2+2");
        assertEquals("CAT: 1    REST: 0", "" + OperatiiPolinoame.divPolinoame(polinom1, polinom2));

        Polinom polinom3 = ParsareString.parsare("x^2+6x+12");
        Polinom polinom4 = ParsareString.parsare("x+3");
        assertEquals("CAT: x+3    REST: 3", "" + OperatiiPolinoame.divPolinoame(polinom3, polinom4));

        Polinom polinom5 = ParsareString.parsare("x^3-6x^2+5x-3");
        Polinom polinom6 = ParsareString.parsare("x-2");
        assertEquals("CAT: x^2-4x-3    REST: -9", "" + OperatiiPolinoame.divPolinoame(polinom5, polinom6));

        Polinom polinom7 = ParsareString.parsare("x^4-7x^3+2x^2-3x+11");
        Polinom polinom8 = ParsareString.parsare("3x^2+4x+7");
        assertEquals("CAT: 0.33x^2-2.78x+3.59    REST: 2.07x-14.15", "" + OperatiiPolinoame.divPolinoame(polinom7, polinom8));
    }

    @Test
    public void testVerificareMonom1(){
        Monom monom1 = new Monom(3, 5);
        Monom monom2 = ParsareString.verificare("3x^5");
        assertEquals(monom1,monom2);

        Monom monom3 = new Monom(-18, 0);
        Monom monom4 = ParsareString.verificare("-3*6");
        assertEquals(monom3,monom4);

        Monom monom5 = new Monom(5, 2);
        Monom monom6 = ParsareString.verificare("20/4x^2");
        assertEquals(monom5,monom6);
    }

    @Test
    public void testVerificareMonom2(){
        assertNull(ParsareString.verificare("3ax^2"));
        assertNull(ParsareString.verificare("3x^^2"));
        assertNull(ParsareString.verificare("1x^"));
        assertNull(ParsareString.verificare("abcd"));
        assertNull(ParsareString.verificare("xx^2"));
    }

    @Test
    public void testParsarePolinom(){
        Polinom polinom1 = new Polinom();
        polinom1.addMonom(new Monom(2, 3));
        polinom1.addMonom(new Monom(-1, 2));
        polinom1.addMonom(new Monom(5, 1));
        polinom1.addMonom(new Monom(-7, 0));
        Polinom polinom2 = ParsareString.parsare("2x^3-2x^2+5x-7");
        for (Monom m : polinom1.getMonoame()){
            assertTrue(polinom2.getMonoame().contains(m));
            assertEquals(polinom1.getMonoame().size(), polinom2.getMonoame().size());
        }

        Polinom polinom3 = new Polinom();
        polinom1.addMonom(new Monom(-1, 2));
        polinom1.addMonom(new Monom(2, 1));
        polinom1.addMonom(new Monom(8, 0));
        Polinom polinom4 = ParsareString.parsare("-x^2+5x-2x+8");
        for (Monom m : polinom3.getMonoame()){
            assertTrue(polinom4.getMonoame().contains(m));
            assertEquals(polinom3.getMonoame().size(), polinom4.getMonoame().size());
        }
    }
}
