package assignment_1;

import java.util.function.*;

public class Main {
	
	public static void getInput(String prompt, Function<String, Boolean> setFunc) {
		setFunc.apply(prompt);
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
				getInput("test", order::setDescription);
				System.out.println(order.description);
		}
	}
}
