package Questions.LibraryManagementSystem.service;

import Questions.LibraryManagementSystem.model.book.BookItem;
import Questions.LibraryManagementSystem.model.user.Member;

import java.util.Date;

public class FineManager {
    public double calculateFine(BookItem bookItem, Member member){
        Date now = new Date();
        long diffMillis = Math.abs(now.getTime() - bookItem.getIssueDate().getTime());
        int daysOverdue = (int) (diffMillis / (1000 * 60 * 60 * 24)) - member.getDaysToHoldBook();

        return daysOverdue > 0 ? bookItem.getBookType().getPerDayFine() * daysOverdue : 0;
    }
}
