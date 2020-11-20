public class Task3 {
    /* 3. Напишите программу, которая вычислит простые числа в пределах от 2 до 100. */
    public static void main(String[] args) {

        System.out.println("Prime numbers from 2 to 100:");
        System.out.print("2,");
        for (int i = 3; i <= 100; i += 2) {
            boolean flag = false;
            for (int j = 3; j <= i/2; j += 2) {
                if (i % j == 0) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                continue;
            }
            System.out.print(i + ",");
        }
    }
}
