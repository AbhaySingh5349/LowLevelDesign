package Questions.CronParserSystem.Sol2.strategy.validations;

import Questions.CronParserSystem.Sol2.enums.ComponentType;
import Questions.CronParserSystem.Sol2.exceptions.InvalidExpressionException;
import Questions.CronParserSystem.Sol2.strategy.data.CommandComponentDataDetails;
import Questions.CronParserSystem.Sol2.strategy.data.IComponentDataDetails;
import Questions.CronParserSystem.Sol2.utils.Constants;

public class CommandComponentDataValidation implements IComponentDataValidation{
    @Override
    public boolean doesSupport(IComponentDataDetails details) {
        return details.doesSupport(ComponentType.COMMAND);
    }

    @Override
    public boolean validate(IComponentDataDetails details) {
        CommandComponentDataDetails commandComponentDataDetails = (CommandComponentDataDetails) details;

        String command = commandComponentDataDetails.getCommand();

        if (!Constants.VALID_COMMANDS.contains(command)) {
            throw new InvalidExpressionException("Invalid command: " + command);
        }
        return true;
    }
}
