package exception.methods;

import exception.cars.Car;

import java.util.Collection;

public interface Imethods<T extends Car> {
    T max(Collection<T> collection);

    int middle(Collection<T> collection);

    Collection<T> sort(Collection<T> collection);

    void add(Collection<T> collection, T car);
}
