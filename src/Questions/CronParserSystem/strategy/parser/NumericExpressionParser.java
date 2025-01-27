package Questions.CronParserSystem.strategy.parser;

import Questions.CronParserSystem.enums.ComponentType;
import Questions.CronParserSystem.strategy.data.IComponentDataDetails;
import Questions.CronParserSystem.strategy.data.TimeRangeComponentDataDetails;

import java.util.ArrayList;
import java.util.Arrays;
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
