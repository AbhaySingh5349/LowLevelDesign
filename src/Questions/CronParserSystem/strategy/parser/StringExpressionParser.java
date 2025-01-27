package Questions.CronParserSystem.strategy.parser;

import Questions.CronParserSystem.enums.ComponentType;
import Questions.CronParserSystem.strategy.data.CommandComponentDataDetails;
import Questions.CronParserSystem.strategy.data.IComponentDataDetails;

public class StringExpressionParser implements IExpressionParser{
    @Override
    public boolean doesSupport(String expression) {
        try {
            Integer.parseInt(expression);
            return false;
        } catch (NumberFormatException e) {
            if(expression.contains("*") || expression.contains(",") || expression.contains("-")){
                return false;
            }
        }
        return true;
    }

    @Override
    public IComponentDataDetails parse(ComponentType type, String expression) {
        return new CommandComponentDataDetails(expression);
    }
}
