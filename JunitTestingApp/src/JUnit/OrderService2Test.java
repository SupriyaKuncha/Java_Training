package JUnit;
 
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
 
class OrderService2Test {
 
    private OrderService2 orderService2;
 
    @BeforeEach
    void setup() {
        orderService2 = new OrderService2();
        System.out.println("test completed");
    }
 
    @Test
    public void testCalPrice_ValidInputs() {
        double price = 100.00;
        int quantity = 2;
        double expectedPrice = price * quantity * (1 - orderService2.getDiscount());
        assertEquals(expectedPrice, orderService2.calPrice(price, quantity));
    }
 
    @Test
    public void testPlaceOrderSuccess() {
        assertTrue(orderService2.placeOrder(5));
        assertEquals(5, orderService2.getStock());
    }
 
    @Test
    public void OrderZeroQuantity() {
        assertEquals(0, orderService2.calPrice(100, 0));
    }
 

    @Test
    public void compareStock() {
        assertTrue(orderService2.placeOrder(10));
        assertEquals(0, orderService2.getStock());
    }
 
    @Test
    public void JustBelowStock() {
        assertTrue(orderService2.placeOrder(9));
        assertEquals(1, orderService2.getStock());
    }
    
    // ------------------------ Exceptional Cases -----------------------------
 	// place order beyond stock
 	// set stock -> -ve stock
 	// set discount -> (0-1), 1.5 ->
 	// negative price
 	// negative quantity	
    //-------------------------------------------------------------------------
    
 // place order beyond stock   
    @Test
    public void InsufficientStock() {
       int quantity = 12;
        assertThrows(IllegalArgumentException.class, () -> {
            orderService2.placeOrder(quantity);
        });
        
    }
    
    //negative stock
    @Test
    public void negativeStock() {
    	int stock = -1;
        assertThrows(IllegalArgumentException.class, () -> {
            orderService2.setStock(stock);
        });
    	
    }
    
	// set discount -> (0-1), 1.5 ->
    @Test
    public void discountException() {
    	double discount = 1.5;
        assertThrows(IllegalArgumentException.class, () -> {
            orderService2.setDiscount(discount);
        });
    	
    }
 	// negative price
    @Test
    public void OrderNegativePrice() {
        double price = -100.00;
        int quantity = 2;
        assertThrows(IllegalArgumentException.class, () -> {
            orderService2.calPrice(price, quantity);
        });
    }

 	// negative quantity
    @Test
    public void OrderNegativeQuantity() {
        int quantity = -1;
        assertThrows(IllegalArgumentException.class, () -> {
        	orderService2.placeOrder(quantity);
        });
    }
    
    // ********************** parameterized test **************************************
    
    @ParameterizedTest
    @CsvSource({
        "50, 2, 90",
        "100, 2, 180",
        "50, 3, 135" ,
        "100, 1, 90"
    })
    public void CalPriceValidInputs(double price, int quantity, double expected) {
        assertEquals(expected, orderService2.calPrice(price, quantity));
    }
 
    @ParameterizedTest
    @ValueSource(ints = {1, 4, 7, 10})
    public void ValidOrderPlacements(int quantity) {
        assertTrue(orderService2.placeOrder(quantity));
    }
 
    @ParameterizedTest
    @ValueSource(ints = {11, 13, 15})
   
    public void ConditionsForPlacingOrders(int quantity) {
        assertThrows(IllegalArgumentException.class, () -> {
            orderService2.placeOrder(quantity);
        });
    }
 
    @ParameterizedTest
    @ValueSource(doubles = {-0.5, 1.5, 2.0})
    
    public void InvalidDiscountValues(double discount) {
        assertThrows(IllegalArgumentException.class, () -> {
            orderService2.setDiscount(discount);
        });
    }
 
    @ParameterizedTest
    @ValueSource(ints = {-5, -10, -15})
    
    public void InvalidStockValues(int stock) {

        assertThrows(IllegalArgumentException.class, () -> {
            orderService2.setStock(stock);
        });
    }
 
