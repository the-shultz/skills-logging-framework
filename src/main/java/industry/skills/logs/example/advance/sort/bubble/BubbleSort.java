package industry.skills.logs.example.advance.sort.bubble;

import industry.skills.logs.example.advance.sort.SortCollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BubbleSort implements SortCollection {

    @Override
    public <E extends Comparable<E>> Collection<E> sortACollection(Collection<E> input) {
        List<E> result = new ArrayList<>(input);

        for(int j = 0 ; j < result.size() ; j++){
            for(int i = j+1 ; i < result.size() ; i++){
                if((result.get(i)).compareTo(result.get(j))<0){
                    E t = result.get(j);
                    result.set(j, result.get(i));
                    result.set(i, t);
                }
            }
        }

        return result;
    }
}
