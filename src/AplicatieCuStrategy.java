import java.util.List;
import java.util.Arrays;

public class AplicatieCuStrategy {

    public static void main(String[] args) {

        List<Student> studenti = Arrays.asList(
                new Student(1025, "Andrei",   "Popa",      "ISM141/2",  8.70),
                new Student(1024, "Ioan",     "Mihalcea",  "ISM141/1",  10),
                new Student(1026, "Anamaria", "Prodan",    "TI131/1",   8.90),
                new Student(1029, "Bianca",   "Popescu",   "TI131/1,",  10),
                new Student(1029, "Maria",    "Pana",      "TI131/2,",  4.10),
                new Student(1029, "Gabriela", "Mohanu",    "TI131/2,",  7.33),
                new Student(1029, "Marius",   "Nasta",     "TI131/2,",  3.20),
                new Student(1029, "Marius",   "Nasta",     "TI131/1,",  5.12),
                new Student(1029, "Andrei",   "Dobrescu",  "TI131/2,",  2.22)
        );

        Exporter exporter = new Exporter();

        // a) Afisare studenti in consola
        System.out.println("=== a) Afisare in consola ===");
        IStudentiExport strategyConsole = new StudentiInConsola();
        exporter.startExport(strategyConsole, studenti);

        // b) Export studenti in fisier txt
        System.out.println("\n=== b) Export in fisier txt ===");
        String fileNameTxt = "studentiStrategyText.txt";
        StudentiInFisierText strategyFisierText = new StudentiInFisierText(fileNameTxt);
        exporter.startExport(strategyFisierText, studenti);

        // c) Export studenti in fisier xlsx
        System.out.println("\n=== c) Export in fisier xlsx ===");
        String fileNameXlsx = "studentiStrategyExcel.xlsx";
        StudentiInFisierXlsx strategyFisierExcel = new StudentiInFisierXlsx(fileNameXlsx);
        exporter.startExport(strategyFisierExcel, studenti);

        // d) Citire studenti din fisier txt
        System.out.println("\n=== d) Citire din fisier txt ===");
        StudentiDinFisierText strategyDinFisierText = new StudentiDinFisierText(fileNameTxt);
        List<Student> studentiDinTxt = strategyDinFisierText.doImport();
        studentiDinTxt.forEach(System.out::println);

        // e) Citire studenti din fisier xlsx
        System.out.println("\n=== e) Citire din fisier xlsx ===");
        StudentiDinFisierXlsx strategyDinFisierXlsx = new StudentiDinFisierXlsx(fileNameXlsx);
        List<Student> studentiDinXlsx = strategyDinFisierXlsx.doImport();
        studentiDinXlsx.forEach(System.out::println);
    }
}
