package Shell.command;

import Shell.iface.Command;

import java.time.LocalTime;

public class Time implements Command {
    private String name = "time";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void execute() {
        System.out.println("Time: " + LocalTime.now());
    }
}
