package exception;


import exception.cars.Car;
import exception.cars.CarWithPrice;
import exception.cars.TurboTransmissionCar;

import java.util.*;

/*
    1.	Создать свой класс исключение, наследник Exception
    2.	Реализовать два поля: code, description, инициализация в конструкторе
    1.	code целочисленное, при создании инициализировать любое произвольное число
    2.	description строка, предназначено для описания бизнес ошибки, при создании инициализировать либым значением,
    3.	В конструкторе реализовать вызов родительского конструктора с аргументом message, т.е. у вас один конструктор с тремя параметрами
    3.	В коде из предыдущего задания, на ваше усмотрение сдалть проверку и бросать исключение
    4.	В качестве обработки исключения вывести в System.out code, description, message, после вызвать printStackTrace
    5.	В одном из методов бросать unchecked исключение, например IllegalArgumentException
    6.	Запустить приложение с заведомо ошибочным алгоритмом, т.е. что бы при вызове метода, который бросает ваше исключение, было брошено и обработано, после вызов метода, который генерирует unchecked исключение, запустить программу
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
    

    public static List<CarWithPrice> randomListCarWithPrice(int n) throws MyException {
        List<CarWithPrice> carList = new ArrayList<>();
        List<String> marks = Arrays.asList("BMW", "Audi", "Kia");
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            String randMark = marks.get(random.nextInt(marks.size()));
            String randModel = markModel.get(randMark).get(random.nextInt(markModel.get(randMark).size()));
            carList.add(new CarWithPrice(randMark, randModel, random.nextInt(30) + 1990, random.nextInt(30) > 16, 1 == random.nextInt(2) ? TurboTransmissionCar.Transmission.MANUAL : TurboTransmissionCar.Transmission.AUTO, random.nextInt(1000000) + 600000));
        }
        if (carList.isEmpty()) {
            throw new MyException(0, "Пустая коллекция", "Видимо передали отрицательное значение на вход!");
        }
        return carList;
    }

    public static void main(String[] args) {
        List<CarWithPrice> carWithPriceList = new ArrayList<>();
        try {
            carWithPriceList = randomListCarWithPrice(-5);
        } catch (MyException e) {
            System.err.println("--------------------------------------------------");
            System.err.println(e.getClass().getName() + ": Message - " + e.getMessage());
            System.err.println(e.getClass().getName() + ": Code - " + e.getCode());
            System.err.println(e.getClass().getName() + ": Description - " + e.getDescription());
            e.printStackTrace();
            System.err.println("--------------------------------------------------");
        }

        carWithPriceList.add(null);
        TreeSet<CarWithPrice> treeSet = new TreeSet<>();
        try {
            treeSet.addAll(carWithPriceList);
        } catch (NullPointerException ex) {
            System.err.println(ex.getClass().getName() + ": Поймали NPE - " + ex.getMessage());
        }
    }
}