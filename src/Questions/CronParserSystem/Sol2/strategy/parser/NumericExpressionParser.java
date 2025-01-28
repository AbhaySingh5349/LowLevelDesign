package Questions.CronParserSystem.Sol2.strategy.parser;

import Questions.CronParserSystem.Sol2.enums.ComponentType;
import Questions.CronParserSystem.Sol2.strategy.data.IComponentDataDetails;
import Questions.CronParserSystem.Sol2.strategy.data.TimeRangeComponentDataDetails;

import java.util.List;

public class NumericExpressionParser implements IExpressionParser {
    @Override
    public boolean doesSupport(String expression) {
        if (expression == null || expression.isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(expression);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public IComponentDataDetails parse(ComponentType type, String expression) {
        return new TimeRangeComponentDataDetails(type, List.of(Integer.parseInt(expression)));
    }
}
