package com.Main;

import data.User;
import data.Student;
import data.Admin;
import util.IMenu;
import exception.custom.ilegalAdminAccess;

import java.util.ArrayList;
import java.util.Scanner;

public class Tugas implements IMenu {
    private ArrayList<Student> userStudent;
    private Scanner scanner;
    static Scanner inputuser = new Scanner(System.in);

    static String adminusername = "admin", adminpassword = "admin";
    private Admin admin;
    private User user;

    private boolean isAdmin;

    public Tugas() {
        userStudent = new ArrayList<>();
        scanner = new Scanner(System.in);
        admin = new Admin("Admin");
        user = new User("User", admin.bookList);
    }

    @Override
    public void menu() {
        System.out.println("\n===== Library System =====");
        System.out.println("1. Login as Student");
        System.out.println("2. Login as Admin");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                inputNim();
                break;
            case 2:
                try {
                    loginadmin();
                    if (isAdmin) {
                        menuAdmin();
                    }
                } catch (ilegalAdminAccess e) {
                    System.err.println(e.getMessage());
                }
                break;
            default:
                System.out.println("Invalid choice. Try again.");
                menu();
        }
    }

    private void inputNim() {
        System.out.print("Enter your NIM: ");
        String nim = scanner.nextLine();
        if (checkNim(nim)) {
            Student currentStudent = getUserByNim(nim);
            menuStudent(currentStudent);
        } else {
            System.out.println("Invalid NIM. Please try again.");
            inputNim();
        }
    }

    private boolean checkNim(String nim) {
        for (Student student : userStudent) {
            if (student.nim.equals(nim)) {
                return true;
            }
        }
        return false;
    }

    private Student getUserByNim(String nim) {
        for (Student student : userStudent) {
            if (student.nim.equals(nim)) {
                return student;
            }
        }
        return null;
    }

    private void loginadmin() throws ilegalAdminAccess {
        System.out.println("\n==== Login ====");
        System.out.print("Enter Username: ");
        String username = inputuser.nextLine();

        System.out.print("Enter Password: ");
        String password = inputuser.nextLine();

        if (isAdmin(username, password)) {
            System.out.println("Login successful.");
            isAdmin = true;
        } else {
            isAdmin = false;
            throw new ilegalAdminAccess("Invalid admin credentials.");
        }
    }

    private boolean isAdmin(String username, String password) {
        return username.equals(adminusername) && password.equals(adminpassword);
    }

    private void menuAdmin() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n===== Admin Menu =====");
            System.out.println("1. Input Book");
            System.out.println("2. Display Books");
            System.out.println("3. Add Student");
            System.out.println("4. Display Registered Students");
            System.out.println("5. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                if (!isAdmin) {
                    throw new ilegalAdminAccess("Unauthorized access.");
                }
                switch (choice) {
                    case 1:
                        admin.inputBook();
                        break;
                    case 2:
                        admin.displayBooks();
                        break;
                    case 3:
                        admin.addStudent(userStudent);
                        break;
                    case 4:
                        displayStudent();
                        break;
                    case 5:
                        menu();
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (ilegalAdminAccess e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private void menuStudent(Student currentStudent) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n===== Student Dashboard =====");
            System.out.println("1. Display Available Books");
            System.out.println("2. Borrow Book");
            System.out.println("3. Borrowed Books");
            System.out.println("4. Return Book");
            System.out.println("5. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1:
                        user.displayBooks();
                        break;
                    case 2:
                        currentStudent.borrowBook(user.bookList);
                        break;
                    case 3:
                        currentStudent.showBorrowedBook(user.bookList);
                        break;
                    case 4:
                        currentStudent.returnBook(user.bookList);
                        break;
                    case 5:
                        menu();
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private void displayStudent() {
        System.out.println("\n===== Registered Students =====");
        for (Student student : userStudent) {
            System.out.println("Name: " + student.name);
            System.out.println("NIM: " + student.nim);
            System.out.println("Faculty: " + student.faculty);
            System.out.println("Program: " + student.program);
            System.out.println();
        }
    }
}
