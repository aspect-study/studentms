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
                        handleViewStudentById();
                        break;
                    case 4:
                        //TODO handle student UPDATE
                        break;
                    case 5:
                        handleExit();
                        return;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice! Please select 1-5.");
                scanner.nextLine();
            }
        }
    }

    private void handleViewStudentById() {
        System.out.println("\n --- View Student By ID ----");
        System.out.print("Please Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        String result = studentController.getStudentById(id);
        System.out.println(result);
    }

    private static void handleExit() {
        System.out.println("Good bye! Thank you.");
        System.out.println("=".repeat(40));
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
        System.out.println("4. Update Student");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private void handleCreateStudent() {
        System.out.println("\n --- Add New Student ----");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your course: ");
        String course = scanner.nextLine();
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        String result = studentController.createStudent(name, email, course, age);
        System.out.println(result);
    }

}
