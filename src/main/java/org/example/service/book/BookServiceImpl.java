package org.example.service.book;

import org.example.domain.book.Book;

import java.util.HashMap;
import java.util.Map;

public class BookServiceImpl implements BookService {
    private static long lastId = 1;

    private Book[] books = new Book[100];
    private Map<Long, Book> data = new HashMap<>();

    @Override
    public Book read(long id) {
//        for (Book book : books) {
//            if (book.getId() == id)
//                return book;
//        }

        return data.get(id);
    }

    @Override
    public Book[] readAll() {
//        return books;
        return data.values().toArray(new Book[data.size()]);
    }

    @Override
    public long create(Book book) {
//        for (int i = 0; i < books.length; i++) {
//            if (books[i] == null) {
//                books[i] = book;
//                break;
//            }
//        }
        long key = lastId++;
        book.setId(key);
        data.put(key, book);
        return lastId;
    }

    @Override
    public boolean update(long id, Book book) {
        Book b = data.get(id);
        if (b == null) {
            return false;
        }

        data.replace(id, book);
        return true;
    }

    @Override
    public boolean delete(long id) {
        if (!data.containsKey(id)) {
            return false;
        }

        data.remove(id);
        return true;
    }

    @Override
    public Book searchByName(String name) {
        for (Map.Entry<Long, Book> e : data.entrySet()) {
            if (e.getValue().getName().equalsIgnoreCase(name)) {
                return e.getValue();
            }
        }

        return null;
    }
}
