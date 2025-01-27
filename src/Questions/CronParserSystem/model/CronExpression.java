package Questions.CronParserSystem.model;

import java.util.List;

public class CronExpression {
    private List<Component> components;

    @Override
    public String toString() {
        return "CronExpression{" +
                "components=" + components +
                '}';
    }

    public CronExpression(List<Component> components) {
        this.components = components;
    }

    public void displayCronExpression(){
        for(Component component : components){
            System.out.println(component.getType().toString() + " -> " + component.getData());
        }
    }
}
