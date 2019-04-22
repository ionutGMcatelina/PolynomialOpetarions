package Polinoame;
import java.util.TreeSet;

public class Polinom {
    private TreeSet<Monom> monoame;                             // TreeSet in care tin monoamele

    public Polinom() {
        monoame = new TreeSet<Monom>();
    }

    public void addMonom(Monom monom){                          // Metoda care adauga un monom in polinom
        if (monom.getCoeficient() != 0) {
            if (monoame.contains(monom)) {                      // Daca deja exista un monom cu acelasi grad, daor ii adunam coeficientul din noul monom
                for (Monom monom1 : monoame) {                  // Cautam monomul cu acelasi grad
                    if (monom1.getPutere() == monom.getPutere()) {
                        monom1.add(monom.getCoeficient());
                        if (monom1.getCoeficient() == 0){       // Daca prin adunare coeficientul este 0, scoatem monomul din polinom
                            monoame.remove(monom1);
                        }
                        break;
                    }
                }
            } else {                                            // Daca nu avem un monom cu acelasi grad, il adaugam in treeSet
                monoame.add(monom);
            }
        }
    }

    void addMonoame(TreeSet<Monom> monoame){                    // Metoda in care adaug un set de monoame
        this.monoame.addAll(monoame);
    }

    public TreeSet<Monom> getMonoame() {                        // Returnez toate monoamele
        return monoame;
    }

    @Override
    public String toString() {
        if (monoame.size() == 0){                               // Daca treeSetul este gol returnez "0"
            return "0";
        }
        String s = "";
        for (Monom monom : monoame){                            // In s adaug toate monoamele
            s += monom;
        }
        if (s.charAt(0) == '+'){                                // Daca priml caracter este + il scot
            s = s.substring(1);
        }
        return s;
    }
}
