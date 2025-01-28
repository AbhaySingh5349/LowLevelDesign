package Questions.CronParserSystem.Sol1.model;

import Questions.CronParserSystem.Sol1.enums.ComponentType;
import Questions.CronParserSystem.Sol1.strategy.data.IComponentDataDetails;

public class Component {
    private final ComponentType type;
    private final IComponentDataDetails data;

    public Component(ComponentType type, IComponentDataDetails data) {
        this.type = type;
        this.data = data;
    }

    public ComponentType getType() {
        return type;
    }

    public IComponentDataDetails getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Component{" +
                "type=" + type +
                ", data=" + data +
                '}';
    }
}
