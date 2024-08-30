package Questions.LibraryManagementSystem.model.book;

import java.util.Date;

public abstract class Book {
    private final String isbn;
    private final String title;
    private final String authorName;
    private final Date publishedDate;
    private final double basePrice;

    public Book(String isbn, String title, String authorName, Date publishedDate, double basePrice) {
        this.isbn = isbn;
        this.title = title;
        this.authorName = authorName;
        this.publishedDate = publishedDate;
        this.basePrice = basePrice;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public double getBasePrice() {
        return basePrice;
    }

    abstract double getPrice();
}
