package Laborator7.lab7_Drive.forms;

public class Form {
    private String color;

    //hw
    private static int counter = 0;

    public static int getInstanceCount() {
        return counter;
    }

    public Form() {
        color = "white";

        counter++;
    }

    public Form(String color) {
        this.color = color;

        counter++;
    }

    public float getArea() {
        return 0;
    }

    public String toString() {
        return "This form has the color " + color;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Form) {
            Form f = (Form) obj;
            if (this.color == null && f.color == null) {
                return true;
            } else if (this.color != null && f.color != null && this.color.compareTo(f.color) == 0) {
                return true;
            }
        }
        return false;
    }


}
