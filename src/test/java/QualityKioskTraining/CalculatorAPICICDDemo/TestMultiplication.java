package QualityKioskTraining.CalculatorAPICICDDemo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestMultiplication {
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
	public void multiplicationWithPositiveNumber(int first, int second, int expectedAns) {
		result=object.multiplication(first, second);
		Assert.assertEquals(result, expectedAns, "multiplication not work with positive number");
	}

	@DataProvider
	public Object[][] positiveNumberData() {
		return new Object[][]{
			{ 25, 5, 125 }, 
			{ 200, 100, 20000 }, 
			{ 1000, 3000, 3000000 } 
			};
	}

	@AfterClass
	public void tearDown() {
		object = null;
	}
	
	@BeforeSuite
	@Parameters({"RequestID"})
	public void createResultFolder(String RequestID) {
		try {
			Files.createDirectories(Paths.get("./"+RequestID));
		} catch (IOException e) {
		System.out.println("There is problem  to create folder");
		}
	}
	
	@AfterSuite
	@Parameters({"RequestID"})
	public void copyReportFile(String RequestID) {
		try {
			Files.copy(Paths.get(".\\target\\surefire-reports\\emailable-report.html"), Paths.get("./"+RequestID+"/Report.html"),StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			System.out.println("Not able to perform the task");}
	}

}
