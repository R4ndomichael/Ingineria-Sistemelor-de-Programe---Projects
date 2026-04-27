package Laborator7.lab7_Drive.util;

public class PasswordMaker {
    private static final int MAGIC_NUMBER = 3;
    private static final String MAGIC_STRING;

    private String name;

    static {
        StringRandomizer srand = new StringRandomizer();
        MAGIC_STRING = srand.randomString(20);
    }

    public String getPassword() {
        java.util.Random r = new java.util.Random();
        String ln = ""+name.length();
        ln += r.nextInt(101);
        StringRandomizer srand = new StringRandomizer();
        return srand.randomString(MAGIC_NUMBER) + srand.randomString(10, MAGIC_STRING) + ln;
    }

    //
    private PasswordMaker(String name) {
        this.name = name;
    }

        // counting
        private static int callingCount = 0;

        public static int getCallingCounts() {
            return callingCount;
        }

    private static PasswordMaker instance;

    static {
        instance = new PasswordMaker("default");
    }

    public static PasswordMaker getInstance() {
        callingCount++;
        return instance;
    }

}

