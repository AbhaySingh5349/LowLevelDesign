package Questions.CronParserSystem.strategy.parser;

import Questions.CronParserSystem.enums.ComponentType;
import Questions.CronParserSystem.strategy.data.IComponentDataDetails;
import Questions.CronParserSystem.strategy.data.TimeRangeComponentDataDetails;

import java.util.ArrayList;

public class HyphenExpressionParser implements IExpressionParser {
    @Override
    public boolean doesSupport(String expression) {
        return expression.contains("-");
    }

    @Override
    public IComponentDataDetails parse(ComponentType type, String expression) {
        final String[] parts = expression.split("-");

        final int start = Integer.parseInt(parts[0]);
        final int end = Integer.parseInt(parts[1]);

        final ArrayList<Integer> values = new ArrayList<>();
        for(int val=start;val<=end;val++){
            values.add(val);
        }

        return new TimeRangeComponentDataDetails(values);
    }
}
