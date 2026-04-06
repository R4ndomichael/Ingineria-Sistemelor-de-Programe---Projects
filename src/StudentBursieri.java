public class StudentBursieri extends Student {

    private double cuantumBursa;

    public StudentBursieri(int numarMatricol, String prenume, String nume, String formatieDeStudiu, double medie, double cuantumBursa) {

        super(numarMatricol, prenume, nume, formatieDeStudiu);

        setNota(medie);
        this.cuantumBursa = cuantumBursa;
    }

    @Override
    public String toString() {
        return super.toString() + ", bursa=" + cuantumBursa;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;

        StudentBursieri other = (StudentBursieri) o;
        return cuantumBursa == other.cuantumBursa;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + Double.hashCode(cuantumBursa);
    }
}