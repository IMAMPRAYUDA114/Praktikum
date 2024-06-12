package com.example.modul6tugas.com.main;

import com.example.modul6tugas.Data.*;
import com.example.modul6tugas.Book.*;
import com.example.modul6tugas.util.*;
import com.example.modul6tugas.exception.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Book> bookList = new ArrayList<>();
    public static ArrayList<User> userList = new ArrayList<>();
    public static Admin admin = new Admin("Admin Name", "adminNIM", "Faculty Name", "Program Name", true);

    public static void main(String[] args) {
        try {
            initializeData();
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("===== Library System =====");
                System.out.println("1. Login as Student");
                System.out.println("2. Login as Admin");
                System.out.println("3. Exit");
                System.out.print("Choose option (1-3): ");
                String option = scanner.nextLine();
                switch (option) {
                    case "1":
                        enterNim(scanner);
                        break;
                    case "2":
                        try {
                            admin.loginAdmin(scanner);
                        } catch (IllegalAdminAccess e) {
                            System.err.println("Error: " + e.getMessage());
                        }
                        break;
                    case "3":
                        System.out.println("Thank you. Exiting program.");
                        System.exit(0);
                    default:
                        System.out.println("Invalid option.");
                }
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    public static void enterNim(Scanner scanner) {
        System.out.print("Enter your NIM (input 99 to back): ");
        String nim = scanner.nextLine();
        if (nim.equals("99")) {
            return;
        } else if (checkNim(nim)) {
            User user = getUser(nim);
            user.menu();
        } else {
            System.out.println("Invalid NIM. Please try again.");
            enterNim(scanner);
        }
    }

    public static boolean checkNim(String nim) {
        for (User user : userList) {
            if (user instanceof Student && ((Student) user).getNim().equals(nim)) {
                return true;
            }
        }
        return false;
    }

    public static User getUser(String nim) {
        for (User user : userList) {
            if (user instanceof Student && ((Student) user).getNim().equals(nim)) {
                return user;
            }
        }
        return null;
    }


    public static void initializeData() {
        bookList.add(new HistoryBook("388c-e681-9152", "title1", "author1", "Story", 8, 7));
        bookList.add(new StoryBook("ed90-be30-5cdb", "title2", "author2", "History Books", 11, 14));
        bookList.add(new TextBook("d95e-0c4a-9523", "title3", "author3", "Story", 3, 30, 2));
        bookList.add(new TextBook("d95e-0c4a-9526", "title4", "author4", "Novel", 3, 30, 2));
        bookList.add(new TextBook("d95e-0c4a-9529", "title5", "author5", "Novel", 3, 30, 2));

        userList.add(new Student("Taufiq Ramadhan", "202210370311288", "Teknik", "Informatika"));
        userList.add(new Student("Who", "202310370311135", "Teknik", "Informatika"));
        userList.add(new Student("Sutrisno Adit Pratama", "202210370311203", "Teknik", "Informatika"));
    }


}
