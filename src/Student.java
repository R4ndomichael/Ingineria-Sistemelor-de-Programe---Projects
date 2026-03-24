import java.util.List;

public class Student {

    int numarMatricol;
    String nume;
    String prenume;
    String formatieDeStudiu;

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
        return "" + numarMatricol + ", " + nume + ", " + prenume + ", " + formatieDeStudiu;
    }

}
