package industry.skills.logs.example.lookup;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Moo implements Serializable {
    static {
        Path path = Paths.get("C:\\personal\\courses\\Workshop Skills\\logs\\logging-examples\\logs - Copy\\all.log");
        try {
            Files.delete(path);
            System.out.println("I have just deleted you a file... muuuhahahahahha !!!!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
