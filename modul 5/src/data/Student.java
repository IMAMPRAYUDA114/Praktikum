package data;

import books.Book;
import util.IMenu;

import java.util.ArrayList;
import java.util.Scanner;

public class Student extends User implements IMenu {
    public String nim;
    public String faculty;
    public String program;

    public Student(String name, String nim, String faculty, String program) {
        super(name);
        this.nim = nim;
        this.faculty = faculty;
        this.program = program;
    }

    public void borrowBook(ArrayList<Book> bookList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Book ID to borrow: ");
        String bookId = scanner.nextLine();
        System.out.print("Enter the duration in days (e.g., 7, 14, 30): ");
        int durationDays = scanner.nextInt();
        scanner.nextLine();

        boolean found = false;
        for (Book book : bookList) {
            if (book.getBookId().equals(bookId)) {
                found = true;
                book.borrowBook(durationDays);
                break;
            }
        }
        if (!found) {
            System.out.println("Book with the given ID not found.");
        }
    }

    public void returnBook(ArrayList<Book> bookList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Book ID to return: ");
        String bookId = scanner.nextLine();

        boolean found = false;
        for (Book book : bookList) {
            if (book.getBookId().equals(bookId)) {
                found = true;
                book.returnBook();
                break;
            }
        }
        if (!found) {
            System.out.println("Book with the given ID not found or not borrowed by you.");
        }
    }

    public void showBorrowedBook(ArrayList<Book> bookList) {
        System.out.println("\n===== Borrowed Books =====");
        boolean hasBorrowedBooks = false;
        for (Book book : bookList) {
            if (book.getBorrowedCount() > 0) {
                hasBorrowedBooks = true;
                System.out.printf("|| %-15s || %-25s || %-25s || %-20s || %-10s || %-10s ||\n", book.getBookId(), book.getTitle(), book.getAuthor(), book.getCategory(), book.getBorrowedDate(), "Due in " + book.getDurationDays() + " days");
            }
        }
        if (!hasBorrowedBooks) {
            System.out.println("You haven't borrowed any books yet.");
        }
    }

    @Override
    public void menu() {

    }
}
