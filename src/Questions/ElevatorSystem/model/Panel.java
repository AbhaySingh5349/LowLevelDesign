package Questions.ElevatorSystem.model;


import Questions.ElevatorSystem.model.button.Button;

import java.util.List;

public class Panel {
    private final List<Button> buttons;

    public Panel(List<Button> buttons) {
        this.buttons = buttons;
    }

    public void pressButton(int index) {
        if (index >= 0 && index < buttons.size()) {
            buttons.get(index).press();
        }
    }
}
