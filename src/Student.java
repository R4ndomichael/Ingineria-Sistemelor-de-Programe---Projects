import java.util.List;

public class Student {

    int numarMatricol;
    String nume;
    String prenume;
    String formatieDeStudiu;

    double nota;


    Student(int numarMatricol_in, String prenume_in, String nume_in, String formatieDeStudiu_in){
        numarMatricol = numarMatricol_in;
        prenume = prenume_in;
        nume = nume_in;
        formatieDeStudiu = formatieDeStudiu_in;
    }

    public String getNume(){
        return this.nume;
    }

    public String getFormatieDeStudiu(){
        return this.formatieDeStudiu;
    }

    public String toString(){
        //return "Student Data|  Nr. MATRICOL: " + numarMatricol + ", NUME: " + nume + ", PRENUME: " + prenume + ", FORMATIE_STUDIU: " + formatieDeStudiu + ". " ;
        return "" + numarMatricol + ", " + nume + ", " + prenume + ", " + formatieDeStudiu + ", " + nota;
    }


    public void setNota(double nota) {
        this.nota = nota;
    }

    //anon
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
}
