import java.util.ArrayList;
import java.util.Scanner;

/**
 * Student Management System
 * Manages student records, including adding, removing, displaying, and searching students.
 */
public static class StudentManagementSystem {
    
    /**
     * Represents a student with an ID, name, and age.
     */
    public static class Student {
        int id; ///< Unique ID of the student
        String name; ///< Name of the student
        int age; ///< Age of the student

        /**
         * Constructor to initialize student details.
         * @param id Unique student ID
         * @param name Name of the student
         * @param age Age of the student
         */
        Student(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }
    }

    static ArrayList<Student> students = new ArrayList<>(); ///< List to store student records

    /**
     * Main method that displays the menu and handles user input.
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Remove By ID ");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> addNewStudent(scanner);
                case 2 -> showAllStudents();
                case 3 -> findStudentById(scanner);
                case 4 -> removeStudentById(scanner);
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    /**
     * Adds a new student to the list.
     * @param scanner Scanner object to take user input
     */
   public  static void addNewStudent(Scanner scanner) {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();

        for (Student student : students) {
            if (student.id == id) {
                System.out.println("The ID is not valid (already exists).");
                return;
            }
        }
        System.out.print("Enter Student Name: ");
        scanner.nextLine(); // Consume newline
        String name = scanner.nextLine();
        System.out.print("Enter Student Age: ");
        int age = scanner.nextInt();
        students.add(new Student(id, name, age));
        System.out.println("Student added successfully!");
    }

    /**
     * Displays the list of all students.
     */
    public static void showAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        System.out.println("\n--- Students List ---");
        System.out.println("+------------+----------------------+-----+");
        System.out.println("| ID         | Name                 | Age |");
        System.out.println("+------------+----------------------+-----+");

        for (Student student : students) {
            System.out.printf("| %-10d | %-20s | %-3d |\n", student.id, student.name, student.age);
        }
        System.out.println("+------------+----------------------+-----+");
    }

    /**
     * Searches for a student by their ID.
     * @param scanner Scanner object to take user input
     */
    public static void findStudentById(Scanner scanner) {
        System.out.print("Enter Student ID to search: ");
        int id = scanner.nextInt();
        for (Student student : students) {
            if (student.id == id) {
                System.out.println("ID: " + student.id + ", Name: " + student.name + ", Age: " + student.age);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    /**
     * Removes a student by their ID.
     * @param scanner Scanner object to take user input
     */
    public static void removeStudentById(Scanner scanner) {
        System.out.print("Enter Student ID to remove: ");
        int id = scanner.nextInt();
        boolean remove = students.removeIf(student -> student.id == id);
        if (remove) {
            System.out.println("Student with ID " + id + " has been deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }
}
