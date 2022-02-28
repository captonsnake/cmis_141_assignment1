package assignment_1;

import java.util.Scanner;
import java.util.function.*;

/**
 * This is a simple CLI tool to create an Order and display an order receipt.
 * Date: 2022 Feb 28
 * Written for CMIS 141 Assignment 1
 * @author Samual McCracken
 * @version 1.0
 * 
 */
public class Main {
	
	private static Scanner scanner = null;
	
	/**
	 * This struct holds the prompt and setter function for
	 * an Order so that it may easily be saved in a 1d array
	 */
	static class InputPromptStruct {
		String prompt;
		Function<String, Boolean> setFunc;
		
		//Constructor
		public InputPromptStruct(String s, Function<String, Boolean> f) {
			this.prompt = s;
			this.setFunc = f;
		}
		
	}
	
	/**
	 * @param prompt This is the prompt displayed to the user
	 * @param setFunc This is a method reference to the setter for the attribute to set
	 */
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
		
		// Initialize the scanner to use in main
		scanner = new Scanner(System.in);
		
		// Demonstrating use of while loops
		// This loop continues to iterate until the user decides to quit by typing anything other than "y || Y" at the prompt
		while(true) {
			Order order = new Order();

			//Using this to demonstrate use of Arrays
			// This 1d array holds the InputPromptStruct objects that are used
			// to call the setters for an order
			InputPromptStruct[] inputArray = new InputPromptStruct[] {
					new InputPromptStruct("Enter Cust ID:     ", order::setCustomerID),
					new InputPromptStruct("Enter Unit Price:  ", order::setUnitPrice),
					new InputPromptStruct("Enter Quantity:    ", order::setQuantity),
					new InputPromptStruct("Enter Description: ", order::setDescription),
					new InputPromptStruct("Enter Discount:    ", order::setDiscount)
			};
			
			//Demonstrating use of for loops
			//Loop iterates thru inputArray and calls getInput for each item
			for (int i = 0; i < inputArray.length; i++) {
				getInput(inputArray[i].prompt, inputArray[i].setFunc);
			}
			
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
		
		// close scanner resource
		scanner.close();
	}
}
