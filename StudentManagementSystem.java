import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentManagementSystem {

    static HashMap<Integer, String> students = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);
    static final String FILE_NAME = "students.txt";

    static int readNumber(String message) {
        while (true) {
            System.out.print(message);

            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    static void addStudent() {
        int id = readNumber("Enter student ID: ");

        if (students.containsKey(id)) {
            System.out.println("Student ID already exists.");
            return;
        }

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        students.put(id, name);
        saveStudents();
        System.out.println("Student added successfully.");
    }

    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
        } else {
            System.out.println("\n--- Student Records ---");

            for (Map.Entry<Integer, String> student : students.entrySet()) {
                System.out.println(
                    "ID: " + student.getKey() +
                    ", Name: " + student.getValue()
                );
            }
        }
    }

    static void updateStudent() {
        int id = readNumber("Enter student ID to update: ");

        if (students.containsKey(id)) {
            System.out.print("Enter new student name: ");
            String newName = scanner.nextLine();

            students.put(id, newName);
            saveStudents();
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Student ID not found.");
        }
    }

    static void deleteStudent() {
        int id = readNumber("Enter student ID to delete: ");

        if (students.containsKey(id)) {
            students.remove(id);
            saveStudents();
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student ID not found.");
        }
    }

    static void saveStudents() {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME));

            for (Map.Entry<Integer, String> student : students.entrySet()) {
                writer.println(student.getKey() + "," + student.getValue());
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("Error while saving student records.");
        }
    }

    static void loadStudents() {
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return;
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",", 2);

                if (data.length == 2) {
                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    students.put(id, name);
                }
            }

            reader.close();
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error while loading student records.");
        }
    }

    public static void main(String[] args) {
        loadStudents();

        int choice;

        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            choice = readNumber("Enter your choice: ");

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1 to 5.");
            }

        } while (choice != 5);

        scanner.close();
    }
}