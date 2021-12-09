package industry.skills.logs.example.advance.creator.number;

import industry.skills.logs.example.advance.creator.CollectionCreator;

import java.util.Collection;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberCollectionCreator implements CollectionCreator<Integer> {

    private Random r = new Random();

    @Override
    public Collection<Integer> create(int total) {
        return
                IntStream
                        .generate(() -> r.nextInt(100))
                        .limit(total)
                        .boxed()
                        .collect(Collectors.toList());
    }
}
