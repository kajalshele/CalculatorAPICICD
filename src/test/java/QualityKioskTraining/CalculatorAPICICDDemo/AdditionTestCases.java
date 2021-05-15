package QualityKioskTraining.CalculatorAPICICDDemo;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdditionTestCases {
	Calculator object;
	int result;
	
	@BeforeClass
	public void init() {
		object=new Calculator();
	}
	
	@BeforeGroups("RegressionTest")
	public void initBeforGroup() {
		object=new Calculator();
	}
	@BeforeMethod
	public void reinitialisedResultVar() {
		result=0;
	}
	
	@Test(priority=1,groups="RegressionTest")
	public void testAdditionWithPositiveNumber() {
		result=object.addition(10,20);
		Assert.assertEquals(result, 30,"addition does not work with positive number");
	}
	
	@Test(priority=3,groups="RegressionTest")
	public void testAdditionWithOneNegativeNumber() {
		result=object.addition(-10, 20);
		Assert.assertEquals(result, 10,"Addition does not work with negative number");
	}
	
	
	
	@Test(priority=2)
	public void testAdditionWithBothNegativeNumber() {
		int result=object.addition(-10, -20);
		Assert.assertEquals(result, -30,"Addition does not work with both negative number");
	}
	@AfterClass
	public void tearDown() {
		object=null;
	}


}
