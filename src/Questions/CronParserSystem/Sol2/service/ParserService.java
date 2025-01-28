package Questions.CronParserSystem.Sol2.service;

import Questions.CronParserSystem.Sol2.enums.ComponentType;
import Questions.CronParserSystem.Sol2.exceptions.InvalidExpressionException;
import Questions.CronParserSystem.Sol2.model.Component;
import Questions.CronParserSystem.Sol2.model.CronExpression;
import Questions.CronParserSystem.Sol2.strategy.data.IComponentDataDetails;
import Questions.CronParserSystem.Sol2.strategy.parser.IExpressionParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParserService {
    private final List<IExpressionParser> parsers;
    private final Map<Integer, ComponentType> componentTypeMap;
    private final ValidationService validationService;

    public ParserService(List<IExpressionParser> parsers, Map<Integer, ComponentType> componentTypeMap, ValidationService validationService) {
        this.parsers = parsers;
        this.componentTypeMap = componentTypeMap;
        this.validationService = validationService;
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
                    validationService.validateComponent(componentData);

                    components.add(component);
                }
            }
        }

        return new CronExpression(components);
    }
}
