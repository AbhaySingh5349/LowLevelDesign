package Questions.CronParserSystem.Sol2.service;

import Questions.CronParserSystem.Sol2.enums.ComponentType;
import Questions.CronParserSystem.Sol2.exceptions.InvalidExpressionException;
import Questions.CronParserSystem.Sol2.model.Component;
import Questions.CronParserSystem.Sol2.strategy.data.CommandComponentDataDetails;
import Questions.CronParserSystem.Sol2.strategy.data.IComponentDataDetails;
import Questions.CronParserSystem.Sol2.strategy.data.TimeRangeComponentDataDetails;
import Questions.CronParserSystem.Sol2.strategy.validations.IComponentDataValidation;
import Questions.CronParserSystem.Sol2.utils.Constants;

import java.util.List;

public class ValidationService {
    private final List<IComponentDataValidation> validators;

    public ValidationService(List<IComponentDataValidation> validators) {
        this.validators = validators;
    }

    public void validateComponent(IComponentDataDetails details) throws InvalidExpressionException {
        for (IComponentDataValidation validator : validators) {
            if (validator.doesSupport(details)) {
                validator.validate(details);
            }

//            if (component.getData() instanceof IntegerListComponentData data) {
//                validator.validateAll(component.getType(), data.getValues());
//            } else if (component.getData() instanceof StringComponentData data) {
//                validator.validate(component.getType(), data.getValue());
//            }
        }
    }
}
