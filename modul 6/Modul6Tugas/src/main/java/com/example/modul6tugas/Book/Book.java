package com.example.modul6tugas.Book;

public class Book {
    private String id;
    private String title;
    private String author;
    private String category;
    private int stock;
    private boolean borrowed;

    private int duration; // Duration in days for borrowing

    public Book(String id, String title, String author, String category, int stock, int duration) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.stock = stock;
        this.duration = duration;
        this.borrowed = false;
    }
    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void decreaseStock() {
        if (this.stock > 0) {
            this.stock--;
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", stock=" + stock +
                ", duration=" + duration +
                '}';
    }
}
