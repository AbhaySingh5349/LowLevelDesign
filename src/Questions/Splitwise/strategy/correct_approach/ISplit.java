package Questions.Splitwise.strategy.correct_approach;

import Questions.Splitwise.enums.SplitType;
import Questions.Splitwise.model.Expense;

import java.util.List;

public interface ISplit {
    boolean doesSupport(SplitType splitType);
    Expense support(List<String> commandParams);
}
