package Polynomial;
import java.util.TreeSet;

public class Polynomial {
    private TreeSet<Monomial> monomials;

    public Polynomial() {
        monomials = new TreeSet<Monomial>();
    }

    public void addMonomial(Monomial monomial){
        if (monomial.getCoefficient() != 0) {
            if (monomials.contains(monomial)) {
                for (Monomial monomial1 : monomials) {
                    if (monomial1.getPow() == monomial.getPow()) {
                        monomial1.add(monomial.getCoefficient());
                        if (monomial1.getCoefficient() == 0){
                            monomials.remove(monomial1);
                        }
                        break;
                    }
                }
            } else {
                monomials.add(monomial);
            }
        }
    }

    void addMonomials(TreeSet<Monomial> monomials){
        this.monomials.addAll(monomials);
    }

    public TreeSet<Monomial> getMonomials() {
        return monomials;
    }

    @Override
    public String toString() {
        if (monomials.size() == 0){
            return "0";
        }
        String s = "";
        for (Monomial monom : monomials){
            s += monom;
        }
        if (s.charAt(0) == '+'){
            s = s.substring(1);
        }
        return s;
    }
}
