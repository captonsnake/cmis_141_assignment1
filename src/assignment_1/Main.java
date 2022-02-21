package assignment_1;

import java.util.Scanner;
import java.util.function.*;

public class Main {
	
	public static void getInput(String prompt, Function<String, Boolean> setFunc) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.printf("%s", prompt);
			String user_input = scanner.nextLine();
			if(setFunc.apply(user_input)) {
				break;
			}
			System.out.println("Invalid input, try again.");
		}
		return;
	}

	public static void main(String[] args) {
		/*
		 * Assignment 1 for UMGC
		 * Creator: Samual McCracken
		 */
		Order order = new Order();
		
		while(true) {
			// main loop
				getInput("Enter Cust ID: ", order::setCustomerID);
				System.out.println(order.customer_ID);
				break;
		}
	}
}
