void main() {

    List<Integer> x = new ArrayList();
    List<Integer> y = new ArrayList();
    List<Integer> xPlusY = new ArrayList(); //a
    Set<Integer> zSet = new TreeSet(); //b
    List<Integer> xMinusY = new ArrayList();//c
    int p = 4;
    List<Integer> xPlusYLimitedByP = new ArrayList(); //d

//1
    // liste
    Random rand = new Random();

    // init x
    for(int i = 0; i < 5; i++){
        x.add(rand.nextInt(11));
    }

    // init y
    for(int i = 0; i < 7; i++){
        y.add(rand.nextInt(11));
    }

    // sortare
    Collections.sort(x);
    Collections.sort(y);

    System.out.println("\n x = " + x + "   y = " + y);

    // adaugare
    xPlusY.addAll(x);
    xPlusY.addAll(y);

    Collections.sort(xPlusY);

    System.out.println("\n xPlusY: " + xPlusY);

//2
    zSet.addAll(x);
    zSet.retainAll(y);

    System.out.println("\n zSet: " + zSet);

//3
    xMinusY.addAll(x);
    xMinusY.removeAll(y);

    System.out.println("\n xMinusY: " + xMinusY);


//4
    for(Integer elem : x){
        if(elem <= p){
            xPlusYLimitedByP.add(elem);
        }
    }

    for(Integer elem : y){
        if(elem <= p){
            xPlusYLimitedByP.add(elem);
        }
    }

    Collections.sort(xPlusYLimitedByP);

    System.out.println("\n xPlusYLimitedByP: " + xPlusYLimitedByP);
}