/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author RC_Student_lab
 */
/**
 * Login.java
 * Handles user validation: username, password, phone number, and login logic.
 *AI Reference Below for cellphone checker.
 * Created with assistance from OpenAI ChatGPT (GPT-4) – https://chat.openai.com
 * Date: 13 April 2025
 */

import java.util.Scanner;
import java.util.regex.Pattern;

public class Login {
    private String registeredUsername;
    private String registeredPassword;
    private String firstName;
    private String lastName;

    Scanner scanner = new Scanner(System.in);

    // Validate username
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // Validate password complexity
    public boolean checkPasswordComplexity(String password) {
        return password.length() >= 8 &&
               password.matches(".*[A-Z].*") &&
               password.matches(".*\\d.*") &&
               password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
    }

    // Validate cellphone number (+27 and max 10 digits after)
    public boolean checkCellPhoneNumber(String phoneNumber) {
        return Pattern.matches("\\+27\\d{9,10}", phoneNumber);
    }

    // Handle full user registration
    public String registerUser() {
        String username;
        String password;
        String cellPhone;

        // First Name
        System.out.print("Enter your first name: ");
        firstName = scanner.nextLine();

        // Last Name
        System.out.print("Enter your last name: ");
        lastName = scanner.nextLine();

        // Username
        while (true) {
            System.out.print("Enter username: ");
            username = scanner.nextLine();

            if (checkUserName(username)) {
                System.out.println("Username successfully captured.");
                break;
            } else {
                System.out.println("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.");
            }
        }

        // Password
        while (true) {
            System.out.print("Enter password: ");
            password = scanner.nextLine();

            if (checkPasswordComplexity(password)) {
                System.out.println("Password successfully captured.");
                break;
            } else {
                System.out.println("Password is not correctly formatted, please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
            }
        }

        // Cell phone number
        while (true) {
            System.out.print("Enter your South African cellphone number (with +27): ");
            cellPhone = scanner.nextLine();

            if (checkCellPhoneNumber(cellPhone)) {
                System.out.println("Cell phone number successfully added.");
                break;
            } else {
                System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
            }
        }

        this.registeredUsername = username;
        this.registeredPassword = password;

        return "User has been registered successfully.";
    }

    // Handle login (with retry if incorrect)
    public boolean loginUser() {
        String inputUsername;
        String inputPassword;

        while (true) {
            System.out.print("Enter your username: ");
            inputUsername = scanner.nextLine();

            System.out.print("Enter your password: ");
            inputPassword = scanner.nextLine();

            if (inputUsername.equals(this.registeredUsername) &&
                inputPassword.equals(this.registeredPassword)) {
                return true;
            } else {
                System.out.println("Login failed. Incorrect username or password. Please try again.\n");
            }
        }
    }

    // Return personalized greeting
    public String returnLoginStatus(String inputUsername, String inputPassword) {
        if (inputUsername.equals(this.registeredUsername) &&
            inputPassword.equals(this.registeredPassword)) {
            return "Welcome " + firstName + " " + lastName + ", it is great to see you.";
        } else {
            return "Login failed. Username or password is incorrect.";
        }
    }

    // Getters
    public String getRegisteredUsername() { return registeredUsername; }
    public String getRegister
