package industry.skills.logs.example.advance.creator.string;

import industry.skills.logs.example.advance.creator.CollectionCreator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;
import java.time.Instant;
import java.util.Collection;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringCollectionCreator implements CollectionCreator<String> {

    private static Logger log = LogManager.getLogger(StringCollectionCreator.class);
    private final int MAX_STRING_LENGTH = 10;

    private Random r = new Random();

    @Override
    public Collection<String> create(int total) {
        log.info("About to create collection of " + total + " strings...");
        return IntStream.
                range(0, total)
                .mapToObj(this::generateRandomString)
                .collect(Collectors.toSet());
    }


    private String generateRandomString(int count) {
        int stringLength = r.nextInt(MAX_STRING_LENGTH) + 1;
        log.debug("About to create single string (#" + (count + 1) + ") with length of " + stringLength);

        Instant start = Instant.now();
        String newString = r.ints(48, 122)
                .filter(i -> (i < 57 || i > 65) && (i < 90 || i > 97))
                .mapToObj(i -> (char) i)
                .limit(stringLength)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
        Instant end = Instant.now();
        log.debug("Created new string: [" + newString + "] in " + Duration.between(start, end).toNanos() + " nano seconds...");

        return newString;
    }
}
