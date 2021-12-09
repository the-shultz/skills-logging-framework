package industry.skills.logs.example.advance.sort.jdk.collection;


import industry.skills.logs.example.advance.sort.SortCollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class NativeCollectionBasedSorter implements SortCollection {

    @Override
    public <E extends Comparable<E>> Collection<E> sortACollection(Collection<E> input) {
        List<E> result = new ArrayList<>(input);
        Collections.sort(result);
        return result;
    }

}
