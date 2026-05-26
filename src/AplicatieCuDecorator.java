import java.util.Arrays;
import java.util.List;

public class AplicatieCuDecorator {
    public static void main(String[] args) {

        List<Student> studenti = Arrays.asList(
                new Student(1025, "Andrei",   "Popa",      "ISM141/2",  8.70),
                new Student(1024, "Ioan",     "Mihalcea",  "ISM141/1",  10),
                new Student(1026, "Anamaria", "Prodan",    "TI131/1",   8.90),
                new Student(1029, "Bianca",   "Popescu",   "TI131/1",   10),
                new Student(1029, "Maria",    "Pana",      "TI131/2",   4.10)
        );


        Exporter exporter = new Exporter();

        System.out.println("=== Export in consola cu timer ===");
        IStudentiExport consola = new ExportTimerDecorator(new StudentiInConsola());
        exporter.startExport(consola, studenti);

        System.out.println("\n=== Export in fisier txt cu timer ===");
        IStudentiExport txt = new ExportTimerDecorator(new StudentiInFisierText("studentiDecorator.txt"));
        exporter.startExport(txt, studenti);

        System.out.println("\n=== Export in fisier xlsx cu timer ===");
        IStudentiExport xlsx = new ExportTimerDecorator(new StudentiInFisierXlsx("studentiDecorator.xlsx"));
        exporter.startExport(xlsx, studenti);
    }
}
