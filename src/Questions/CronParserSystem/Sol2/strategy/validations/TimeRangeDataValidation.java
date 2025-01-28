package Questions.CronParserSystem.Sol2.strategy.validations;

import Questions.CronParserSystem.Sol2.enums.ComponentType;
import Questions.CronParserSystem.Sol2.exceptions.InvalidExpressionException;
import Questions.CronParserSystem.Sol2.strategy.data.IComponentDataDetails;
import Questions.CronParserSystem.Sol2.strategy.data.TimeRangeComponentDataDetails;
import Questions.CronParserSystem.Sol2.utils.Constants;

import java.util.List;

public class TimeRangeDataValidation implements IComponentDataValidation{
    @Override
    public boolean doesSupport(IComponentDataDetails details) {
        return details.doesSupport(ComponentType.MINUTE) ||
                details.doesSupport(ComponentType.HOUR) ||
                details.doesSupport(ComponentType.DAY_OF_MONTH) ||
                details.doesSupport(ComponentType.MONTH) ||
                details.doesSupport(ComponentType.DAY_OF_WEEK);
    }

    @Override
    public boolean validate(IComponentDataDetails details) {
        TimeRangeComponentDataDetails timeRangeComponentDataDetails = (TimeRangeComponentDataDetails) details;

        List<Integer> rangeValues = timeRangeComponentDataDetails.getRangeValues();
        ComponentType type = timeRangeComponentDataDetails.getType();

        int[] range = Constants.VALID_RANGES.get(type);
        for (int value : rangeValues) {
            if (value < range[0] || value > range[1]) {
                throw new Questions.CronParserSystem.Sol1.exceptions.InvalidExpressionException(
                        "Value " + value + " is out of range for " + type + " (Allowed: " + range[0] + "-" + range[1] + ")"
                );
            }
        }

        return false;
    }
}
