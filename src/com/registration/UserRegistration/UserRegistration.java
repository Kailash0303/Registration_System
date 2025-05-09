package com.registration.UserRegistration;

import java.util.Scanner;

import com.registration.Controller.UserController;

public class UserRegistration {

	public static void registerUser() {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Enter First Name: ");
			String fname = scanner.nextLine();

			System.out.println("Enter Last Name: ");
			String lname = scanner.nextLine();

			System.out.println("Enter Mobile Number: ");
			long mobile = scanner.nextLong();

			System.out.println("Enter Email: ");
			String email = scanner.next();

			System.out.println("Enter Password: ");
			String password = scanner.next();
			UserController uc = new UserController();
			String msg = uc.registerUser(fname, lname, mobile, email, password);
			System.out.println(msg);
		}

		// Msg should be printed

	}
}