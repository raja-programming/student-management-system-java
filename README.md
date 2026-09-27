# Student Management System

## Project Overview

This is a console-based Student Management System developed using Java. The application allows users to add, view, update, and delete student records.

Student records are stored using a HashMap collection. The project also uses file handling to save student data in a text file, so records remain available after the program is closed and reopened.

## Features

- Add a student record
- View all student records
- Update an existing student record
- Delete a student record
- Store student data using HashMap
- Save student records to a file
- Load student records from a file
- Handle invalid number input using try-catch exception handling
- Menu-driven console application

## Technologies Used

- Java
- HashMap
- Scanner
- Methods
- Conditional Statements
- Loops
- File Handling
- Exception Handling

## Project Files

- `StudentManagementSystem.java` - Main Java source code
- `students.txt` - File used to store student records
- `README.md` - Project documentation

## How to Run the Project

1. Download or clone this repository.
2. Open the project folder in Visual Studio Code.
3. Make sure Java JDK is installed on your computer.
4. Open `StudentManagementSystem.java`.
5. Run the Java program.
6. Choose an option from the displayed menu.

## Menu Options

    1. Add Student
    2. View Students
    3. Update Student
    4. Delete Student
    5. Exit

## Example Usage

    --- Student Management System ---
    1. Add Student
    2. View Students
    3. Update Student
    4. Delete Student
    5. Exit
    Enter your choice: 1

    Enter student ID: 101
    Enter student name: Rajamanickam
    Student added successfully.

## Concepts Implemented

### Java Methods

Separate methods are used for each operation:

- `addStudent()`
- `viewStudents()`
- `updateStudent()`
- `deleteStudent()`
- `saveStudents()`
- `loadStudents()`
- `readNumber()`

### HashMap Collection

A HashMap is used to store student records.

- Key: Student ID
- Value: Student Name

### Exception Handling

The project uses `try-catch` to prevent the program from crashing when the user enters invalid numeric input.

### File Handling

Student records are saved in `students.txt`. When the program starts, existing student records are loaded from this file.

## Author

Rajamanickam R

## Module

Module 2 - Methods, Collections and Exceptions