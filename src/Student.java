import java.util.HashSet;
import java.util.Set;

public class Student {

    private final int numarMatricol;
    private final String nume;
    private final String prenume;
    private final String formatieDeStudiu;
    private final double nota;

    public Student(int numarMatricol, String prenume, String nume, String formatieDeStudiu, double nota){
        this.numarMatricol = numarMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
        this.nota = nota;
    }

    public String getNume(){
        return nume;
    }

    public String getPrenume(){
        return prenume;
    }

    public String getFormatieDeStudiu(){
        return formatieDeStudiu;
    }

    public int getNumarMatricol(){
        return numarMatricol;
    }

    public double getNota(){
        return nota;
    }

    @Override
    public String toString(){
        return numarMatricol + ", " + nume + ", " + prenume + ", " + formatieDeStudiu + ", " + nota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student s = (Student) o;
        return this.numarMatricol == s.numarMatricol;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(numarMatricol);
    }


    static Student schimbaFormatia(Student st, String nouaFormatie) {
        return new Student(
                st.getNumarMatricol(),
                st.getPrenume(),
                st.getNume(),
                nouaFormatie,
                st.getNota()
        );
    }

    static Set<Student> imparteInDouaFormatii(Set<Student> studenti, String f1, String f2) {

        Set<Student> rezultat = new HashSet<>();

        int i = 0;
        int size = studenti.size();
        int limita = size / 2 + size % 2; // prima grupă poate avea +1

        for (Student s : studenti) {
            if (i < limita) {
                rezultat.add(schimbaFormatia(s, f1));
            } else {
                rezultat.add(schimbaFormatia(s, f2));
            }
            i++;
        }

        return rezultat;
    }
}