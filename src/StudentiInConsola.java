import java.util.List;

public class StudentiInConsola implements IStudentiExport {

    @Override
    public void doExport(List<Student> studenti) {
        for (Student s : studenti) {
            System.out.println(s);
        }
    }
}
