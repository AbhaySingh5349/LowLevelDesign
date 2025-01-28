package Questions.CronParserSystem.Sol1.strategy.parser;

import Questions.CronParserSystem.Sol1.enums.ComponentType;
import Questions.CronParserSystem.Sol1.exceptions.InvalidExpressionException;
import Questions.CronParserSystem.Sol1.strategy.data.IComponentDataDetails;
import Questions.CronParserSystem.Sol1.strategy.data.TimeRangeComponentDataDetails;
import Questions.CronParserSystem.Sol1.utils.Constants;

import java.util.ArrayList;

public class AsteriskExpressionParser implements IExpressionParser {
    @Override
    public boolean doesSupport(String expression) {
        return expression.contains("*");
    }

    @Override
    public IComponentDataDetails parse(ComponentType type, String expression) {
        if(type.equals(ComponentType.COMMAND)){
            throw new InvalidExpressionException("Multiple commands cannot be executed via *");
        }

        final ArrayList<Integer> values = new ArrayList<>();
        int[] range = Constants.VALID_RANGES.get(type);

        final int start = range[0];
        final int end = range[1];

        if(expression.contains("/")){
            String numericPart = expression.substring(expression.indexOf('/') + 1);
            int freq = Integer.parseInt(numericPart);
            for(int val=start;val<=end;val++){
                if(val % freq == 0){
                    values.add(val);
                }
            }
        }else{
            for(int val=start;val<=end;val++){
                values.add(val);
            }
        }

        return new TimeRangeComponentDataDetails(values);
    }
}
