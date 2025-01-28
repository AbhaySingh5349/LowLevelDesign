package Questions.CronParserSystem.Sol2.strategy.validations;

import Questions.CronParserSystem.Sol2.enums.ComponentType;
import Questions.CronParserSystem.Sol2.strategy.data.IComponentDataDetails;

public interface IComponentDataValidation {
    boolean doesSupport(IComponentDataDetails details);
    boolean validate(IComponentDataDetails details);
}
