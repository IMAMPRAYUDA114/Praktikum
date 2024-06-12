package data;
import util.IMenu;


import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends User implements IMenu {
    public Admin(String name) {
        super(name);
    }



    public void addStudent(ArrayList<Student> userStudent) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter NIM: ");
        String nim = scanner.nextLine();
        if (nim.length() != 15) {
            System.out.println("Invalid NIM. NIM must be 15 digits.");
            addStudent(userStudent);
            return;
        }
        System.out.print("Enter Faculty: ");
        String faculty = scanner.nextLine();
        System.out.print("Enter Program: ");
        String program = scanner.nextLine();

        Student newStudent = new Student(name, nim, faculty, program);
        userStudent.add(newStudent);
        System.out.println("Student added successfully.");
    }

    public void inputBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Book ID: ");
        String bookId = scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter Category (History, Text, or Story): ");
        String category = scanner.nextLine();
        System.out.print("Enter Stock: ");
        int stock = scanner.nextInt();
        scanner.nextLine();

        String bookType = category;

        super.addBook(bookId, title, author, category, stock, bookType);
    }

    @Override
    public void menu() {

    }
}