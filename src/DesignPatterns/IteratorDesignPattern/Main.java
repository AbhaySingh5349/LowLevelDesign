package DesignPatterns.IteratorDesignPattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Physics", 100),
                new Book("Maths", 120),
                new Book("Economics", 90),
                new Book("General Knowledge", 100)
        );

        Library library = new Library(books);
        Iterator bookIterator = library.createIterator();

        while (bookIterator.hasNext()){
            Book book = (Book) bookIterator.next();
            System.out.println(book.getName());
        }
    }
}
