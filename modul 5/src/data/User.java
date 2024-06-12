package data;

import books.Book;
import books.TextBook;
import books.HistoryBook;
import books.StoryBook;

import java.util.ArrayList;


public class User {
    public String name;
    public ArrayList<Book> bookList;

    public User(String name) {
        this.name = name;
        bookList = new ArrayList<>();
    }

    public User(String name, ArrayList<Book> bookList) {
        this.name = name;
        this.bookList = bookList;
    }

    public void displayBooks() {
        System.out.println("\n===== Available Books ======================================================================================");
        System.out.printf("|| %-15s || %-25s || %-25s || %-20s || %-3s ||", "Book ID", "Title", "Author", "Category", "Stock");
        System.out.println("\n============================================================================================================");
        for (Book book : bookList) {
            System.out.printf("|| %-15s || %-25s || %-25s || %-20s || %-3s ||", book.getBookId(), book.getTitle(), book.getAuthor(), book.getCategory(), book.getStock());
            System.out.println();
        }
    }

    public void addBook(String bookId, String title, String author, String category, int stock, String bookType) {
        Book newBook;
        switch (bookType) {
            case "History":
                newBook = new HistoryBook(bookId, title, author, category, stock);
                break;
            case "Text":
                newBook = new TextBook(bookId, title, author, category, stock);
                break;
            case "Story":
                newBook = new StoryBook(bookId, title, author, category, stock);
                break;
            default:
                System.out.println("Invalid book type.");
                return;
        }
        bookList.add(newBook);
        System.out.println("Book added successfully.");
    }
}