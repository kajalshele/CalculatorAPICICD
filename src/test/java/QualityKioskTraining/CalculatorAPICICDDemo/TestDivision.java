package QualityKioskTraining.CalculatorAPICICDDemo;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDivision {

	Calculator object;
	int result;

	@BeforeClass
	public void init() {
		object = new Calculator();
	}

	@BeforeMethod
	public void reInitialisation() {
		result = 0;
	}

	@Test(dataProvider = "positiveNumberData")
	public void divisionWithPositiveNumber(int first, int second, int expectedAns) {
		result=object.division(first, second);
		Assert.assertEquals(result, expectedAns, "Division not work with positive number");
	}

	@DataProvider
	public Object[][] positiveNumberData() {
		return new Object[][] {
			{ 25, 5, 5 },
			{ 200, 100, 2 },
			{ 6, 3, 2 } 
			};
	
	}

	@AfterClass
	public void tearDown() {
		object = null;
	}

}
