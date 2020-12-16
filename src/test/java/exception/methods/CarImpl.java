package exception.methods;

import exception.cars.Car;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CarImpl implements Imethods<Car> {

    @Override
    // Возвращает машину с самым длинным наименованием модели и ранним годом выпуска
    public Car max(Collection<Car> collection) {
        int maxMark = 0;
        int year = 0;
        Car car = null;
        for (Car c : collection) {
            if (c != null && c.getMark().length() >= maxMark && c.getYear() > year) {
                car = c;
                maxMark = c.getMark().length();
                year = c.getYear();
            }
        }
        return car;
    }

    @Override
    // Возвращает средний год машин из списка
    public int middle(Collection<Car> collection) {
        int middleYear = 0;
        for (Car c : collection) {
            if (c != null) {
                middleYear += c.getYear();
            }
        }
        middleYear /= collection.size();
        return middleYear;
    }

    @Override
    public Collection<Car> sort(Collection<Car> collection) {
        if (collection != null && !collection.isEmpty()) {
            List<Car> cars = new ArrayList<>(collection);
            Collections.sort(cars);
            return cars;
        }
        return null;
    }

    @Override
    public void add(Collection<Car> collection, Car car) {
        if (car != null) {
            collection.add(car);
        }
    }
}
