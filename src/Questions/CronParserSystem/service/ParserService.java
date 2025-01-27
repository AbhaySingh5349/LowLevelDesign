package Questions.CronParserSystem.service;

import Questions.CronParserSystem.enums.ComponentType;
import Questions.CronParserSystem.exceptions.InvalidExpressionException;
import Questions.CronParserSystem.model.Component;
import Questions.CronParserSystem.model.CronExpression;
import Questions.CronParserSystem.strategy.data.IComponentDataDetails;
import Questions.CronParserSystem.strategy.parser.IExpressionParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParserService {
    private final List<IExpressionParser> parsers;
    private final Map<Integer, ComponentType> componentTypeMap;

    public ParserService(List<IExpressionParser> parsers, Map<Integer, ComponentType> componentTypeMap) {
        this.parsers = parsers;
        this.componentTypeMap = componentTypeMap;
    }

    public CronExpression parse(String expression){
        String[] expressionComponents = expression.split(" ");

        if(expressionComponents.length != 6){
            throw new InvalidExpressionException("Invalid Input Expression");
        }

        List<Component> components = new ArrayList<>();
        for(int i=0;i<6;i++){
            String exp = expressionComponents[i];
            ComponentType type = componentTypeMap.get(i);

            System.out.println("############################################");
            System.out.println("type: " + type + " -> " + "expression: " + exp);

            for(IExpressionParser parser : parsers){
                if(parser.doesSupport(exp)){
                    System.out.println(parser.toString());

                    IComponentDataDetails componentData = parser.parse(type, exp);
                    Component component = new Component(type, componentData);

                    // Validate the parsed component
                    ValidationService.validateComponent(component);

                    components.add(component);
                }
            }
        }

        return new CronExpression(components);
    }
}
