package generics.methods;

import generics.cars.CarWithPrice;

import java.util.*;

public class CarWithPriceImpl implements Imethods<CarWithPrice> {

    @Override
    // Возвращает машину с максимальной стоимостью
    public CarWithPrice max(Collection<CarWithPrice> collection) {
        double maxPrice = 0;
        CarWithPrice carWithPrice = null;
        for (CarWithPrice car : collection) {
            if (car != null && car.getPrice() > maxPrice) {
                carWithPrice = car;
                maxPrice = car.getPrice();
            }
        }
        return carWithPrice;
    }

    @Override
    // Возвращает среднюю цену авто из списка
    public int middle(Collection<CarWithPrice> collection) {
        int middlePrice = 0;
        for (CarWithPrice c : collection) {
            if (c != null) {
                middlePrice += c.getPrice();
            }
        }
        middlePrice /= collection.size();
        return middlePrice;
    }

    @Override
    // Сортируем по сумме
    public Collection<CarWithPrice> sort(Collection<CarWithPrice> collection) {
        List<CarWithPrice> list = new ArrayList<>(collection);
        Collections.sort(list, (c1, c2) -> {
            if (c1 != null && c2 != null) {
                return Double.compare(c1.getPrice(), c2.getPrice());
            } else if (c1 == null && c2 == null) {
                return 0;
            } else if (c2 == null) {
                return 1;
            } else {
                return -1;
            }
        });
        return list;
    }

    @Override
    public void add(Collection<CarWithPrice> collection, CarWithPrice car) {
        if (car != null) {
            collection.add(car);
        }
    }
}
