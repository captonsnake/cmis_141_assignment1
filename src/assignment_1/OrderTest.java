package assignment_1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OrderTest {

	@Test
	void testSetCustomerID() {
		Order order = new Order();
		assertTrue(order.setCustomerID("1234"));
		assertEquals(order.customer_ID, 1234);
		
		assertFalse(order.setCustomerID("abcd"));
		assertEquals(order.customer_ID, 0);
		
		assertFalse(order.setCustomerID(""));
		assertEquals(order.customer_ID, 0);
		
		assertFalse(order.setCustomerID("a123"));
		assertEquals(order.customer_ID, 0);
		
		assertFalse(order.setCustomerID("-13"));
		assertEquals(order.customer_ID, 0);
		
		assertFalse(order.setCustomerID("13.1"));
		assertEquals(order.customer_ID, 0);
	}

	@Test
	void testSetUnitPrice() {
		fail("Not yet implemented");
	}

	@Test
	void testSetQuantity() {
		fail("Not yet implemented");
	}

	@Test
	void testSetDescription() {
		fail("Not yet implemented");
	}

	@Test
	void testSetDiscount() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPreDiscountTotal() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPostDiscountTotal() {
		fail("Not yet implemented");
	}

	@Test
	void testGetOrderData() {
		fail("Not yet implemented");
	}

}
