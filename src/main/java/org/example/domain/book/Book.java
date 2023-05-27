package org.example.domain.book;

import lombok.*;
import org.example.core.domain.Entity;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Book implements Entity {
    private long id;
    private String name;
    private String isbn;
    private Date writerDate;
    private String writer;
    private double price;

    public Book(String name, String isbn, Date writerDate, String writer, double price) {
        this.name = name;
        this.isbn = isbn;
        this.writerDate = writerDate;
        this.writer = writer;
        this.price = price;
    }
}
