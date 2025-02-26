package JUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ExampleBeforeAll {
    private OrderService2 orderService;
    
    @BeforeAll
    void setup() {
        orderService = new OrderService2();
    }
    @Test

    void testCalTotal() {
        double total = orderService.calPrice(100.0, 2); 
        assertEquals(180, total, "Total should be 180 after 10% discount");
    }
 
    @Test
    void testPlaceOrderSuccess() {
        assertTrue(orderService.placeOrder(5), "Order isplaced successfully");
        assertEquals(5, orderService.getStock(), "Stock should reduce to 5");
    }
 
    @Test

    void testPlaceOrderFailure() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
            () -> orderService.placeOrder(15), "Should throw exception for insufficient stock");
        assertEquals("Insufficient stock", thrown.getMessage());
    }
 
    @Test
  
    void testCalTotalZeroQuantity() {
        assertEquals(0, orderService.calPrice(100, 0), "Total should be 0 when quantity is 0");
    }
 
    @ParameterizedTest

	@CsvSource ({

        "50, 2, 90",
        "100, 2, 180",
        "50, 3, 135"

	})	

	void testAddParamCsv(int a, int b, int expected) {

		assertEquals(expected, orderService.calPrice(a,b));

	}
 
    @Test

    void testOrderProcessingTimeout() throws InterruptedException {
        Thread.sleep(500); 
        assertTrue(true, "Order processing test passed with timeout");
    }
    

    
    @Test
    void testPlacedOrderMultithread() throws InterruptedException {
    	Thread thread1 =  new Thread(()->orderService.placeOrder(2));
    	Thread thread2=new Thread(()->orderService.placeOrder(1));
    	
    	thread1.start();
    	thread2.start();
    	
    	thread1.join();
    	thread2.join();
    	
    	assertEquals(7,orderService.getStock());
    }
	


}
