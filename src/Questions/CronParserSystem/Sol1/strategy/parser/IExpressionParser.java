package Questions.CronParserSystem.Sol1.strategy.parser;

import Questions.CronParserSystem.Sol1.enums.ComponentType;
import Questions.CronParserSystem.Sol1.strategy.data.IComponentDataDetails;

public interface IExpressionParser {
    boolean doesSupport(String expression);
    IComponentDataDetails parse(ComponentType type, String expression);
}
