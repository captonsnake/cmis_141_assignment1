package assignment_1;

/**
 * @author Samual McCracken
 *
 */
public class Order {
	
	// Attributes of an order
	int customer_ID = 0;
	float unit_price = 0f;
	int quantity = 0;
	String description = null;
	float discount = 0f;
	
	/**
	 * Sets the order Customer ID
	 * @param user_input String of user input
	 * @return true if meets requirements for attribute
	 */
	boolean setCustomerID(String user_input) {
		this.customer_ID = 0;
		if (user_input == null) {
			return false;
		}
		user_input = this.dataClean(user_input, false);
		try {
			this.customer_ID = Integer.parseInt(user_input);
			if(this.customer_ID < 0) {
				this.customer_ID = 0;
				return false;
			}
		}
		catch(NumberFormatException e) {
			return false;
		}
		return true;
			
	}
	
	/**
	 * Sets the Order Unit Price
	 * @param user_input String of user input
	 * @return true if meets requirements for attribute
	 */
	boolean setUnitPrice(String user_input) {
		this.unit_price = 0;
		if (user_input == null) {
			return false;
		}
		user_input = this.dataClean(user_input);
		try {
			this.unit_price = Float.parseFloat(user_input);
			if(this.unit_price < 0) {
				this.unit_price = 0;
				return false;
				}
		}
		catch(NumberFormatException e) {
			return false;
		}
		return true;
	}

	/**
	 * Sets the Order Quantity
	 * 
	 * @param user_input String of user input
	 * @return true if meets requirements for attribute
	 */
	boolean setQuantity(String user_input) {
		this.quantity = 0;
		if (user_input == null) {
			return false;
		}
		user_input = this.dataClean(user_input, true);
		try {
			this.quantity = Integer.parseInt(user_input);
			if(this.quantity < 0) {
				this.quantity = 0;
				return false;
				}
		}
		catch(NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	/**
	 * Sets the Order Description
	 * 
	 * @param user_input String of user input
	 * @return true if meets requirements for attribute
	 */
	boolean setDescription(String user_input) {
		if (user_input == null) {
			this.description = null;
			return false;
		}
		this.description = user_input;
		return true;
	}
	
	/**
	 * Sets the Order Discount
	 * 
	 * @param user_input String of user input
	 * @return true if meets requirements for attribute
	 */
	boolean setDiscount(String user_input) {
		this.discount = 0;
		if (user_input == null || user_input.isEmpty()) {
			return false;
		}
		user_input = this.dataClean(user_input);
		if (user_input.isEmpty() || user_input.startsWith("-")) {
			return false;
		}
		if (!user_input.contains(".")) {
			if (user_input.length() == 1)
			{
				user_input = "0" + user_input;
			}
			user_input = "0." + user_input;
		}
		try {
			this.discount = Float.parseFloat(user_input);
			if(this.discount < 0) {
				this.discount = 0;
				return false;
			} else if (this.discount > 1) {
				this.discount = 0;
				return false;
			}
			
		}
		catch(NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	/**
	 * Gets the Order total before Discount applied
	 * 
	 * @return Float of Order total before Discounts
	 */
	float getPreDiscountTotal() {
		return this.unit_price * this.quantity;
	}
	
	/**
	 * Gets the Order total after discounts applied
	 * 
	 * @return Float of Order total after discounts
	 */
	float getPostDiscountTotal() {
		return this.getPreDiscountTotal() * (1 - this.discount);
	}
	
	/**
	 * Gets a string of Order details in human readable format
	 * 
	 * @return String of Order details in human readable format
	 */
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
	
	/**
	 * This method calls dataClean() with the allowDecimal boolean set to true.
	 * 
	 * Also demonstrates use of method overwriting (which is cool btw)
	 * 
	 * @param user_input String of user input
	 * @return String of cleaned user input
	 */
	private String dataClean(String user_input) {
		return this.dataClean(user_input, true);
	}
	
	/**
	 * This function removes unnecessary characters
	 * @param user_input String of user input
	 * @param allowDecimal If true keep decimal points, if false remove decimals
	 * @return String of cleaned user input
	 */
	private String dataClean(String user_input, boolean allowDecimal) {
		// This dataClean method can produce some unexpected results to the end user.
		// Ideally I'd spend a lot more time making the program more predictable.
		// However, I don't think its worth it here. The user will just have to
		// check the output before "accepting" 
		if (!allowDecimal) {
			user_input = user_input.replaceAll("\\.", "");
		}
		user_input = user_input.replaceAll("[^\\d\\.-]", "");
		return user_input;
	}
}
