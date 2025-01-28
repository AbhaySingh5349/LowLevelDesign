package Questions.CronParserSystem.Sol1;

/*
5 fields in expression:
i) minute, hour, day of month, month & day of week
ii) each filed can have specific value:
    ('-') represents range
    (',') represents list
    ('*') represents "every possible value"

iii) calculate next execution time from given time-stamp
*/

//input: */15 0 1,15 * 1-5 /usr/bin/find

/*
minute: 0, 15, 30, 45
hour: 0
day of month: 1, 15
month: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12
day of week: 1, 2, 3, 4, 5
command: /usr/bin/find
*/

import Questions.CronParserSystem.Sol1.enums.ComponentType;
import Questions.CronParserSystem.Sol1.model.CronExpression;
import Questions.CronParserSystem.Sol1.service.ParserService;
import Questions.CronParserSystem.Sol1.strategy.parser.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        NumericExpressionParser numericExpressionParser = new NumericExpressionParser();
        StringExpressionParser stringExpressionParser = new StringExpressionParser();
        AsteriskExpressionParser asteriskExpressionParser = new AsteriskExpressionParser();
        CommaExpressionParser commaExpressionParser = new CommaExpressionParser();
        HyphenExpressionParser hyphenExpressionParser = new HyphenExpressionParser();

        List<IExpressionParser> parsers = Arrays.asList(asteriskExpressionParser, commaExpressionParser, hyphenExpressionParser, numericExpressionParser, stringExpressionParser);

        Map<Integer, ComponentType> componentTypeMap = new HashMap<>();
        componentTypeMap.put(0, ComponentType.MINUTE);
        componentTypeMap.put(1, ComponentType.HOUR);
        componentTypeMap.put(2, ComponentType.DAY_OF_MONTH);
        componentTypeMap.put(3, ComponentType.MONTH);
        componentTypeMap.put(4, ComponentType.DAY_OF_WEEK);
        componentTypeMap.put(5, ComponentType.COMMAND);

        ParserService parserService = new ParserService(parsers, componentTypeMap);
        CronExpression cronExpression = parserService.parse("*/15 0 1,15 * 1-5 /usr/bin/find");

        System.out.println("\n--------------Parsed Cron Expression--------------\n");
        cronExpression.displayCronExpression();
    }
}
