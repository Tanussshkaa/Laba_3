package org.example;

import lombok.Getter;

import java.util.Collection;
import java.util.List;

@Getter
public class User {
    private String name;
    private String surname;
    private String phone;
    private Boolean subscribed;
    private List<Book> favoriteBooks;

    public User() {}

    public User(String name, String surname, String phone, Boolean subscribed, List<Book> favoriteBooks) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.subscribed = subscribed;
        this.favoriteBooks = favoriteBooks; // Не забудьте инициализировать его в конструкторе
    }

    public List<Book> getFavoriteBooks() {
        return favoriteBooks;
    }

    @Override
    public String toString() {
        return name + " " + surname + " " + phone + " " + subscribed + "\n" + favoriteBooks ;
    }

    public String getPhone() {
        return phone;
    }
}