    @ParameterizedTest
    @CsvSource({
        "-100.0, 5",
        "100.0, -5",
        "-50.0, -2"
    })
    public void testCalculatePrice_NegativeValues_ThrowsException(double price, int quantity) {
	
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            orderService2.calPrice(price, quantity);
        });
        assertTrue(exception.getMessage().contains("cannot be negative"));
    }

    //methodsource
   // --------------------------------------------------------------------------------------------------- 
    static Stream<Integer> validStockValues(){
    	return Stream.of(0,10,20,30);
    	
    }
    
    @ParameterizedTest
    @MethodSource("validStockValues")
    public void testValidStockValues(int Stock) {
    	orderService2.setStock(Stock);
    	assertEquals(Stock,orderService2.getStock());
    }
    
 // -------------------------------------------------------------------------------------------------------
    static Stream<Arguments> testValidInputs() {
    	
    	return Stream.of(

    			org.junit.jupiter.params.provider.Arguments.of(100.00,2,180.0),
    			org.junit.jupiter.params.provider.Arguments.of(100.00,3,270.0),
    			org.junit.jupiter.params.provider.Arguments.of(100.00,4,360.0)
    			
    			);	
    	
    }
    @ParameterizedTest
    @MethodSource("testValidInputs")
    public void testValidInputs(double price, int quantity, double expected) {
    	double calTotalPrice=orderService2.calPrice(price, quantity);
    	assertEquals(expected, calTotalPrice);
    }
  
 // ----------------------------------------------------------------------------------------------------------------

    static Stream<Arguments> calPriceNegativeValues() {
    	
    	return Stream.of(

    			org.junit.jupiter.params.provider.Arguments.of(-100.0, 5),
    			org.junit.jupiter.params.provider.Arguments.of(100.0, -5),
    			org.junit.jupiter.params.provider.Arguments.of(-50.0, -2)
    			
    			);	
    	
    }
    @ParameterizedTest
    @MethodSource("calPriceNegativeValues")
  public void calPriceNegativeValues(double price, int quantity) {
	
      Exception exception = assertThrows(IllegalArgumentException.class, () -> {
          orderService2.calPrice(price, quantity);
      });
      assertTrue(exception.getMessage().contains("cannot be negative"));
  }
// ---------------------------------------------------------------------------------------------------------------
    
    static Stream<Integer> ValidOrderPlacement(){
    	return Stream.of(1, 4, 7, 10);
    	
    }
    @ParameterizedTest
    @MethodSource("ValidOrderPlacement")
  public void ValidOrderPlacement(int quantity) {
  assertTrue(orderService2.placeOrder(quantity));
}  
    
// ----------------------------------------------------------------------------------
    static Stream<Integer> ForPlacingOrders(){
    	return Stream.of(11, 13, 15);
    	
    }
    
    @ParameterizedTest
    @MethodSource("ForPlacingOrders")
    public void ForPlacingOrders(int quantity) {
        assertThrows(IllegalArgumentException.class, () -> {
            orderService2.placeOrder(quantity);
        });
    }
    
    
    // ------------------------------------------------------------------------------------------
    static  Stream<Double> InvalidDiscountValue(){
    	return Stream.of(-0.5, 1.5, 2.0);
    	
    }
    
    @ParameterizedTest
    @MethodSource("InvalidDiscountValue")
    
    public void InvalidDiscountValue(double discount) {
        assertThrows(IllegalArgumentException.class, () -> {
            orderService2.setDiscount(discount);
        });
    }
    // ---------------------------------------------------------------------------------------------------
 
    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("Before all tests");
    }
    @AfterAll
    public static void afterAllTests() {
        System.out.println("After all");
    }
    @AfterEach
    public void afterEachTest() {
        System.out.println("test completed");
    }

    @Test
    @Disabled("Test disabled for demonstration purposes")
    public void testDisabled() {
        System.out.println("This test is disabled and will not run");
    }
 
}