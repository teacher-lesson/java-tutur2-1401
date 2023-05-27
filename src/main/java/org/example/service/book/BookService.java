package org.example.service.book;

import org.example.domain.book.Book;

public interface BookService {
    Book read(long id);
    Book[] readAll();
    long create(Book book);
    boolean update(long id, Book book);
    boolean delete(long id);
    Book searchByName(String name);
}
