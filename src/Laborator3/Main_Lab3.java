import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


void main() throws IOException {

    // import
    String input = Files.readString(Path.of("src/Laborator3/in.txt"));

    System.out.println("Input: \n" + input + "\n");

    //a
    System.out.println("a) Separat: \n");

    String[] toCutA = input.split("\\n");
    for(String w: toCutA) {
        System.out.print("[" + w.trim() + "] \n\n");
    }

    //b
    System.out.println("b) Separat: \n");

    String[] toCutB = input.split("\\.");
    for(String w: toCutB) {
        System.out.print("[" + w.trim() + "] \n");
    }

    //c
    List<String> output = new ArrayList<>();

    output.add("a)");
    output.addAll(Arrays.asList(toCutA));

    output.add("\n");

    output.add("b)");
    output.addAll(Arrays.asList(toCutB));

    // export
    Files.write(Path.of("src/Laborator3/out.txt"), output);

}