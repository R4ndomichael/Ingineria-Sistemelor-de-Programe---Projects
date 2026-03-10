void main() {

    List<Integer> x = new ArrayList();
    List<Integer> y = new ArrayList();
    List<Integer> xPlusY = new ArrayList(); //a
    Set<Integer> zSet = new TreeSet(); //b
    List<Integer> xMinusY = new ArrayList();//c
    int p = 4;
    List<Integer> xPlusYLimitedByP = new ArrayList(); //d

    // liste
    x.add(5);
    x.add(6);
    x.add(2);
    x.add(9);
    x.add(1);

    y.add(0);
    y.add(5);
    y.add(2);
    y.add(7);
    y.add(4);
    y.add(8);
    y.add(6);

    // sortare
    Collections.sort(x);
    Collections.sort(y);

    // adaugare
    xPlusY.addAll(x);
    xPlusY.addAll(y);

    // afisare
    Collections.sort(xPlusY);

    boolean containsElement = zSet.contains(x);

    zSet.addAll(x);
    zSet.addAll(y);

    if(containsElement)
        zSet.remove(x);


    System.out.println(xPlusY);
}