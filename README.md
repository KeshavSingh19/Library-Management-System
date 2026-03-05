Library Management System

A console-based Library Management System developed using Java and MySQL.
This project demonstrates how to build a simple backend system that manages books, students, and book borrowing operations using JDBC database connectivity.

⸻⸻

Features

• Add new books to the library
• View all available books
• Delete books from the library
• Add students to the system
• View registered students
• Issue books to students
• Return issued books

⸻⸻

Technologies Used

•	Java
•	JDBC (Java Database Connectivity)
•	MySQL
•	IntelliJ IDEA
•	Git & GitHub

⸻⸻

Project Structure

Library-Management-System
│
├── src
│   ├── database
│   │   └── DatabaseConnection.java
│   ├── service
│   │   └── BookService.java
│   └── Main.java
│
├── database.sql
├── README.md
└── .gitignore

⸻⸻

Database Schema

The system uses a MySQL database named library_db with three tables:

books

Stores book details such as title, author, and quantity.

students

Stores registered student information.

issue_records

Tracks book issue and return activity.

⸻⸻

How to Run the Project

1.	Install MySQL and create the database using database.sql.
2.	Open the project in IntelliJ IDEA.
3.	Ensure MySQL is running locally.
4.	Run Main.java.
5.	Use the console menu to manage library operations.

⸻⸻

Example Console Menu

===== Library Management System =====

1. Add Book
2. View Books
3. Delete Book
4. Add Student
5. View Students
6. Issue Book
7. Return Book
8. Exit

Author : KESHAV SINGH