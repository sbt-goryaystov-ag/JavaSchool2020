import java.util.Scanner;

public class Task2 {
    /* 2. В переменных a и b хранятся два натуральных числа. Напишите программу, выводящую на экран результат деления a на b с остатком.
       Пример работы программы (a = 21, b = 8): « 21 / 8 = 2 и 5 в остатке »*/
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        int a = in.nextInt();
        System.out.print("Input b number: ");
        int b = in.nextInt();
        in.close();
        float c = (float) a / b;
        System.out.println("Result of devision a on b: " + c);
    }
}
