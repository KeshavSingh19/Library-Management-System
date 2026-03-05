import service.BookService;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n===== Library Management System =====");

            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Delete Book");

            System.out.println("4. Add Student");
            System.out.println("5. View Students");

            System.out.println("6. Issue Book");
            System.out.println("7. Return Book");

            System.out.println("8. Exit");

            System.out.print("Choose option: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    BookService.addBook();
                    break;

                case 2:
                    BookService.viewBooks();
                    break;

                case 3:
                    BookService.deleteBook();
                    break;

                case 4:
                    BookService.addStudent();
                    break;

                case 5:
                    BookService.viewStudents();
                    break;

                case 6:
                    BookService.issueBook();
                    break;

                case 7:
                    BookService.returnBook();
                    break;

                case 8:
                    System.out.println("Exiting System...");
                    break;

                default:
                    System.out.println("Invalid Choice");

            }

        } while (choice != 8);

    }
}