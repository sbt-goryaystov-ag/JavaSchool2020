public class Task5 {
    /* 5. Напишите программу, которая объявляет массив целых чисел (10-20 чисел)
    и реализует алгоритм сортировки заданного массива (на ваш выбор). */
    public static void main(String[] args) {

        boolean flag;
        int[] m = new int[20];
        System.out.println("Rand mass:");
        for (int i = 0; i < m.length; i++) {
            m[i] = (int) (Math.random() * 100);
            System.out.println("m[" + i + "] = " + m[i]);
        }

        do {
            flag = false;
            for (int i = 0; i < m.length - 1; i++) {
                if (m[i] > m[i + 1]) {
                    flag = true;
                    int tmp = m[i];
                    m[i] = m[i + 1];
                    m[i + 1] = tmp;
                }
            }
        }
        while (flag);

        System.out.println("-------------------------------------------");
        System.out.println("Sort mass asc:");
        for (int i = 0; i < m.length; i++) {
            System.out.println("m[" + i + "] = " + m[i]);
        }
    }
}
