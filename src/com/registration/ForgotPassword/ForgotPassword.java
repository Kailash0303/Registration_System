package com.registration.ForgotPassword;

import java.util.Scanner;

import com.registration.Controller.UserController;

public class ForgotPassword {

	public static void resetPassword() {
	    try (Scanner scanner = new Scanner(System.in)) {
	        System.out.print("Enter Email: ");
	        String email = scanner.next();

	        UserController uc = new UserController();

	        System.out.print("Do you want to generate a new password automatically? (yes/no): ");
	        String choice = scanner.next();

	        boolean generateNewPassword = choice.equalsIgnoreCase("yes"); // If "yes", generate password
	        String newPassword = null;

	        if (!generateNewPassword) {
	            System.out.print("Enter New Password: ");
	            scanner.nextLine(); // Consume newline character
	            newPassword = scanner.nextLine();
	        }

	        // Call resetPassword with correct parameters
	        String message = uc.resetpassword(email, newPassword, generateNewPassword); 
	        
	        System.out.println(message);
	    }
	}


	}
