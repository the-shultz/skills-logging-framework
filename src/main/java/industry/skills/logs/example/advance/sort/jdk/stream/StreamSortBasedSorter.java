package industry.skills.logs.example.advance.sort.jdk.stream;


import industry.skills.logs.example.advance.sort.SortCollection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class StreamSortBasedSorter implements SortCollection {

    private static Logger log = LogManager.getLogger(StreamSortBasedSorter.class);

    @Override
    public <E extends Comparable<E>> Collection<E> sortACollection(Collection<E> input) {

        log.debug("About to sort collection using native stream.sort() method: " + input);
        Instant start = Instant.now();

        ArrayList<E> result = input
                .stream()
                .sorted()
                .collect(Collectors.toCollection(ArrayList::new));

        Instant end = Instant.now();
        log.debug("Sorted collection in: " + Duration.between(start, end).toNanos() + " nano seconds...");

        return result;
    }
}
