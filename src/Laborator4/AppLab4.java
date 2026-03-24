package Laborator4;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AppLab4 {

    static void AfisareMap(HashMap<String, Integer> toMap){

        System.out.println("\n >> Chei gasite: ");

        for(Object key : toMap.keySet()) { //parcurgere Map folosind for-each
            Object value = toMap.get(key);

            System.out.println(key + ": " + value);
        }

    }

    public static void main(String[] args) throws IOException {

        HashMap<String, Integer> varste = new HashMap<>();
        varste.put("Ioan", 21);
        varste.put("Maria", 22);
        varste.put("Victor", 20);
        varste.put("Simina", 20);
        varste.put("Marius", 21);
        varste.put("Mihai", 21);
        varste.put("Daniela", 23);

        Map<String, String> adrese = Map.of("Ioan", "Sibiu", "Maria", "Bucuresti", "Victor", "Cluj","Simina", "Alba-Iulia","Marius", "Medias", "Mihai", "Cisnadie","Daniela", "Sibiu");

        // Parcurgere
        AfisareMap(varste);

        // Adaugare
        varste.put("Vlad", 19);
        varste.put("Iulia", 21);

        System.out.print("\n >>> Dupa adaugare: ");
        AfisareMap(varste);

        // Total Hashmap
        HashMap<String, Tanar> tineri = null;

        System.out.println("\n >> Chei gasite: ");

        for(Object key : tineri.keySet()) { //parcurgere Map folosind for-each
            Object value = tineri.get(key);

            System.out.println(key + ": " + value);
        }

    }
}
