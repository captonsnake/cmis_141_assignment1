package assignment_1;

import java.util.Scanner;
import java.util.function.*;

/**
 * This is a simple CLI tool to create an Order and display an order receipt.
 * Date: 2022 Feb 02
 * Written for CMIS 141 Assignment 1
 * @author Samual McCracken
 * @version 1.0
 * 
 */
public class Main {
	
	/**
	 * @param prompt This is the prompt displayed to the user
	 * @param setFunc This is a method reference to the setter for the attribute to set
	 */
	private static Scanner scanner = null;
	
	public static void getInput(String prompt, Function<String, Boolean> setFunc) {
		// This loop allows for a user to input until the setter returns true.
		// This means a user will be prompted multiple times until the input
		// meets the requirements of the associated setter in Order.setFunc()
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
		Order order = new Order();
		scanner = new Scanner(System.in);
		
		while(true) {
			// Main Loop Notes:
			// This main loop allows for the program to be ran
			// multiple times until the user decides to quit (i.e. Type anything other than y at the end)
			
			// getInput Notes:
			// I used method references here. I could have made the 
			// order a class attribute, but that wouldn't be very modular.
			getInput("Enter Cust ID:     ", order::setCustomerID);
			getInput("Enter Unit Price:  ", order::setUnitPrice);
			getInput("Enter Quantity:    ", order::setQuantity);
			getInput("Enter Description: ", order::setDescription);
			getInput("Enter Discount:    ", order::setDiscount);
			
			System.out.printf("%s\n", order.getOrderData());
			
			// Break the loop and exit program prompt.
			System.out.println("Is this correct (y/n): ");
			String reply = scanner.nextLine();
			
			if (reply.equalsIgnoreCase("y")) {
				System.out.println("Order Complete");
				break;
			}
			System.out.println("Please try again.");
				
		}
		scanner.close();
	}
}
