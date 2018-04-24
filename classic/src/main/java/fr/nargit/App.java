package fr.nargit;

import fr.nargit.signup.Application;

/**
 * Hello world!
 */
public class App {

	public static void main(String[] args) {
		System.out.println("Start classic application");
		new Application().start();
		System.out.println("Close classic application");
		System.exit(0);
	}
}
