package Laborator4;

public class Tanar {

    private String name;
    private int age;
    private String address;

    Tanar(String new_name, int new_age, String new_address) {
        this.name = new_name;
        this.age = new_age;
        this.address = new_address;
    }

    @Override
    public String toString() {
        return "Tanar{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
