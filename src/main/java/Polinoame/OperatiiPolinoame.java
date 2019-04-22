package Polinoame;

public class OperatiiPolinoame {
    public static Polinom addPolinoame(Polinom polinom1, Polinom polinom2){ // Metoda care aduna 2 polinoame
        Polinom newPolinom = new Polinom();
        newPolinom.addMonoame(polinom1.getMonoame());                       // Adaug toate monoamele din polinom1 in newPolinom
        for (Monom monom1 : polinom2.getMonoame()){
           newPolinom.addMonom(monom1);                                     // Iau fiecare monom din polinom 2 si il adun la newPolinom
        }
        return newPolinom;
    }

    public static Polinom subPolinoame(Polinom polinom1, Polinom polinom2){ // Metoda care scade 2 polinoame
        Polinom newPolinom = new Polinom();                                 // Similar cu addPolinoame, doar ca aici scad monoamele
        newPolinom.addMonoame(polinom1.getMonoame());
        for (Monom monom1 : polinom2.getMonoame()){
            monom1.setCoeficient(-monom1.getCoeficient());
            newPolinom.addMonom(monom1);
        }
        return newPolinom;
    }

    public static Polinom mullPolinoame(Polinom polinom1, Polinom polinom2){// Metoda care inmulteste 2 polinoame
        Polinom newPolinom = new Polinom();
        for (Monom monom1 : polinom1.getMonoame()){
            for (Monom monom2 : polinom2.getMonoame()){                     // Inmultesc fiecare monom din polinom1 cu fiecare monom din polinom2 si de adaug in newPolinom
                Monom newMonom = monom1.mull(monom2);
                newPolinom.addMonom(newMonom);
            }
        }
        return newPolinom;
    }

    public static Polinom mullPolinoame(Polinom polinom, Monom monom){      // Metoda care inmulteste un polinom cu un monom
        Polinom newPolinom = new Polinom();
        for (Monom monom1 : polinom.getMonoame()){                          // Iau fiecare monom din polinom si il inmultesc cu monomul, si rezultatul il adaug la newMonom
            Monom newMonom = monom1.mull(monom);
            newPolinom.addMonom(newMonom);
        }
        return newPolinom;
    }

    public static void derivare(Polinom polinom){                           // Metoda care deriveaza un polinom
        for (Monom monom : polinom.getMonoame()){
            monom.derivare();                                               // Iau fiecare monom din polinom si il derivez
            if (monom.getCoeficient() == 0){
                polinom.getMonoame().remove(monom);                         // Daca coeficientul monomului ii 0, il scot din polinom
            }
        }
    }

    public static void integrare(Polinom polinom){                          // Metoda care integreaza un polinom
        for (Monom monom : polinom.getMonoame()){
            monom.integrare();                                              // Iau fiecare monom din polinom si il integrez
        }
    }

    public static String divPolinoame(Polinom polinom1, Polinom polinom2){  // Metoda care imparte un polinom la alt polinom
        if (polinom1.getMonoame().size() == 0){
            if (polinom2.getMonoame().size() == 0){
                return "CAZ DE NEDETERMINARE";
            }
            return "CAT: " + "0" + "    REST: " + polinom2;
        }

        if (polinom2.getMonoame().size() == 0){
            return "CAT: " + "inf" + "    REST: 0";
        }

        if (polinom1.getMonoame().first().getPutere() < polinom2.getMonoame().first().getPutere()){// Daca polinom1 are gradul mai mic decat polinom2, le inversez
            Polinom aux = polinom1;
            polinom1 = polinom2;
            polinom2 = aux;
        }

        Polinom cat = new Polinom();                                        // Catul impartirii, restul este polinom1

        while (polinom1.getMonoame().size() != 0 && polinom1.getMonoame().first().getPutere() >= polinom2.getMonoame().first().getPutere()){//cat timp gradul lui polinom1 este mai gare decat gradul lui polinom2
            double coef = polinom1.getMonoame().first().getCoeficient() / polinom2.getMonoame().first().getCoeficient();    // calculez monomul care se inmulteste cu primul monom din polinom1 pt a da primul monom din polinom2
            int putere = polinom1.getMonoame().first().getPutere() - polinom2.getMonoame().first().getPutere();
            Monom m = new Monom(coef, putere);
            cat.addMonom(m);                                                // Adaug monomul la cat
            polinom1 = subPolinoame(polinom1, mullPolinoame(polinom2, m));  // Scad din rest (polinom1) produsul dintre ultimul monol al catului si polinom2 (impartitor)
        }
        return "CAT: " + cat + "    REST: " + polinom1;
    }
}
