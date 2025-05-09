package com.registration.Controller;

import com.resgitration.Service.UserService;

public class UserController {
	private UserService us = new UserService();

	public String registerUser(String fname, String lname, long mobile, String email, String password) {

		return us.registerUser(fname, lname, mobile, email, password);

	}

	public String loginUser(String email, String password) {
		return us.loginUser(email,password);
		
	}
	public String resetpassword(String email, String newPassword, boolean generateNewPassword) {
	    return us.resetPassword(email, newPassword, generateNewPassword);
	}

	


}
