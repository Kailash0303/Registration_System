package com.registration.UserLogin;

import java.util.Scanner;

import com.registration.Controller.UserController;

public class UserLogin {

	public static void loginUser() {
		try (Scanner scanner = new Scanner(System.in)) {

			System.out.println("Enter Email: ");
			String email = scanner.next();

			System.out.println("Enter Password: ");
			String password = scanner.next();
			UserController uc = new UserController();
		String msg=	uc.loginUser(email,password);
		System.out.println(msg);	

		}
	}
}
