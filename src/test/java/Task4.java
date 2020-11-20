import java.util.Scanner;

public class Task4 {
    /* 4. Выведите на экран первые n членов последовательности Фибоначчи,
    где n запрашивается у пользователя посредством консоли (2 < n < 100). */
    public static void main(String[] args) {

        int n;
        long previous = 1;
        long current = 2;
        long next;
        Scanner in = new Scanner(System.in);
        do {
            System.out.print("Input n (2 < n < 100): ");
            n = in.nextInt();
        }
        while (n < 2 || n > 100);
        in.close();
        System.out.print("Fibonacci sequence: 1, 1, 2, ");
        for (int i = 4; i <= n; i++) {
            next = previous + current;
            System.out.print(next + ", ");
            previous = current;
            current = next;
        }
    }
}
