package DesignPatterns.IteratorDesignPattern;

import java.util.List;

public class BookIterator implements Iterator{
    private List<Book> books;
    private Integer idx = 0;

    public BookIterator(List<Book> books) {
        this.books = books;
    }

    @Override
    public Boolean hasNext() {
        return idx < books.size();
    }

    @Override
    public Object next() {
        if(this.hasNext()){
            return books.get(idx++);
        }
        return null;
    }
}
