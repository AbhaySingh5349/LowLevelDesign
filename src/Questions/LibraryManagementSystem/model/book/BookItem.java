package Questions.LibraryManagementSystem.model.book;

import Questions.LibraryManagementSystem.strategy.book.IBook;

import java.util.Date;

public class BookItem {
    private final String id;
    private final Book book;
    private final IBook bookType;
    private boolean isAvailable;
    private Date issueDate;

    public BookItem(String id, Book book, IBook bookType, boolean isAvailable) {
        this.id = id;
        this.book = book;
        this.bookType = bookType;
        this.isAvailable = isAvailable;
    }

    public String getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public double getPrice(){
        return book.getPrice() + bookType.getAdditionalCharges();
    }

    public IBook getBookType() {
        return bookType;
    }
}
