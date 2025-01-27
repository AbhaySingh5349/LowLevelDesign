package Questions.CronParserSystem.strategy.data;

import java.util.List;

public class TimeRangeComponentDataDetails implements IComponentDataDetails{
    private final List<Integer> values;

    public TimeRangeComponentDataDetails(List<Integer> values) {
        this.values = values;
    }

    public List<Integer> getValues() {
        return values;
    }

    @Override
    public String toString() {
        return "TimeRangeComponentDataDetails{" +
                "values=" + values +
                '}';
    }
}
