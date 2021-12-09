package industry.skills.logs.example.advance;

import industry.skills.logs.example.advance.creator.CollectionCreator;
import industry.skills.logs.example.advance.sort.SortCollection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.time.Duration;
import java.time.Instant;
import java.util.Collection;

public class MainSorter {

    private static Logger log = LogManager.getLogger(MainSorter.class);

    public static void main(String[] args) {
        CollectionCreator<Integer> intsCreator = CollectionCreator.get(Integer.class);
        log.debug("Created ints creator successfully...");

        Collection<Integer> integersCollection = intsCreator.create(10);
        log.info("Created integers: " + integersCollection);

        // test by bubble sort
        testBubbleSort(integersCollection);

        // test by native collection sort
        testNativeCollectionSort(integersCollection);

        // test by native stream sort
        testNativeStreamSort(integersCollection);

    }

    private static void testNativeStreamSort(Collection<Integer> integersCollection1) {
        log.info("Testing native stream based sort...");
        SortCollection bubbleSortCollection = SortCollection.get(SortCollection.SORT_ALG.STREAM);
        log.debug("Created native stream based sort sorter successfully...");
        sortByAlgorithm(integersCollection1, bubbleSortCollection);
    }

    private static void testNativeCollectionSort(Collection<Integer> integersCollection1) {
        log.info("Testing native collection based sort...");
        SortCollection bubbleSortCollection = SortCollection.get(SortCollection.SORT_ALG.COLLECTION);
        log.debug("Created native collection based sort sorter successfully...");
        sortByAlgorithm(integersCollection1, bubbleSortCollection);
    }


    private static void testBubbleSort(Collection<Integer> integersCollection1) {
        log.info("Testing bubble sort...");
        SortCollection bubbleSortCollection = SortCollection.get(SortCollection.SORT_ALG.BUBBLE);
        log.debug("Created bubble sort sorter successfully...");
        sortByAlgorithm(integersCollection1, bubbleSortCollection);
    }

    private static void sortByAlgorithm(Collection<Integer> collection, SortCollection sorter) {
        log.info("Sorting...");
        Instant start = Instant.now();
        Collection<Integer> sortedCollection = sorter.sortACollection(collection);
        Instant end = Instant.now();
        log.info("After sorting: " + sortedCollection + " took: " + Duration.between(start, end).toNanos() + " nano seconds...");
    }

}
