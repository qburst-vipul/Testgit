package Exceldataprovider.Exceldataprovider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Exceldataprovider.Exceldataprovider.*;


public class DataProviderWithExcel_001  {
	private String sTestCaseName;

//	private int iTestCaseRow;

	WebDriver driver;

 // @BeforeMethod

//  public void beforeMethod() throws Exception {
//	  System.setProperty("webdriver.chrome.driver", "E://Softwares//Automation//Selenium Drivers//chromedriver_win32//chromedriver.exe");
//
//	  driver = new ChromeDriver();
//
//      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//      driver.get("https://staging.daycare2me.com/");	 
//
//  }	
	@Test(priority=0)
public void initialize()
{
	  System.setProperty("webdriver.chrome.driver", "E://Softwares//Automation//Selenium Drivers//chromedriver_win32//chromedriver.exe");

	  driver = new ChromeDriver();

      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

      driver.get("https://staging.daycare2me.com/");
      driver.manage().window().maximize();
      
}
      
  @Test(dataProvider = "Authentication",priority =1)

  public void f(String sUserName, String sPassword) {

	    
	
	    driver.findElement(By.id("user_name")).sendKeys(sUserName);

		System.out.println(sUserName);

	    driver.findElement(By.id("user_password")).sendKeys(sPassword);

		System.out.println(sPassword);

	    driver.findElement(By.id("login_form_btn")).click();

	    System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	    driver.findElement(By.xpath("/html[1]/body[1]/header[1]/nav[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/a[1]/button[1]")).click();

  }

//  @AfterMethod
//
//  public void afterMethod() {
//
//	   driver.close();
//
//  }

  @DataProvider

  public Object[][] Authentication() throws Exception{

	    // Setting up the Test Data Excel file

//	 	ExcelUtils.setExcelFile("C://Users//qbuser//Documents//logincredentialss.xlsx","testdata");
//
//	 	sTestCaseName = this.toString();

	  	// From above method we get long test case name including package and class name etc.

	  	// The below method will refine your test case name, exactly the name use have used

//	  	sTestCaseName = ExcelUtils.getTestCaseName(this.toString());

	    // Fetching the Test Case row number from the Test Data Sheet

	    // Getting the Test Case name to get the TestCase row from the Test Data Excel sheet

//	 	iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,0);

	    Object[][] testObjArray = ExcelUtils.getTableArray("C://Users//qbuser//Documents//logincredentialss.xlsx","testdata");

	    	return (testObjArray);

		}

}