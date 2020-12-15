package generics;

import generics.cars.Car;
import generics.cars.TurboTransmissionCar;

import java.util.Collection;

/*    - В отдельном классе создать метод, которые будут принимать коллекции, элементами которой могут быть классы,
          которые содержат данные о машине (т.е. как минимум предыдущие три класса) (extends)
      - Создать метод, который принимает коллекцию, элементы которой могут быть только Car и созданный ранее класс с трансмиссией. (super)
   */
public class CollectionForCars {

    // Возвращаем машину раннего года выпуска
    public static Car youngCar(Collection<? extends Car> collection) {
        Car yangCar = null;
        int year = 0;
        for (Car c : collection) {
            if (c != null && c.getYear() > year) {
                year = c.getYear();
                yangCar = c;
            }
        }
        return yangCar;
    }


    public static Car olderCar(Collection<? super TurboTransmissionCar> collection) {
        Car olderCar = null;
        int year = 9999;
        for (Object c : collection) {
            if (c instanceof Car) {
                if (((Car) c).getYear() < year) {
                    year = ((Car) c).getYear();
                    olderCar = (Car) c;
                }
            }
        }
        return olderCar;
    }
}
