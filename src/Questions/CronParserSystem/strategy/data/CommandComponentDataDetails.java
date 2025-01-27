package Questions.CronParserSystem.strategy.data;

import Questions.CronParserSystem.enums.ComponentType;

public class CommandComponentDataDetails  implements IComponentDataDetails{
    private final String value;

    public CommandComponentDataDetails(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "CommandComponentDataDetails{" +
                "value='" + value + '\'' +
                '}';
    }
}
