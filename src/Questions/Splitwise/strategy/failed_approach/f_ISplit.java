package Questions.Splitwise.strategy.failed_approach;

import Questions.Splitwise.model.Expense;

public interface f_ISplit {
    boolean doesSupport(f_ISplitDetails details);
    Expense support(f_ISplitDetails details);
}
