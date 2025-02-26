package JUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

	@Test
	void testAdd() {
		
		Calculator calc = new Calculator();
		assertEquals(15,calc.add(5,10));
		
	}

	@Test
	void testSub() {
		
		Calculator calc = new Calculator();
		assertEquals(5,calc.sub(10,5));
		
	}

}
