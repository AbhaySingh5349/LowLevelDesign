package Questions.CronParserSystem.Sol2.strategy.data;

import Questions.CronParserSystem.Sol2.enums.ComponentType;

public class CommandComponentDataDetails  implements IComponentDataDetails {
    private final String command;

    public CommandComponentDataDetails(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    @Override
    public boolean doesSupport(ComponentType type) {
        return type.equals(ComponentType.COMMAND);
    }

    @Override
    public String toString() {
        return "CommandComponentDataDetails{" +
                "command='" + command + '\'' +
                '}';
    }
}
