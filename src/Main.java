//===== Student Info Manager =====
//s1. Add New Student
//2. View All Students
//3. Search Student by ID
//4. Save Students to JSON
//5. Load Students from JSON
//6. Save to MongoDB
//7. Load from MongoDB
//8. Exit
//
//Show a menu of options
//Get user input using Scanner
//Call the right methods in StudentManager
//Loop until the user chooses to exit

import java.util.Scanner;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        boolean running = true;

        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    // Add student with validation
                    String id = getValidatedInput(scanner, "Enter student ID: ", "id");
                    String name = getValidatedInput(scanner, "Enter student name: ", "name");
                    String email = getValidatedInput(scanner, "Enter student email: ", "email");
                    String course = getValidatedInput(scanner, "Enter student course: ", "course");

                    Student student = new Student(id, name, email, course);
                    manager.addStudent(student);
                    break;

                case "2":
                    // View all students
                    List<Student> students = manager.getAllStudents();
                    if (students.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        System.out.println("\n--- Student List ---");
                        for (Student s : students) {
                            System.out.println(s);
                        }
                    }
                    break;

                case "3":
                    // Search by ID
                    String searchId = getValidatedInput(scanner, "Enter student ID to search: ", "id");
                    Student found = manager.searchById(searchId);
                    if (found != null) {
                        System.out.println("\nStudent found:");
                        System.out.println(found);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case "0":
                    running = false;
                    System.out.println("Exiting program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println(); // Spacer between actions
        }

        scanner.close();
    }

    // Display the menu
    public static void printMenu() {
        System.out.println("\n==============================");
        System.out.println("      Student Info Manager");
        System.out.println("==============================");
        System.out.println("1. Add New Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student by ID");
        System.out.println("0. Exit");
        System.out.print("Select an option: ");
    }

    // Input validation method
    public static String getValidatedInput(Scanner scanner, String prompt, String type) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();

            switch (type.toLowerCase()) {
                case "name":
                case "course":
                    if (input.matches("[a-zA-Z ]+")) {
                        return input;
                    } else {
                        System.out.println("Only letters and spaces are allowed. Please try again.");
                    }
                    break;

                case "id":
                    if (input.matches("[a-zA-Z0-9]+")) {
                        return input;
                    } else {
                        System.out.println("ID must contain only letters and numbers. Please try again.");
                    }
                    break;

                case "email":
                    if (input.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
                        return input;
                    } else {
                        System.out.println("Invalid email format. Please try again.");
                    }
                    break;

                default:
                    return input; // No validation applied
            }
        }
    }
}
