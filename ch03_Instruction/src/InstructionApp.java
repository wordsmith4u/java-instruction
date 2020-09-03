import java.math.BigDecimal;

public class InstructionApp {

	public static void main(String[] args) {
		double x = 10.315;
		x = (double) Math.round(x * 100) / 100; // rounding using a double

		System.out.println(x);

		BigDecimal pi = new BigDecimal("3.14159");
		BigDecimal myBD = new BigDecimal("56.0");
		myBD = myBD.add(pi);

		System.out.println(myBD);

	}
}

// int parsedInt = Integer.parseInt("123");
// working with constructors
//		System.out.println(parsedInt);

//	}
//}

// Unary Operations
/*
 * int a = 10; a++;
 */

/*
 * System.out.println(a);
 * 
 * int b = 10; b--;
 * 
 * System.out.println(b);
 * 
 * // monthly investment
 * 
 * double curVal = 5000.0; double monthVal = 100.0; double yearlyIntRate = 0.12;
 * 
 * curVal = (curVal + monthVal) * (1 + (yearlyIntRate / 12));
 * 
 * System.out.println(curVal);
 * 
 * }
 * 
 * }
 */
