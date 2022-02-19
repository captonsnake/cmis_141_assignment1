package assignment_1;

public class Order {
	
	int customer_ID = 0;
	float unit_price = 0f;
	int quantity = 0;
	String description = null;
	float discount = 0f;
	
	boolean setCustomerID(String user_input) {
		try {
			this.customer_ID = Integer.parseInt(user_input);
			if(this.customer_ID < 0 || this.customer_ID > Integer.MAX_VALUE)
			{
				System.err.printf("User input '%s' is out of bounds");
				this.customer_ID = 0;
				return false;
			}
		}
		catch(NumberFormatException e) {
			System.err.printf("User input '%s' is not an integer type.\n", user_input);
			this.customer_ID = 0;
			return false;
		}
		return true;
			
	}

}
