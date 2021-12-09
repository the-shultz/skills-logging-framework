package industry.skills.logs.example.advance.sort.bubble;

import industry.skills.logs.example.advance.sort.SortCollection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BubbleSort implements SortCollection {

    private static Logger log = LogManager.getLogger(BubbleSort.class);

    @Override
    public <E extends Comparable<E>> Collection<E> sortACollection(Collection<E> input) {

        log.debug("About to sort collection using bubble sort method: " + input);
        Instant start = Instant.now();

        List<E> result = new ArrayList<>(input);

        for(int j = 0 ; j < result.size() ; j++){
            for(int i = j+1 ; i < result.size() ; i++){
                E laterElement = result.get(i);
                E formerElement = result.get(j);
                log.trace("Comparing between " + formerElement + " and " + laterElement + " ...");
                if(laterElement.compareTo(formerElement) < 0){
                    log.trace("Later (" + laterElement + ") is smaller then former (" + formerElement + ")...");
                    log.trace("Swapping them between " + j + " and  " + i);
                    result.set(j, laterElement);
                    result.set(i, formerElement);
                    log.trace("Collection after swapping: " + result);
                }
            }
        }

        Instant end = Instant.now();
        log.debug("Sorted collection in: " + Duration.between(start, end).toNanos() + " nano seconds...");

        return result;
    }
}
