package com.resgisstration.Frontend;

import java.util.Scanner;

import com.registration.ForgotPassword.ForgotPassword;
import com.registration.UserLogin.UserLogin;
import com.registration.UserRegistration.UserRegistration;
public class User {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) { 
            System.out.println("Enter your choice ....");
            System.out.println("1. User Registration");
            System.out.println("2. User Login");
            System.out.println("3. Forgot Password");
            System.out.println("4. Exit");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
            
                case 1:
                   UserRegistration.registerUser();
                    break;
                case 2:
                    UserLogin.loginUser();
                    break;
                case 3:
                    ForgotPassword.resetPassword();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }
}
