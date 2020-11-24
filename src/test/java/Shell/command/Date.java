package Shell.command;

import Shell.iface.Command;

import java.time.LocalDate;

public class Date implements Command {
    private String name = "date";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void execute() {
        System.out.println("Date: " + LocalDate.now());
    }
}
