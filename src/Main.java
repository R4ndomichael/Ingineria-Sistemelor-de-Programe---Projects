import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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



// 8.5.4 a — Scriere studenti in xlsx
static void writeToXls(Set<Student> studenti, String fileName) {
    XSSFWorkbook workbook2 = new XSSFWorkbook();
    XSSFSheet sheet2 = workbook2.createSheet();

    int rowNum = 0;

    // rand header
    Row header = sheet2.createRow(rowNum++);
    header.createCell(0).setCellValue("Nr Matricol");
    header.createCell(1).setCellValue("Prenume");
    header.createCell(2).setCellValue("Nume");
    header.createCell(3).setCellValue("Formatie");
    header.createCell(4).setCellValue("Nota");

    // randuri studenti
    for (Student st : studenti) {
        Row row2 = sheet2.createRow(rowNum++);
        int colNum = 0;
        row2.createCell(colNum++).setCellValue(st.getNumarMatricol());
        row2.createCell(colNum++).setCellValue(st.getPrenume());
        row2.createCell(colNum++).setCellValue(st.getNume());
        row2.createCell(colNum++).setCellValue(st.getFormatieDeStudiu());
        row2.createCell(colNum++).setCellValue(st.getNota());
    }

    try {
        FileOutputStream out = new FileOutputStream(fileName);
        workbook2.write(out);
        out.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

// 8.5.4 b — Citire studenti din xlsx
static List<Student> readFromXls(String fileName) {
    List<Student> studentsFromXls = new ArrayList<>();

    try (InputStream fis = new FileInputStream(fileName)) {
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            // sarim peste header
            if (row.getRowNum() == 0) continue;

            int numarMatricol = (int) row.getCell(0).getNumericCellValue();
            String prenume = row.getCell(1).getStringCellValue();
            String nume = row.getCell(2).getStringCellValue();
            String formatie = row.getCell(3).getStringCellValue();
            double nota = row.getCell(4).getNumericCellValue();

            studentsFromXls.add(new Student(numarMatricol, prenume, nume, formatie, nota));
        }

    } catch (IOException ex) {
        ex.printStackTrace();
    }

    return studentsFromXls;
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

    // ----------------------------------- LAB 8 -------------------------------------------

    System.out.println("\n ---------------------------------------------");

    // 8.5.4 a
    String xlsFileName = "laborator8_students.xlsx";
    writeToXls(studentiNoi, xlsFileName);

    // 8.5.4 b
    List<Student> studentsFromXls = readFromXls(xlsFileName);
    System.out.println("\n Studenti cititi din xlsx:");
    for(Student st: studentsFromXls) {
        System.out.println(st);
    }
}