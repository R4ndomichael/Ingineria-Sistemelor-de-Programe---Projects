import java.io.IOException;
import java.nio.file.*;
import java.util.*;


static double gasesteNota(String prenume, String nume, Map<Integer, Student> studentiMap){
    HashMap<String, Student> map = new HashMap<>();

    for(Student s : studentiMap.values()){
        String key = s.prenume + "-" + s.nume;
        map.put(key, s);
    }

    Student s = map.get(prenume + "-" + nume);

    if(s == null)
        return 0.0;

    return s.nota;
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

        Student s = new Student(Integer.parseInt(data[0]), data[1], data[2], data[3]);

        studList.add(s);
    }

    Collections.sort(studList, Comparator.comparing(s -> s.nume));


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
                studentiMap.put(s.numarMatricol, s);    // populare
            }


            List<String> note = Files.readAllLines(Path.of("src/Laborator4/note_anon.txt"));

            for(String line : note){

                String[] data = line.split(",");

                int nr = Integer.parseInt(data[0]);
                float nota = Float.parseFloat(data[1]);

                Student s = studentiMap.get(nr);

                if(s != null){
                    s.setNota(nota);
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
    Collections.sort(studList, Comparator.comparing(s -> s.formatieDeStudiu));
    output_FS_nume.add("\n Dupa formatie de studiu: \n");

    //System.out.println("\n Studenti sortati dupa formatie:");
    for(Student s : studList){
        //System.out.println(s);
        output_FS_nume.add(s.toString());
    }

    //nume
    Collections.sort(studList, Comparator.comparing(s -> s.prenume));
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

    System.out.println("\n Laborator 5: \n");

    Set<StudentBursieri> bursieri = new HashSet<>();

    bursieri.add(new StudentBursieri(1025,"Andrei","Popa","ISM141/2",8.70,725.50));
    bursieri.add(new StudentBursieri(1024,"Ioan","Mihalcea","ISM141/1",9.80,801.10));
    bursieri.add(new StudentBursieri(1026,"Anamaria","Prodan","TI131/1",8.90,745.50));
    bursieri.add(new StudentBursieri(1029,"Bianca","Popescu","TI131/1",9.10,780.80));

    writeToFile("src/Laborator5/bursieri_out.txt", bursieri);
}