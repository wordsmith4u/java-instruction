package java_misc.test;

//import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

import java_misc.MathUtils;

class MathUtilsTest {

	@Test
	public void testMin() {
		int min = MathUtils.min(10, 20);
		Assertions.assertEquals(10, min);
	}

	@Test
	public void testMax() {
		int max = MathUtils.max(10, 20);
		Assertions.assertEquals(20, max);
	}

	@Test
	public void testPower() {
		int cubed = MathUtils.power(2, 3);
		Assertions.assertEquals(8, cubed);
	}

	@Test
	public void testSum() {
		int sum = MathUtils.sum(1, 2, 3);
		Assertions.assertEquals(6, sum);
	}

	@Test
	public void testSumThrowsException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> MathUtils.sum());
	}
}
