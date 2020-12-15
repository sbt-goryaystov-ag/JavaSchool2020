package generics.methods;

import java.util.Collection;

public interface Imethods<T> {
    T max(Collection<T> collection);

    int middle(Collection<T> collection);

    Collection<T> sort(Collection<T> collection);

    void add(Collection<T> collection, T car);
}
