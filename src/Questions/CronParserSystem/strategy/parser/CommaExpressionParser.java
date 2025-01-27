package Questions.CronParserSystem.strategy.parser;

import Questions.CronParserSystem.enums.ComponentType;
import Questions.CronParserSystem.strategy.data.IComponentDataDetails;
import Questions.CronParserSystem.strategy.data.TimeRangeComponentDataDetails;

import java.util.ArrayList;

public class CommaExpressionParser implements IExpressionParser {
    @Override
    public boolean doesSupport(String expression) {
        return expression.contains(",");
    }

    @Override
    public IComponentDataDetails parse(ComponentType type, String expression) {
        final String[] parts = expression.split(",");

        final ArrayList<Integer> values = new ArrayList<>();
        for(String p : parts){
            values.add(Integer.parseInt(p));
        }

        return new TimeRangeComponentDataDetails(type, values);
    }
}
