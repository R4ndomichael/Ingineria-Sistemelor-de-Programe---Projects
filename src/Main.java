

public boolean check(List<Student> container, Student toSrc){

    for(Student st : container) {
        if (st.nume.equals(toSrc.nume) && st.prenume.equals(toSrc.prenume) && st.formatieDeStudiu.equals(toSrc.formatieDeStudiu))
            return true;
    }
    return false;

}

public boolean checkO_1(HashSet<Student> container, Student toSrc){

    return container.contains(toSrc);

}




void main() {
    System.out.println();
    System.out.println("Program output: ");

    int i = 1;

    List<Student> studList = new ArrayList();

    Student stud1 = new Student(979, "Popescu", "George", "ISM_21/2");
    Student stud2 = new Student(765, "Ionescu", "Ionut", "ISM_21/1");
    Student stud3 = new Student(120, "Popa", "Alis", "TI_21/2");
    Student stud4 = new Student(356, "Georgescu", "Paul", "C_21/2");
    Student stud5 = new Student(646, "Florescu", "Dan", "C_21/2");

    studList.add(stud1);
    studList.add(stud2);
    studList.add(stud3);
    studList.add(stud4);
    studList.add(stud5);

//a)
    System.out.println("Date studenti gasite: ");
    for(Student st : studList){
        System.out.println(">> " + i + ". " + st);
        i++;
    }


//b)
    Student stud_check_B = new Student(120, "Popa", "Alis", "TI_21/2");

    if(check(studList, stud_check_B))
        System.out.println("\n !!! " + stud_check_B.nume + " " + stud_check_B.prenume + " a fost gasit/a. ");
    else
        System.out.println("\n !!! " + stud_check_B.nume + " " + stud_check_B.prenume + " NU a fost gasit/a. ");

//c)
    Student stud_check_C = new Student(112, "Popa", "Maria", "TI_21/1");

    if(check(studList, stud_check_C))
        System.out.println("\n !!! " + stud_check_C.nume + " " + stud_check_C.prenume + " a fost gasit/a. ");
    else
        System.out.println("\n !!! " + stud_check_C.nume + " " + stud_check_C.prenume + " NU a fost gasit/a. ");



//2.5.3
    System.out.println("\n O(1): ");

    HashSet<Student> studSet = new HashSet<Student>();
    studSet.addAll(studList);

    //b)
        if(checkO_1(studSet, stud_check_B))
            System.out.println("\n !!! " + stud_check_B.nume + " " + stud_check_B.prenume + " a fost gasit/a. ");
        else
            System.out.println("\n !!! " + stud_check_B.nume + " " + stud_check_B.prenume + " NU a fost gasit/a. ");
    //c)
        if(checkO_1(studSet, stud_check_C))
            System.out.println("\n !!! " + stud_check_C.nume + " " + stud_check_C.prenume + " a fost gasit/a. ");
        else
            System.out.println("\n !!! " + stud_check_C.nume + " " + stud_check_C.prenume + " NU a fost gasit/a. ");



    System.out.println();
}
