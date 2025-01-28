package Questions.CronParserSystem.Sol2.strategy.parser;

import Questions.CronParserSystem.Sol2.enums.ComponentType;
import Questions.CronParserSystem.Sol2.strategy.data.IComponentDataDetails;

public interface IExpressionParser {
    boolean doesSupport(String expression);
    IComponentDataDetails parse(ComponentType type, String expression);
}
