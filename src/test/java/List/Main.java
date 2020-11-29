package List;

public class Main {
    public static void main(String[] args) {
        List list = new List();
        list.add("rr");
        list.add("qq");
        System.out.println("size = " + list.size());
        list.add("ss");
        list.add(1);
        list.get(-2);
        list.get(5);
        System.out.println(list.get(1));
        System.out.println(list.get(4));
        System.out.println(list);

    }
}
