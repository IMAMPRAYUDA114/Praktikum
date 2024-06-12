package com.example.modul6tugas.Book;

public class TextBook extends Book {
    private int edition;

    public TextBook(String id, String title, String author, String category, int stock, int duration, int edition) {
        super(id, title, author, category, stock, duration);
        this.edition = edition;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    @Override
    public String toString() {
        return "TextBook{" +
                "edition=" + edition +
                ", " + super.toString() +
                '}';
    }
}