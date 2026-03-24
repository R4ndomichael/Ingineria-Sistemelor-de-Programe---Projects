import java.io.IOException;
import java.nio.file.*;
import java.util.*;

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



//3.5.3
    List<String> output_FS_nume = new ArrayList<>();

    //formatie studiu
    Collections.sort(studList, Comparator.comparing(s -> s.formatieDeStudiu));
    output_FS_nume.add("\n Dupa formatie de studiu: \n");

    System.out.println("\n Studenti sortati dupa formatie:");
    for(Student s : studList){
        System.out.println(s);
        output_FS_nume.add(s.toString());
    }

    //nume
    Collections.sort(studList, Comparator.comparing(s -> s.prenume));
    output_FS_nume.add("\n Dupa nume: \n");

    System.out.println("\n Studenti sortati dupa nume:");
    for(Student s : studList){
        System.out.println(s);
        output_FS_nume.add(s.toString());
    }

//    studList.sort{
//        Comparator.comparing(Student::getFormatieDeStudiu).thenComparing(Student::getNume);
//    }

    // export
    Files.write(Path.of("src/Laborator3/sstudenti_out_sorted.txt"), output_FS_nume);
}