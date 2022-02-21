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
				getInput("Enter Cust ID:     ", order::setCustomerID);
				getInput("Enter Unit Price:  ", order::setUnitPrice);
				getInput("Enter Quantity:    ", order::setQuantity);
				getInput("Enter Description: ", order::setDescription);
				getInput("Enter Discount:    ", order::setDiscount);
				
				System.out.printf("%s\n", order.getOrderData());
				
				System.out.println("Is this correct (y/n): ");
				Scanner scanner = new Scanner(System.in);
				String reply = scanner.nextLine();
				
				if (reply.equalsIgnoreCase("y")) {
					System.out.println("Order Complete");
					break;
				}
				System.out.println("Please try again.");
				
		}
	}
}
