package collections;


import java.util.*;

/*
1. Создать лист из своих объектов (10-15 элементов в списке). Добавить, удалить и т.д.
2. Добавить дубли в список (1 - несколько раз один и тот же объект, 2 - дубль должен быть новым объектом с теми же параметрами, что уже имеет один из существующих в списке)
3. Вывести список элементов в читабельном виде.
4. Создать неповторяющееся упорядоченное множество с использованием компаратора и перенести значения из созданного листа.
5. Обход дерева с помощью forEach и iterator (подсчет или конкатинация из объектов коллекции используя условие, например "все начинаются с буквы", "больше какого-то значения")
6. Удалить третий элемент из множества.
7. Из существующей коллекции объектов создать ассоциативную карту, где ключ - объект, а значение - коллекция
8. Из существующей карты создать другую, в которой ключ остается прежним, а значение - вычисленное значение чего-либо из коллекции для ключа (по нескольким вариантам значений)
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
            String randmark = marks.get(random.nextInt(marks.size()));
            String randModel = markModel.get(randmark).get(random.nextInt(markModel.get(randmark).size()));
            carList.add(new Car(randmark, randModel, random.nextInt(30) + 1990));
        }
        return carList;
    }

    public static void main(String[] args) {

        // 1 Создать лист из своих объектов (10-15 элементов в списке). Добавить, удалить и т.д.-------------------
        List<Car> list = randomListCar(12);
        list.remove(10);

        // 2. Добавить дубли в список (1 - несколько раз один и тот же объект, 2 - дубль должен быть новым объектом с теми же параметрами, что уже имеет один из существующих в списке)
        Car car = new Car("Audi", "A5", 2017);
        list.add(car);
        list.add(car);
        list.add(car);
        list.add(new Car("Audi", "A5", 2017));

        // 3. Вывести список элементов в читабельном виде.-------------------------------------------------------
        System.out.println("List:\n" + list + "\n---------------------------------------------");
        Collections.sort(list);
        System.out.println("Sort list:\n" + list + "\n---------------------------------------------");

        // 4. Создать неповторяющееся упорядоченное множество с использованием компаратора и перенести значения из созданного листа.
        Set<Car> set = new TreeSet<>();
        set.addAll(list);
        System.out.println("TreeSet:\n" + set + "\n---------------------------------------------");

        // 5. Обход дерева с помощью forEach и iterator (подсчет или конкатинация из объектов коллекции используя условие, например "все начинаются с буквы", "больше какого-то значения")
        // посчитаем кол-во seltos и sorento
        Iterator<Car> iterator = set.iterator();
        int cnt = 0;
        while (iterator.hasNext()) {
            if (iterator.next().getModel().startsWith("S")) {
                cnt += 1;
            }
        }
        System.out.println("Count Sorento or Seltos (Kia): " + cnt);

        // посчитаем кол-во машин после 2015 года
        cnt = 0;
        for (Car cars : set) {
            if (cars.getYear() > 2015) {
                cnt += 1;
            }
        }
        System.out.println("Count of cars after 2015 year: " + cnt);

        // 6. Удалить третий элемент из множества.
        iterator = set.iterator();
        cnt = 0;
        while (iterator.hasNext()) {
            iterator.next();
            cnt++;
            if (cnt == 3) {
                iterator.remove();
            }
        }
        System.out.println("TreeSet without 3th element:\n" + set + "\n---------------------------------------------");

        // 7. Из существующей коллекции объектов создать ассоциативную карту, где ключ - объект, а значение - коллекция
        // создал мапу из сета, вывел ключ - объект, значение - кол-во элементов
        Map<Car, Collection<Car>> map = new HashMap<>();
        for (Car c : set) {
            map.put(c, set);
        }
        map.forEach((k, v) -> System.out.println("Key: " + k + "Value: " + v.size() + "\n"));

        // 8. Из существующей карты создать другую, в которой ключ остается прежним, а значение - вычисленное значение чего-либо из коллекции для ключа (по нескольким вариантам значений)
        // кол-во машин, определенной марки с годом старше 2000
        Map<Car, Long> newMap = new HashMap<>();
        for (Map.Entry<Car, Collection<Car>> e : map.entrySet()) {
            newMap.put(e.getKey(), e.getValue()
                    .stream()
                    .filter(b -> b.getMark().equals(e.getKey().getMark()) && b.getYear() > 2000)
                    .count());
        }
        newMap.forEach((k, v) -> System.out.println("Key: " + k + "Value: " + v + "\n"));
    }
}