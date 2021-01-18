package generics;


import generics.cars.Car;
import generics.cars.CarWithPrice;
import generics.cars.TurboTransmissionCar;
import generics.methods.CarImpl;
import generics.methods.CarWithPriceImpl;
import generics.methods.Imethods;

import java.util.*;

/*
1.	Создать класс Client, у которого будет поле имя. Создать класса Client, в котором должны быть все поля и свойства Client, а так же реализован идентификатор клиента. На основе класса с идентификатором создать потомка с реализацией сколько потратил.  В отдельном классе создать метод, которые будут принимать коллекции, элементами которой могут быть классы, которые содержат данные о клиенте (т.е. как минимум предыдущие три класса).  Создать метод, который принимает коллекцию, элементы которой могут быть только Client и созданный ранее класс с идентификатором.
(Классы Cars и CollectionForCars)
2.	Создать интерфейс или класс с обобщенным(и) типом(типами) - имя придумать самостоятельно.
3.	Добавить методы в интерфейс. Например, max, sort, middle и т.д., которые будут принимать коллекцию с обобщенным типом интерфейса..
4.	Имплементировать интерфейс - создать несколько классов, которые реализуют методы интерфейса. Один ищет клиента с максимальным количеством букв в имени, и сортирует в выбранном вами порядке по имени и т.д. Другой ищет, кто больше всех потратил, сортирует, ищет среднее потраченное всеми клиентами и т.д. В отдельном классе вызвать реализованные методы с выводом результата.
5.	Переписать код из предыдущего урока, так что бы все реализации вычислений - среднего, максимального и т.д. были реализованы в обобщенных классах. Должен быть единый интерфейс, но при этом, для каждого вычисления отдельный класс. В отдельном классе вызвать реализованные методы с выводом результата.

Не обязательно создавать именно класс Client, и не обязательно именно методы max, sort, middle. Если будет своя тематика объектов - приветствуется.

 */

public class Main {
    private static Map<String, List<String>> markModel = new HashMap<>();
    private static List<String> modelBmw = new ArrayList<>();
    private static List<String> modelAudi = new ArrayList<>();
    private static List<String> modelKia = new ArrayList<>();

    static {
        modelBmw.add("X1");
        modelBmw.add("X3");
        modelBmw.add("X5");
        modelBmw.add("X6");

        modelAudi.add("Q3");
        modelAudi.add("Q5");
        modelAudi.add("Q6");
        modelAudi.add("Q8");

        modelKia.add("Rio");
        modelKia.add("Sorento");
        modelKia.add("Seltos");
        modelKia.add("K5");

        markModel.put("BMW", modelBmw);
        markModel.put("Audi", modelAudi);
        markModel.put("Kia", modelKia);
    }


    public static List<Car> randomListCar(int n) {
        List<Car> carList = new ArrayList<>();
        List<String> marks = Arrays.asList("BMW", "Audi", "Kia");
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            String randMark = marks.get(random.nextInt(marks.size()));
            String randModel = markModel.get(randMark).get(random.nextInt(markModel.get(randMark).size()));
            carList.add(new Car(randMark, randModel, random.nextInt(30) + 1990));
        }
        return carList;
    }

    public static List<CarWithPrice> randomListCarWithPrice(int n) {
        List<CarWithPrice> carList = new ArrayList<>();
        List<String> marks = Arrays.asList("BMW", "Audi", "Kia");
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            String randMark = marks.get(random.nextInt(marks.size()));
            String randModel = markModel.get(randMark).get(random.nextInt(markModel.get(randMark).size()));
            carList.add(new CarWithPrice(randMark, randModel, random.nextInt(30) + 1990, random.nextInt(30) > 16 ? true : false, 1 == random.nextInt(2) ? TurboTransmissionCar.Transmission.MANUAL : TurboTransmissionCar.Transmission.AUTO, random.nextInt(1000000) + 600000));
        }
        return carList;
    }

    public static void main(String[] args) {

        // 1 задание
        List<Car> list = randomListCar(7);
        list.add(new TurboTransmissionCar("Lexus", "LX", 2000, true, TurboTransmissionCar.Transmission.AUTO));
        list.add(new TurboTransmissionCar("Mercedes", "gla", 2005, false, TurboTransmissionCar.Transmission.MANUAL));
        list.add(new TurboTransmissionCar("Audi", "A5", 2006, true, TurboTransmissionCar.Transmission.AUTO));
        System.out.println("List cars ---------------------------------------------------------------");
        System.out.println(list);

        Car olderCar = CollectionForCars.olderCar(list);
        System.out.println("Older car---------------------------------------------------------------");
        System.out.println(olderCar);

        Car youngCar = CollectionForCars.youngCar(list);
        System.out.println("Young car---------------------------------------------------------------");
        System.out.println(youngCar);

        // 4 - 5 задания
        Imethods<Car> imethods = new CarImpl();
        Car maxCar = imethods.max(list);
        System.out.println("Method max---------------------------------------------------------------");
        System.out.println(maxCar);

        int middle = imethods.middle(list);
        System.out.println("Method middle---------------------------------------------------------------");
        System.out.println(middle);

        List<Car> cars = (List<Car>) imethods.sort(list);
        System.out.println("Method sort---------------------------------------------------------------");
        System.out.println(cars);

        imethods.add(list, new Car("Volvo", "CX90", 2017));
        System.out.println("Method add---------------------------------------------------------------");
        System.out.println(list);

        List<CarWithPrice> carWithPriceList = randomListCarWithPrice(7);
        System.out.println("List cars ---------------------------------------------------------------");
        System.out.println(carWithPriceList);

        Imethods<CarWithPrice> imethods2 = new CarWithPriceImpl();
        CarWithPrice maxCarWithPrice = imethods2.max(carWithPriceList);
        System.out.println("Method max---------------------------------------------------------------");
        System.out.println(maxCarWithPrice);

        int middlePrice = imethods2.middle(carWithPriceList);
        System.out.println("Method middle---------------------------------------------------------------");
        System.out.println(middlePrice);

        List<CarWithPrice> carWithPrices = (List<CarWithPrice>) imethods2.sort(carWithPriceList);
        System.out.println("Method sort---------------------------------------------------------------");
        System.out.println(carWithPrices);
    }
}