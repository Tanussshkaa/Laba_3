package org.example;

import lombok.Getter;

import java.util.List;

@Getter
public class Book {
    private String name;
    private String author;
    private Integer publishingYear;
    private String isbn;
    private String publisher;

    public Book() {}

    public Book(String name, String author, Integer publishingYear, String isbn, String publisher) {
        this.name = name;
        this.author = author;
        this.publishingYear = publishingYear;
        this.isbn = isbn;
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "\t" + name + " " + author + " " + publishingYear + " " + isbn + " " + publisher + "\n";
    }

    public String getAuthor() {
        return author;
    }

    public Integer getPublishingYear() {
        return publishingYear;
    }
}
