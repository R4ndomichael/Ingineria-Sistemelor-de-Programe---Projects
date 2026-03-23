import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


void main() throws IOException {

    String input = Files.readString(Path.of("src/Laborator3/in.txt"));

    System.out.println("Input: \n" + input + "\n");

    System.out.println("Separat: \n");
    String[] props = input.split("\\.");
    for(String w: props) {
        System.out.print("[" + w.trim() + "] \n");
    }


}