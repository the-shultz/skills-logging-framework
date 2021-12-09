package industry.skills.logs.example.advance.creator;


import industry.skills.logs.example.advance.creator.number.NumberCollectionCreator;
import industry.skills.logs.example.advance.creator.string.StringCollectionCreator;

import java.util.Collection;

public interface CollectionCreator<T> {
    Collection<T> create(int total);

    static <E> CollectionCreator<E> get(Class<E> type) {

        if (type == Integer.class)
            return (CollectionCreator<E>) new NumberCollectionCreator();

        if (type == String.class) {
            return (CollectionCreator<E>) new StringCollectionCreator();
        }

        throw new UnsupportedOperationException("Can't create collection creator for type: " + type.getSimpleName());
    }
}
