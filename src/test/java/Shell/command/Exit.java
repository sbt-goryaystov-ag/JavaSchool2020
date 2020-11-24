package Shell.command;

import Shell.iface.Command;

import java.time.LocalTime;

public class Exit implements Command {
    private String name = "exit";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void execute() {
        System.out.println("Input exit");
        System.exit(0);
    }
}
