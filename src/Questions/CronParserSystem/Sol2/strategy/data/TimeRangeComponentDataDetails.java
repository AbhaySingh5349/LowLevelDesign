package Questions.CronParserSystem.Sol2.strategy.data;

import Questions.CronParserSystem.Sol2.enums.ComponentType;

import java.util.List;

public class TimeRangeComponentDataDetails implements IComponentDataDetails {
    private final ComponentType type;
    private final List<Integer> rangeValues;

    public TimeRangeComponentDataDetails(ComponentType type, List<Integer> rangeValues) {
        this.type = type;
        this.rangeValues = rangeValues;
    }

    public ComponentType getType() {
        return type;
    }

    public List<Integer> getRangeValues() {
        return rangeValues;
    }

    @Override
    public boolean doesSupport(ComponentType type) {
        return type.equals(ComponentType.TIME_RANGE);
    }

    @Override
    public String toString() {
        return "TimeRangeComponentDataDetails{" +
                "type=" + type +
                ", rangeValues=" + rangeValues +
                '}';
    }
}
