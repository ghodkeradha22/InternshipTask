package InternshipTask3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library lib = new Library();
        lib.addBook(new Book("Java Basics", "Author A"));
        lib.addBook(new Book("OOP in Java", "Author B"));

        User user1 = new Student("Radha");
        User user2 = new Teacher("Mr. Sharma");

        user1.displayRole(); 
        user2.displayRole();

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Show Books");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    lib.showBooks();
                    break;
                case 2:
                    lib.showBooks();
                    System.out.print("Enter book number to issue: ");
                    lib.issueBook(sc.nextInt() - 1);
                    break;
                case 3:
                    lib.showBooks();
                    System.out.print("Enter book number to return: ");
                    lib.returnBook(sc.nextInt() - 1);
                    break;
            }
        } while (choice != 0);

        sc.close();
    }
}

