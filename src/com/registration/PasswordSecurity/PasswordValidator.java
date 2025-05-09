package com.registration.PasswordSecurity;

public class PasswordValidator {

	public static boolean isValidPassword(String password) {
		// Check length
		if (password.length() < 8) {
			System.out.println("Password must be at least 8 characters long.");
			return false;
		}
		// Check for at least one uppercase letter
		if (!password.matches(".*[A-Z].*")) {
			System.out.println("Password must contain at least one uppercase letter.");
			return false;
		}
		// Check for at least one lowercase letter
		if (!password.matches(".*[a-z].*")) {
			System.out.println("Password must contain at least one lowercase letter.");
			return false;
		}
		// Check for at least one special character
		if (!password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
			System.out.println("Password must contain at least one special character.");
			return false;
		}

		return true; // If all conditions are met
		
	}
}
