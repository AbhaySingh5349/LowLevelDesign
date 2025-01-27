package Questions.CronParserSystem.service;

import Questions.CronParserSystem.enums.ComponentType;
import Questions.CronParserSystem.exceptions.InvalidExpressionException;
import Questions.CronParserSystem.model.Component;
import Questions.CronParserSystem.strategy.data.IComponentDataDetails;
import Questions.CronParserSystem.strategy.data.TimeRangeComponentDataDetails;
import Questions.CronParserSystem.strategy.data.CommandComponentDataDetails;
import Questions.CronParserSystem.utils.Constants;

import java.util.List;

public class ValidationService {
    public static void validateComponent(Component component) {
        ComponentType type = component.getType();
        IComponentDataDetails data = component.getData();

        if (type == ComponentType.COMMAND) {
            validateCommand(((CommandComponentDataDetails) data).getValue());
        } else {
            validateNumericComponent(type, ((TimeRangeComponentDataDetails) data).getValues());
        }
    }

    private static void validateCommand(String command) {
        if (!Constants.VALID_COMMANDS.contains(command)) {
            throw new InvalidExpressionException("Invalid command: " + command);
        }
    }

    private static void validateNumericComponent(ComponentType type, List<Integer> values) {
        int[] range = Constants.VALID_RANGES.get(type);
        for (int value : values) {
            if (value < range[0] || value > range[1]) {
                throw new InvalidExpressionException(
                        "Value " + value + " is out of range for " + type + " (Allowed: " + range[0] + "-" + range[1] + ")"
                );
            }
        }
    }
}
