package com.studentms.view;

import com.studentms.controller.StudentController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentManagementView {

    private final StudentController studentController;
    private final Scanner scanner;

    public StudentManagementView() {
        this.studentController = new StudentController();
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        while (true) {
            printMenu();
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        handleCreateStudent();
                        break;
                    case 2:
                        handleViewAllStudents();
                        break;
                    case 3:
                        //TODO hadle logic for searching student bu ID
                        break;
                    case 4:
                        System.out.println("Good bye! Thank you.");
                        System.out.println("=".repeat(40));
                        return;
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid choice! Please select 1-3.");
                scanner.nextLine();
            }
        }
    }

    private void handleViewAllStudents() {
        System.out.println("\n" + "=".repeat(40));
        String students = studentController.getAllStudent();
        System.out.println(students);
    }

    private void printMenu() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("STUDENT MANAGEMENT DEMO");
        System.out.println("=".repeat(40));
        System.out.println("1. Add New Student");
        System.out.println("2. View All Students");
        System.out.println("3. View Student by ID");
        System.out.println("4. Exit");
        System.out.print("Enter you choice: ");
    }

    private void handleCreateStudent() {
        System.out.println("\n --- Add New Student ----");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your course: ");
        String course = scanner.nextLine();
        Integer age = validateAge("Enter your age: ");

        String result = studentController.createStudent(name, email, course, age);
        System.out.println(result);
    }

    private Integer validateAge(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                Integer age = scanner.nextInt();
                scanner.nextLine();
                if (age < 18 || age > 60) {
                    System.out.println("Age must between 18 to 60. Please try again.");
                    continue;
                }
                return age;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input!, Please enter a valid number for age.");
                scanner.nextLine();
            }
        }
    }
}
