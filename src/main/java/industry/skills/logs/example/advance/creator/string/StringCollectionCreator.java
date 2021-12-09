package industry.skills.logs.example.advance.creator.string;

import industry.skills.logs.example.advance.creator.CollectionCreator;

import java.util.Collection;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringCollectionCreator implements CollectionCreator<String> {

    private Random r = new Random();
    private final int MAX_STRING_LENGTH = 10;

    @Override
    public Collection<String> create(int total) {
        return IntStream.
                range(0, total)
                .mapToObj(this::generateRandomString)
                .collect(Collectors.toSet());
    }


    private String generateRandomString(int count) {
        int stringLength = r.nextInt(MAX_STRING_LENGTH) + 1;
        return r.ints(48,122)
                .filter(i-> (i<57 || i>65) && (i <90 || i>97))
                .mapToObj(i -> (char) i)
                .limit(stringLength)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }
}
