package Questions.CronParserSystem.Sol1.service;

import Questions.CronParserSystem.Sol1.enums.ComponentType;
import Questions.CronParserSystem.Sol1.exceptions.InvalidExpressionException;
import Questions.CronParserSystem.Sol1.model.Component;
import Questions.CronParserSystem.Sol1.strategy.data.IComponentDataDetails;
import Questions.CronParserSystem.Sol1.strategy.data.TimeRangeComponentDataDetails;
import Questions.CronParserSystem.Sol1.strategy.data.CommandComponentDataDetails;
import Questions.CronParserSystem.Sol1.utils.Constants;

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
