package com.example.modul6tugas.com.main;

import com.example.modul6tugas.Book.Book;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private static List<Book> availableBooks = new ArrayList<>();

    public static void addBook(Book book) {
        availableBooks.add(book);
    }

    public static List<Book> getAvailableBooks() {
        return availableBooks;
    }
}
