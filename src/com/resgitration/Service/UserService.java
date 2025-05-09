package com.resgitration.Service;

import java.util.List;

import com.registration.Dao.UserDao;
import com.registration.Entity.UserInformation;
import com.registration.PasswordEncryption.Encrypt;
import com.registration.PasswordSecurity.PasswordValidator;
import com.registration.passwordGenerator.RandomPasswordGenerator;
import com.resgitration.emailVerification.EmailVerification;

public class UserService {
	private UserDao ud = new UserDao();
	private UserInformation userDetails = new UserInformation();

	public String registerUser(String fname, String lname, long mobile, String email, String password) {

		
		if (!EmailVerification.isValidEmail(email)) {
			return "Invalid email format. Please enter a valid email.";
		}

		
		if (EmailVerification.isEmailAlreadyInUse(email)) {
			return "Email is already registered. Please use a different email.";
		}
	if (!PasswordValidator.isValidPassword(password)) {
			return "Invalid password! Must be 8+ characters with uppercase, lowercase, number, and special character.";
		}

	
		String encryptedPassword = Encrypt.encryptPassword(password);
		userDetails.setPassword(encryptedPassword);

		
		boolean check = ud.registerUser(fname, lname, mobile, email, encryptedPassword);
		return check ? "Registration Successful!" : "Registration Unsuccessful!";
	}

	public String loginUser(String email, String password) { 
		// Fetch user details from the database
	    List<UserInformation> list = ud.getUserByEmail(email);
	    
	    // If no user is found, return error
	    if (list == null || list.isEmpty()) {
	        return "User not found. Please enter a valid email.";
	    }

	    // Get the first user (assuming email is unique)
	    UserInformation userDetails = list.get(0);

	    // Encrypt the input password for comparison
	    String encryptedPassword = Encrypt.encryptPassword(password);

	    // Compare stored email and encrypted password
	    if (userDetails.getEmail().equals(email) && userDetails.getPassword().equals(encryptedPassword)) {
	        return "Login is Successful";
	    } else {
	        return "Enter valid email and password";
	    }}

	public String resetPassword(String email, String newPassword, boolean generateNewPassword) {
	    // Fetch user details from the database
	    List<UserInformation> list = ud.getUserByEmail(email);
	    
	    // If no user is found, return a generic message
	    if (list == null || list.isEmpty()) {
	        return "If the email exists in our system, a password reset option will be available.";
	    }

	    // Get the user details
	    UserInformation userDetails = list.get(0);

	    // Generate a new password if requested, otherwise use the provided one
	    String updatedPassword = generateNewPassword ? RandomPasswordGenerator.generatePassword() : newPassword;

	    // Validate new password if user sets it manually
	    if (!generateNewPassword && (updatedPassword == null || !PasswordValidator.isValidPassword(updatedPassword))) {
	        return "Invalid password! Must be 8+ characters with uppercase, lowercase, number, and special character.";
	    }

	    // Encrypt password before storing
	    String encryptedPassword = Encrypt.encryptPassword(updatedPassword);

	    // Update password in the database
	    boolean isUpdated = ud.updateUserPassword(userDetails.getEmail(), encryptedPassword);

	    if (isUpdated) {
	        return generateNewPassword 
	            ? "A new password has been generated and sent to your email."
	            : "Password has been reset successfully. You can now log in with your new password.";
	    } else {
	        return "An error occurred while resetting the password. Please try again.";
	    }
	}


	

}
