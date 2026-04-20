import java.util.ArrayList;
import java.util.List;

import java.util.Collections;
import java.util.Comparator;


public class AplicatieCuBursa {
    static void main(String[] args) {
        AplicatieCuBursa instanta = new AplicatieCuBursa();
        List<StudentBursier> lista = instanta.genereaza();
        for (StudentBursier student : lista) {
            System.out.println(student);
        }
        System.out.println("--------------------------------------------------");
        List<StudentBursier> sortata = instanta.sorteaza(lista);
        for (StudentBursier student : sortata) {
            System.out.println(student);
        }
    }

    public List<StudentBursier> genereaza() {
        List<StudentBursier> lista = new ArrayList<>();
        lista.add( new StudentBursier(1025,"Andrei","Popa","ISM141/2", 8.70, 725.50));
        lista.add( new StudentBursier(1024,"Ioan","Mihalcea","ISM141/1", 9.80, 801.10));
        lista.add( new StudentBursier(1029,"Bianca","Popescu","TI131/1,", 9.10, 780.80));
        lista.add( new StudentBursier(1026,"Anamaria","Prodan","TI131/1", 8.90, 745.50));
        lista.add( new StudentBursier(1029,"Bianca","Popescu","TI131/1,", 9.10, 100.00));
        return lista;
    }

    public List<StudentBursier> sorteaza(List<StudentBursier> lst) {

        Collections.sort(lst, new Comparator<StudentBursier>() {
            @Override
            public int compare(StudentBursier s1, StudentBursier s2) {

                // 1. formatie
                int cmp = s1.getFormatieDeStudiu().compareTo(s2.getFormatieDeStudiu());
                if (cmp != 0) return cmp;

                // 2. nume
                cmp = s1.getNume().compareTo(s2.getNume());
                if (cmp != 0) return cmp;

                // 3. prenume
                cmp = s1.prenume.compareTo(s2.prenume);
                if (cmp != 0) return cmp;

                // 4. nota
                cmp = Double.compare(s1.nota, s2.nota);
                if (cmp != 0) return cmp;

                // 5. bursa
                return Double.compare(s1.getCuantumBursa(), s2.getCuantumBursa());
            }
        });

        return lst;
    }
}