package Questions.CronParserSystem.Sol2.strategy.data;

import Questions.CronParserSystem.Sol2.enums.ComponentType;

public interface IComponentDataDetails {
    boolean doesSupport(ComponentType type);
}
