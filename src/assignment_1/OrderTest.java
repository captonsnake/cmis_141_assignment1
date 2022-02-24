package assignment_1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class OrderTest {
	private static Stream<Arguments> integer() {
		return Stream.of(
				Arguments.of("", 0, false),
				Arguments.of(null, 0, false),
				Arguments.of("1234",1234,true),
				Arguments.of("abcd", 0, false),
				Arguments.of("a123", 123, true),
				Arguments.of("-13", 0, false),
				Arguments.of("13.1", 131, true)
				);
	}
	
	@ParameterizedTest
	@MethodSource("integer")
	void testSetCustomerIdStringParams(String s, int i, boolean b) {
		Order order = new Order();
		
		if (b) {
			assertTrue(order.setCustomerID(s));
		} else {
			assertFalse(order.setCustomerID(s));
		}
		assertEquals(order.customer_ID, i);
	}

	@Test
	void testSetCustomerID() {
		Order order = new Order();

		assertTrue(order.setCustomerID("1234"));
		assertEquals(order.customer_ID, 1234);
		
		assertFalse(order.setCustomerID(null));
		assertEquals(order.customer_ID, 0);
		
		assertFalse(order.setCustomerID("abcd"));
		assertEquals(order.customer_ID, 0);
		
		assertFalse(order.setCustomerID(""));
		assertEquals(order.customer_ID, 0);
		
		assertTrue(order.setCustomerID("a123"));
		assertEquals(order.customer_ID, 123);
		
		assertFalse(order.setCustomerID("-13"));
		assertEquals(order.customer_ID, 0);
		
		assertTrue(order.setCustomerID("13.1"));
		assertEquals(order.customer_ID, 131);
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
		
		assertFalse(order.setUnitPrice(null));
		assertEquals(order.unit_price, 0);
		
		assertFalse(order.setUnitPrice(""));
		assertEquals(order.unit_price, 0);
		
		assertFalse(order.setUnitPrice("-3.14"));
		assertEquals(order.unit_price, 0);
		
		assertFalse(order.setUnitPrice("abc"));
		assertEquals(order.unit_price, 0);
		
		assertTrue(order.setUnitPrice("3.18abc"));
		assertEquals(order.unit_price, 3.18f);
		
		assertTrue(order.setUnitPrice("abc3.19"));
		assertEquals(order.unit_price, 3.19f);		
	}

	@Test
	void testSetQuantity() {
		Order order = new Order();
		
		assertTrue(order.setQuantity("1"));
		assertEquals(order.quantity, 1);
		
		assertFalse(order.setQuantity(null));
		assertEquals(order.quantity, 0);
		
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
		
		assertTrue(order.setQuantity("1a"));
		assertEquals(order.quantity, 1);
	}

	@Test
	void testSetDescription() {
		Order order = new Order();
		
		assertTrue(order.setDescription("This is a descript"));
		assertEquals(order.description, "This is a descript");
		
		assertFalse(order.setDescription(null));
		assertEquals(order.description, null);
	}

	@Test
	void testSetDiscount() {
		Order order = new Order();
		
		//many of these tests pass but for the wrong reasons...
		
		assertTrue(order.setDiscount(".10"));
		assertEquals(order.discount, 0.1f);
		
		assertTrue(order.setDiscount("20"));
		assertEquals(order.discount, 0.2f);
		
		assertTrue(order.setDiscount("5"));
		assertEquals(order.discount, 0.05f);
		
		assertTrue(order.setDiscount("25%"));
		assertEquals(order.discount, 0.25f);
		
		assertFalse(order.setDiscount(null));
		assertEquals(order.discount, 0);
		
		assertFalse(order.setDiscount(""));
		assertEquals(order.discount, 0);
		
		assertFalse(order.setDiscount("abc"));
		assertEquals(order.discount, 0);
		
		assertTrue(order.setDiscount(".1k"));
		assertEquals(order.discount, .1f);
		
		assertFalse(order.setDiscount("-10"));
		assertEquals(order.discount, 0);
		
		assertFalse(order.setDiscount("-0.14"));
		assertEquals(order.discount, 0);
		
		assertFalse(order.setDiscount("1.1"));
		assertEquals(order.discount, 0);
	}

	@Test
	void testGetPreDiscountTotal() {
		Order order = new Order();
		
		assertEquals(order.getPreDiscountTotal(), 0);
		
		for(int i = 0; i < 100; i++) {
			for (float j = 0; j < 10; j += 0.01f) {
				float total = i * j;
				order.quantity = i;
				order.unit_price = j;
				assertEquals(order.getPreDiscountTotal(), total);
			}
		}
	}

	@Test
	void testGetPostDiscountTotal() {
		Order order = new Order();
		
		assertEquals(order.getPostDiscountTotal(), 0);
		
		for(int i = 0; i < 100; i++) {
			for (float j = 0; j < 10; j += 0.01) {
				for (float k = 0; k <= 1; k += 0.01f) {
					float total = i * j * (1 - k);
					order.quantity = i;
					order.unit_price = j;
					order.discount = k;
					assertEquals(order.getPostDiscountTotal(), total);
				}
			}
		}
		
		order.unit_price = 1.25f;
		order.quantity = 4;
		order.discount = 0.1f;
		
		assertEquals(order.getPostDiscountTotal(), 4.5f);
		
		order.discount = 0;
		assertEquals(order.getPostDiscountTotal(), 5f);
		
		order.discount = 1;
		assertEquals(order.getPostDiscountTotal(), 0);
	}
}
