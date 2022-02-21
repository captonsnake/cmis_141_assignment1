package assignment_1;

public class Order {
	
	int customer_ID = 0;
	float unit_price = 0f;
	int quantity = 0;
	String description = null;
	float discount = 0f;
	
	boolean setCustomerID(String user_input) {
		if (user_input == null) {
			this.customer_ID = 0;
			return false;
		}
		try {
			this.customer_ID = Integer.parseInt(user_input);
			if(this.customer_ID < 0 || this.customer_ID > Integer.MAX_VALUE) {
				System.err.printf("User input '%s' is out of bounds\n", user_input);
				this.customer_ID = 0;
				return false;
			}
		}
		catch(NumberFormatException e) {
			System.err.println(e);
			System.err.printf("User input '%s' is not an integer type.\n", user_input);
			this.customer_ID = 0;
			return false;
		}
		return true;
			
	}
	
	boolean setUnitPrice(String user_input) {
		if (user_input == null) {
			this.unit_price = 0;
			return false;
		}
		if (user_input.startsWith("$")) {
			user_input = user_input.replace("$", "");
		}
		try {
			this.unit_price = Float.parseFloat(user_input);
			if(this.unit_price < 0) {
				System.err.println("Unit price may not be negative.");
				this.unit_price = 0;
				return false;
				}
		}
		catch(NumberFormatException e) {
			System.err.println(e);
			System.err.printf("User input '%s' is not a float. (e.g. 12.45)\n", user_input);
			this.unit_price = 0;
			return false;
		}
		return true;
	}

	boolean setQuantity(String user_input) {
		if (user_input == null) {
			this.quantity = 0;
			return false;
		}
		try {
			this.quantity = Integer.parseInt(user_input);
			if(this.quantity < 0) {
				System.err.println("Quantity may not be negative.");
				this.quantity = 0;
				return false;
				}
		}
		catch(NumberFormatException e) {
			System.err.println(e);
			System.err.printf("User input '%s' is not a float. (e.g. '12.45')\n", user_input);
			return false;
		}
		return true;
	}
	
	boolean setDescription(String user_input) {
		if (user_input == null) {
			this.description = null;
			return false;
		}
		// Does this need to be a new string?
		this.description = user_input;
		return true;
	}
	
	boolean setDiscount(String user_input) {
		if (!user_input.startsWith(".") || !user_input.startsWith("0.")) {
			user_input = "0." + user_input;
		}
		if (user_input.contains("%")) {
			user_input = user_input.replace("%", "");
		}
		try {
			this.discount = Float.parseFloat(user_input);
			if(this.discount < 0) {
				System.err.println("Discount may not be negative.");
				this.discount = 0;
				return false;
			} else if (this.discount > 1) {
				System.err.println("Discount may not be greater than 1");
			}
			
		}
		catch(NumberFormatException e) {
			System.err.println(e);
			System.err.printf("User input '%s' is not a float. (e.g. '.45')\n", user_input);
			return false;
		}
		return true;
	}
	
	float getPreDiscountTotal() {
		return this.unit_price * this.quantity;
	}
	
	float getPostDiscountTotal() {
		return this.getPostDiscountTotal() * this.discount;
	}
	
	String getOrderData()
	{
		String output = """
				ORDER DATA:
				Customer ID:         %d
				Price:               %.2f
				Quantity:            %d
				Product Description: %s
				Discount:            %.2f
				
				Order Total BEFORE
				Discount:           %.2f
				
				Order Total AFTER
				Discount:           %.2f
				""";
		return output.formatted(this.customer_ID,
								this.unit_price,
								this.quantity,
								this.description,
								this.discount,
								this.getPreDiscountTotal(),
								this.getPostDiscountTotal());
	}
}
