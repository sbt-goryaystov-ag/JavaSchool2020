package Shell;

import Shell.command.Date;
import Shell.command.Exit;
import Shell.command.Time;
import Shell.iface.Command;

import java.util.Scanner;

/*
Реализовать программу консольную оболочку Shell
1) Программа предоставляет набор команд. Команды вводятся с консоли. time, date, exit.
2) Каждая команда реализуется классом имплементирующим интерфейс Command.
3) Интерфейс должен описывать методы для получения имени и исполнения команды.

4) Для чтения с консоли пользуемся классом Scanner:
Scanner in = new Scanner(System.in);
•	nextLine(): считывает всю введенную строку

5) Для работы с датой/временем исследуем класс LocalDateTime:
https://docs.oracle.com/javase/8/docs/api/java/time/LocalDateTime.html

6) Интерфейс Command может определять вызов двух методов:
getName() – возвращает имя команды.
execute()  - выполнение команды.
На старте в программе инициализируется массив с набором команд, которые может исполнять программа Shell.
 */

public class Shall {
    public static void main(String[] args) {

        Command[] commands = new Command[]{new Time(), new Date(), new Exit()};
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Input command:");
            String cmd = in.nextLine();
            switch (cmd.toLowerCase()) {
                case "date":
                    doCommand(commands, "date");
                    break;
                case "time":
                    doCommand(commands, "time");
                    break;
                case "exit":
                    doCommand(commands, "exit");
                    break;
                default:
                    System.out.println("Wrong command! Only this: date, time, exit");
                    break;
            }
        }
    }

    public static void doCommand(Command[] commands, String cmd) {
        for (Command command : commands) {
            if (command.getName().equalsIgnoreCase(cmd)) {
                command.execute();
                break;
            }
        }
    }
}
