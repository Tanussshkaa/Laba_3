package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Gson gson = new Gson();
        List<User> users;

        try (Reader reader = new FileReader("books.json")) {
            users = gson.fromJson(reader, new TypeToken<List<User>>() {}.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Задание 1: Вывести список посетителей и их количество.
        System.out.println("\n\t Задание 1 \n");
        System.out.println("Список посетителей:");
        users.forEach(System.out::println);
        System.out.println("Количество посетителей: " + users.size());

        // Задание 2: Вывести список и количество книг, добавленных посетителями в избранное, без повторений.
        System.out.println("\n\t Задание 2 \n");
        Set<Book> uniqueFavoriteBooks = new HashSet<>();
        for (User user : users) {
            if (user.getFavoriteBooks() != null) {
                uniqueFavoriteBooks.addAll(user.getFavoriteBooks());
            }
        }
        System.out.println("Количество уникальных любимых книг: " + uniqueFavoriteBooks.size());
        uniqueFavoriteBooks.forEach(System.out::println);

        // Задание 3: Отсортировать по году издания и вывести список книг.
        System.out.println("\n\t Задание 3 \n");
        List<Book> sortedBooks = uniqueFavoriteBooks.stream()
                .sorted((b1, b2) -> b1.getPublishingYear().compareTo(b2.getPublishingYear()))
                .collect(Collectors.toList());

        System.out.println("Список книг, отсортированных по году издания:");
        sortedBooks.forEach(System.out::println);

        // Задание 4: Проверить, есть ли у кого-то в избранном книга автора “Jane Austen”.
        System.out.println("\n\t Задание 4 \n");
        boolean hasJaneAusten = users.stream()
                .flatMap(user -> user.getFavoriteBooks().stream())
                .anyMatch(book -> "Jane Austen".equals(book.getAuthor()));

        if (hasJaneAusten) {
            System.out.println("У кого-то в избранном есть книга автора 'Jane Austen'.");
        } else {
            System.out.println("Книги автора 'Jane Austen' в избранном нет.");
        }

        // Задание 5: Вывести максимальное число добавленных в избранное книг
        System.out.println("\n\t Задание 5 \n");
        int maxFavoriteBooks = users.stream()
                .mapToInt(user -> user.getFavoriteBooks() != null ? user.getFavoriteBooks().size() : 0)
                .max()
                .orElse(0);
        System.out.println("Максимальное количество добавленных в избранное книг: " + maxFavoriteBooks);

        // Задание 6: На твой телефон пришло новое сообщение, посмотри – вдруг там что-то важное..
        System.out.println("\n\t Задание 6 \n");
        double averageFavoriteBooks = users.stream()
                .mapToInt(user -> user.getFavoriteBooks() != null ? user.getFavoriteBooks().size() : 0)
                .average()
                .orElse(0);

        List<SMS> messages = new ArrayList<>();
        for (User user : users) {
            int favoriteCount = user.getFavoriteBooks() != null ? user.getFavoriteBooks().size() : 0;
            String message;

            if (favoriteCount > averageFavoriteBooks) {
                message = "you are a bookworm";
            } else if (favoriteCount < averageFavoriteBooks) {
                message = "read more";
            } else {
                message = "fine";
            }

            messages.add(new SMS(user.getPhone(), message));
        }

        // Вывод SMS сообщений
        messages.forEach(System.out::println);

    }
}