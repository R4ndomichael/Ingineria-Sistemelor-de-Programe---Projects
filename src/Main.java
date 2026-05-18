import java.io.IOException;
import java.nio.file.*;
import java.util.*;


static double gasesteNota(String prenume, String nume, Map<Integer, Student> studentiMap){
    HashMap<String, Student> map = new HashMap<>();

    for(Student s : studentiMap.values()){
        String key = s.getPrenume() + "-" + s.getNume();
        map.put(key, s);
    }

    Student s = map.get(prenume + "-" + nume);

    if(s == null)
        return 0.0;

    return s.getNota();
}


// Lab 5
static void writeToFile(String filename, Collection<? extends Student> studenti) {

    try (PrintWriter writer = new PrintWriter(filename)) {

        for (Student s : studenti) {
            writer.println(s);
        }

    }

    catch (Exception e) {
        e.printStackTrace();
    }
}




void main() throws IOException {

    // import
    List<String> input = Files.readAllLines(Path.of("src/Laborator3/studenti_in.txt"));

    List<Student> studList = new ArrayList<>();

    for(String line : input){
        String[] data = line.split(",");

        Student s = new Student(Integer.parseInt(data[0]), data[1], data[2], data[3], 0.0);

        studList.add(s);
    }

    Collections.sort(studList, Comparator.comparing(Student::getNume));


    System.out.println("Studenti sortati:");
    for(Student s : studList){
        System.out.println(s);
    }

    List<String> output = new ArrayList();
    for(Student s : studList){
        output.add(s.toString());
    }

    // export
    Files.write(Path.of("src/Laborator3/sstudenti_out.txt"), output);


    // -----------------4.5.2--------------------------------

            Map<Integer, Student> studentiMap = new HashMap<>();

            for(Student s : studList){
                studentiMap.put(s.getNumarMatricol(), s);    // populare
            }


            List<String> note = Files.readAllLines(Path.of("src/Laborator4/note_anon.txt"));

            for(String line : note){

                String[] data = line.split(",");

                int nr = Integer.parseInt(data[0]);
                float nota = Float.parseFloat(data[1]);

                Student s = studentiMap.get(nr);

                if(s != null){
                    Student nou = new Student(
                            s.getNumarMatricol(),
                            s.getPrenume(),
                            s.getNume(),
                            s.getFormatieDeStudiu(),
                            nota
                    );

                    studentiMap.put(nr, nou);
                }
            }

            // afisare
            System.out.println("\n ----------------AFISARE MAP------------------");

            for(Student s : studentiMap.values()){
                System.out.println(s);
            }

            System.out.println("---------------------------------------------");


    //  >>>>>>>>>>>> 4.5.3 >>>>>>>>>>>>>>>>>>>>>>>>>>>>

    double notaM = gasesteNota("Bianca", "Popescu", studentiMap);
    double notaN = gasesteNota("Ioan", "Popa", studentiMap);

    System.out.println("Nota Bianca Popescu: " + notaM);
    System.out.println("Nota Ioan Popa: " + notaN);


    System.out.println("---------------------------------------------");

    // ------------------------------------------------------

//3.5.3
    List<String> output_FS_nume = new ArrayList<>();

    //formatie studiu
    Collections.sort(studList, Comparator.comparing(Student::getFormatieDeStudiu));
    output_FS_nume.add("\n Dupa formatie de studiu: \n");

    //System.out.println("\n Studenti sortati dupa formatie:");
    for(Student s : studList){
        //System.out.println(s);
        output_FS_nume.add(s.toString());
    }

    //nume
    Collections.sort(studList, Comparator.comparing(Student::getPrenume));
    output_FS_nume.add("\n Dupa nume: \n");

    //System.out.println("\n Studenti sortati dupa nume:");
    for(Student s : studList){
        //System.out.println(s);
        output_FS_nume.add(s.toString());
    }

//    studList.sort{
//        Comparator.comparing(Student::getFormatieDeStudiu).thenComparing(Student::getNume);
//    }

    // export
    Files.write(Path.of("src/Laborator3/sstudenti_out_sorted.txt"), output_FS_nume);


    // ----------------------------------- LAB 5 -------------------------------------------
    Set<StudentBursier> bursieri = new HashSet<>();

    bursieri.add(new StudentBursier(1025,"Andrei","Popa","ISM141/2",8.70,725.50));
    bursieri.add(new StudentBursier(1024,"Ioan","Mihalcea","ISM141/1",9.80,801.10));
    bursieri.add(new StudentBursier(1026,"Anamaria","Prodan","TI131/1",8.90,745.50));
    bursieri.add(new StudentBursier(1029,"Bianca","Popescu","TI131/1",9.10,780.80));

    writeToFile("src/Laborator5/bursieri_out.txt", bursieri);

    // ----------------------------------- LAB 7 -------------------------------------------
    Set<Student> studentiSet = new HashSet<>(studList);

    Set<Student> studentiNoi = Student.imparteInDouaFormatii(studentiSet, "TI 211_1", "TI 211_2");

    System.out.println("\n---- STUDENTI DUPA IMPARTIRE ----");

    for(Student s : studentiNoi){
        System.out.println(s);
    }

    // ----------------------------------- LAB 9 -------------------------------------------

    System.out.println("\n================ LAB 9 ================\n");

    List<Student> studentiCuNote = Arrays.asList(
            new Student(1025,"Andrei","Popa","ISM141/2", 8.70),
            new Student(1024,"Ioan","Mihalcea","ISM141/1", 10),
            new Student(1026,"Anamaria","Prodan","TI131/1", 8.90),
            new Student(1029,"Bianca","Popescu","TI131/1", 10),
            new Student(1030,"Maria","Pana","TI131/2", 4.10),
            new Student(1031,"Gabriela","Mohanu","TI131/2", 7.33),
            new Student(1032,"Marius","Nasta","TI131/2", 3.20),
            new Student(1033,"Marius","Nasta","TI131/1", 5.12),
            new Student(1034,"Andrei","Dobrescu","TI131/2", 2.22)
    );


// a) studenti cu nota 10
    System.out.println("a) Studenti cu nota 10:");

    studentiCuNote.stream()
            .filter(s -> s.getNota() == 10)
            .forEach(System.out::println);


// b) studenti cu nota sub 5
    System.out.println("\nb) Studenti cu nota sub 5:");

    studentiCuNote.stream()
            .filter(s -> s.getNota() < 5)
            .forEach(System.out::println);


// c) studenti cu nota sub 4 devin studenti cu nota 4
    System.out.println("\nc) Studenti modificati:");

    List<Student> studentiModificati = studentiCuNote.stream()
            .map(s -> {
                if(s.getNota() < 4) {
                    return new Student(
                            s.getNumarMatricol(),
                            s.getPrenume(),
                            s.getNume(),
                            s.getFormatieDeStudiu(),
                            4
                    );
                }

                return s;
            })
            .collect(Collectors.toList());

    studentiModificati.forEach(System.out::println);


// d) suma notelor
    double suma = studentiCuNote.stream()
            .map(Student::getNota)
            .reduce(0.0, (a, b) -> a + b);

    System.out.println("\nd) Suma notelor: " + suma);


// e) media notelor
    double media = suma / studentiCuNote.size();

    System.out.println("e) Media notelor: " + media);
}