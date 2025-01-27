package Questions.CronParserSystem.strategy.data;

import Questions.CronParserSystem.enums.ComponentType;

import java.util.List;

public class TimeRangeComponentDataDetails implements IComponentDataDetails{
    private final ComponentType type;
    private final List<Integer> values;

    public TimeRangeComponentDataDetails(ComponentType type, List<Integer> values) {
        this.type = type;
        this.values = values;
    }

    public ComponentType getType() {
        return type;
    }

    public List<Integer> getValues() {
        return values;
    }

    @Override
    public String toString() {
        return "TimeRangeComponentDataDetails{" +
                "type=" + type +
                ", values=" + values +
                '}';
    }
}
