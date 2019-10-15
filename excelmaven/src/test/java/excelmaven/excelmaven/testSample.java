package excelmaven.excelmaven;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testSample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		excelreadoperation e = new excelreadoperation();
		ArrayList data = e.getData("Valid case");
		System.setProperty("webdriver.chrome.driver", "E://Softwares//Automation//Selenium Drivers//chromedriver_win32//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://staging.daycare2me.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("user_name")).sendKeys((data.get(1).toString()));
		driver.findElement(By.id("user_password")).sendKeys(data.get(2).toString());
		driver.findElement(By.id("login_form_btn")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		
		driver.findElement(By.xpath("//button[@class='btn btn-orange']")).click();
				
		ArrayList data1 = e.getData("Invalid case");
		driver.findElement(By.id("user_name")).sendKeys((data1.get(1).toString()));
		driver.findElement(By.id("user_password")).sendKeys(data1.get(2).toString());
		driver.findElement(By.id("login_form_btn")).click();
		
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		System.out.println(data.get(2));

	}

}
