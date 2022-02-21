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
		Order order = new Order();
		
		assertTrue(order.setUnitPrice("3.14"));
		assertEquals(order.unit_price, 3.14f);
		
		assertTrue(order.setUnitPrice("3"));
		assertEquals(order.unit_price, 3.0f);
		
		assertTrue(order.setUnitPrice(".30"));
		assertEquals(order.unit_price, 0.3f);
		
		assertTrue(order.setUnitPrice("$0.31"));
		assertEquals(order.unit_price, 0.31f);
		
		assertTrue(order.setUnitPrice("$3.16"));
		assertEquals(order.unit_price, 3.16f);
		
		assertFalse(order.setUnitPrice(""));
		assertEquals(order.unit_price, 0);
		
		assertFalse(order.setUnitPrice("-3.14"));
		assertEquals(order.unit_price, 0);
		
		assertFalse(order.setUnitPrice("abc"));
		assertEquals(order.unit_price, 0);
		
		assertFalse(order.setUnitPrice("3.18abc"));
		assertEquals(order.unit_price, 0);
		
		assertFalse(order.setUnitPrice("abc3.19"));
		assertEquals(order.unit_price, 0);
		
	}

	@Test
	void testSetQuantity() {
		Order order = new Order();
		
		assertTrue(order.setQuantity("1"));
		assertEquals(order.quantity, 1);
		
		assertFalse(order.setQuantity("-1"));
		assertEquals(order.quantity, 0);
		
		assertFalse(order.setQuantity(""));
		assertEquals(order.quantity, 0);
		
		assertFalse(order.setQuantity("1.1"));
		assertEquals(order.quantity, 0);
		
		assertFalse(order.setQuantity("3.0"));
		assertEquals(order.quantity, 0);
		
		assertFalse(order.setQuantity("abc"));
		assertEquals(order.quantity, 0);
		
		assertFalse(order.setQuantity("1a"));
		assertEquals(order.quantity, 0);
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
