CREATE DATABASE  IF NOT EXISTS library_db;

USE library_db;

CREATE TABLE books (
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       title VARCHAR(100),
                       author VARCHAR(100),
                       quantity INT
);

CREATE TABLE students (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          name VARCHAR(100),
                          email VARCHAR(100)
);

CREATE TABLE issue_records (
                               id INT PRIMARY KEY AUTO_INCREMENT,
                               student_id INT,
                               book_id INT,
                               issue_date DATE,
                               return_date DATE,
                               FOREIGN KEY (student_id) REFERENCES students(id),
                               FOREIGN KEY (book_id) REFERENCES books(id)
);