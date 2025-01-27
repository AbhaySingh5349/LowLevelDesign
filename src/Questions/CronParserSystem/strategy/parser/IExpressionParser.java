package Questions.CronParserSystem.strategy.parser;

import Questions.CronParserSystem.enums.ComponentType;
import Questions.CronParserSystem.strategy.data.IComponentDataDetails;

public interface IExpressionParser {
    boolean doesSupport(String expression);
    IComponentDataDetails parse(ComponentType type, String expression);
}
