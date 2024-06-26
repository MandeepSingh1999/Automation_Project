package Assertion;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class workingwithSoftAssert {
	

	@Test
	public void login()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://desktop-d595gen/login.do");
	
		SoftAssert as = new SoftAssert();
		as.assertEquals(driver.getTitle(),"actiTIME - Lo");
		
		
		driver.findElement(By.name("username")).sendKeys("admin");
		
		as.assertAll();
	}


}
