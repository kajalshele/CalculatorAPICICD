package QualityKioskTraining.CalculatorAPICICDDemo;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SubtractionTestCases {
	Calculator object;
	@BeforeClass
	public void init() {
		object=new Calculator();
	}

	@Test
	public void testSubtractionWithPositiveNumber() {
		int result=object.subtraction(20, 10);
		Assert.assertEquals(result, 10,"Subtraction is not work with positive number");
	}
	
	@Test
	public void testSubtractionWithBothNegativeNumber() {
		int result=object.subtraction(-20, -10);
		Assert.assertEquals(result, -10,"Subtraction is not work with both negative number");
	}
	
	
}
