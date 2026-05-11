package Laborator9;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        Random random = new Random();

        //10 numere random in 5 - 25
        List<Integer> numbers = IntStream.range(0, 10)
                .map(i -> 5 + random.nextInt(21))
                .boxed()
                .collect(Collectors.toList());

        System.out.println("Lista initiala:");
        System.out.println(numbers);

        //a)
        int suma = numbers.stream()
                .reduce(0, (a, b) -> a + b);

        System.out.println("\nSuma elementelor: " + suma);

        //b)
        int maxim = numbers.stream()
                .max(Comparator.naturalOrder())
                .get();

        int minim = numbers.stream()
                .min(Comparator.naturalOrder())
                .get();

        System.out.println("Maxim: " + maxim);
        System.out.println("Minim: " + minim);

        //c)
        List<Integer> interval = numbers.stream()
                .filter(n -> n >= 10 && n <= 20)
                .collect(Collectors.toList());

        System.out.println("\nElemente din intervalul [10..20]:");
        System.out.println(interval);

        //d)
        List<Double> doubles = numbers.stream()
                .map(n -> Double.valueOf(n))
                .collect(Collectors.toList());

        System.out.println("\nLista Double:");
        System.out.println(doubles);

        //e)
        boolean exista12 = numbers.stream()
                .anyMatch(n -> n == 12);

        System.out.println("\nExista valoarea 12? " + exista12);


        //---------------- 9.3.2 ----------------

        String text = "Acesta este un program scris in java pentru expresii lambda";

        List<String> cuvinte = Arrays.asList(text.split(" "));

        System.out.println("\nLista cuvinte:");
        System.out.println(cuvinte);

        //a)
        List<String> filtrate = cuvinte.stream()
                .filter(c -> c.length() >= 5)
                .collect(Collectors.toList());

        System.out.println("\nCuvinte cu lungime >= 5:");
        System.out.println(filtrate);

        long numar = cuvinte.stream()
                .filter(c -> c.length() >= 5)
                .count();

        System.out.println("Numar cuvinte: " + numar);

        //b)
        List<String> sortate = filtrate.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("\nLista sortata:");
        System.out.println(sortate);

        //c)
        Optional<String> cuvant = cuvinte.stream()
                .filter(c -> c.startsWith("p"))
                .findFirst();

        if(cuvant.isPresent()) {
            System.out.println("\nCuvant gasit: " + cuvant.get());
        }

    }
}