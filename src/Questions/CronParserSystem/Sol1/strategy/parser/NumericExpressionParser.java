package Questions.CronParserSystem.Sol1.strategy.parser;

import Questions.CronParserSystem.Sol1.enums.ComponentType;
import Questions.CronParserSystem.Sol1.strategy.data.IComponentDataDetails;
import Questions.CronParserSystem.Sol1.strategy.data.TimeRangeComponentDataDetails;

import java.util.List;

public class NumericExpressionParser implements IExpressionParser{
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
        return new TimeRangeComponentDataDetails(List.of(Integer.parseInt(expression)));
    }
}
