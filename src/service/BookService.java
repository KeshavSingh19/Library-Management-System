package service;

import database.DatabaseConnection;
import java.sql.*;
import java.util.Scanner;

public class BookService {

    static Scanner sc = new Scanner(System.in);
    public static void addBook() {

        try (Connection conn = DatabaseConnection.getConnection()) {

            System.out.print("Enter Book Title: ");
            sc.nextLine();
            String title = sc.nextLine();

            System.out.print("Enter Author Name: ");
            String author = sc.nextLine();

            System.out.print("Enter Quantity: ");
            int quantity = sc.nextInt();

            String query = "INSERT INTO books(title, author, quantity) VALUES (?, ?, ?)";

            PreparedStatement pst = conn.prepareStatement(query);

            pst.setString(1, title);
            pst.setString(2, author);
            pst.setInt(3, quantity);

            pst.executeUpdate();

            System.out.println("Book Added Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // VIEW BOOKS
    public static void viewBooks() {

        try (Connection conn = DatabaseConnection.getConnection()) {

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM books");

            System.out.println("\nID | Title | Author | Quantity");
            System.out.println("----------------------------------");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("title") + " | " +
                                rs.getString("author") + " | " +
                                rs.getInt("quantity")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE BOOK
    public static void deleteBook() {

        try (Connection conn = DatabaseConnection.getConnection()) {

            System.out.print("Enter Book ID to Delete: ");
            int id = sc.nextInt();

            String query = "DELETE FROM books WHERE id = ?";

            PreparedStatement pst = conn.prepareStatement(query);

            pst.setInt(1, id);

            int rows = pst.executeUpdate();

            if (rows > 0)
                System.out.println("Book Deleted Successfully");
            else
                System.out.println("Book Not Found");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ADD STUDENT
    public static void addStudent() {

        try (Connection conn = DatabaseConnection.getConnection()) {

            System.out.print("Enter Student Name: ");
            sc.nextLine();
            String name = sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            String query = "INSERT INTO students(name,email) VALUES (?, ?)";

            PreparedStatement pst = conn.prepareStatement(query);

            pst.setString(1, name);
            pst.setString(2, email);

            pst.executeUpdate();

            System.out.println("Student Added Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // VIEW STUDENTS
    public static void viewStudents() {

        try (Connection conn = DatabaseConnection.getConnection()) {

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM students");

            System.out.println("\nID | Name | Email");
            System.out.println("----------------------");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getString("email")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ISSUE BOOK
    public static void issueBook() {

        try (Connection conn = DatabaseConnection.getConnection()) {

            System.out.print("Enter Student ID: ");
            int studentId = sc.nextInt();

            System.out.print("Enter Book ID: ");
            int bookId = sc.nextInt();

            String query = "INSERT INTO issue_records(student_id, book_id, issue_date) VALUES (?, ?, CURDATE())";

            PreparedStatement pst = conn.prepareStatement(query);

            pst.setInt(1, studentId);
            pst.setInt(2, bookId);

            pst.executeUpdate();

            System.out.println("Book Issued Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // RETURN BOOK
    public static void returnBook() {

        try (Connection conn = DatabaseConnection.getConnection()) {

            System.out.print("Enter Issue Record ID: ");
            int issueId = sc.nextInt();

            String query = "UPDATE issue_records SET return_date = CURDATE() WHERE id = ?";

            PreparedStatement pst = conn.prepareStatement(query);

            pst.setInt(1, issueId);

            int rows = pst.executeUpdate();

            if (rows > 0)
                System.out.println("Book Returned Successfully");
            else
                System.out.println("Issue Record Not Found");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}