package Questions.CronParserSystem.strategy.data;

import Questions.CronParserSystem.enums.ComponentType;

public class CommandComponentDataDetails  implements IComponentDataDetails{
    private final ComponentType type;
    private final String value;

    public CommandComponentDataDetails(ComponentType type, String value) {
        this.type = type;
        this.value = value;
    }

    public ComponentType getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "CommandComponentDataDetails{" +
                "type=" + type +
                ", value='" + value + '\'' +
                '}';
    }
}
