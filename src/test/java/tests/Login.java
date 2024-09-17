package tests;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class Login {
	WebDriver driver;
	
	@AfterMethod
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
	
	}
	@Test(dataProvider = "TestData1")
	public void verifyLogin(String email,String password) {
		
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.get("https://tutorialsninja.com/demo/");
		
		WebElement myaccountDropMenu = driver.findElement(By.xpath("//span[text()='My Account']"));
		myaccountDropMenu.click();
		
		WebElement loginOption = driver.findElement(By.linkText("Login"));
		loginOption.click();
		
		WebElement emailText = driver.findElement(By.xpath("//input[@name='email']"));
		emailText.sendKeys(email);
		
		WebElement pwdText = driver.findElement(By.xpath("//input[@name='password']"));
		pwdText.sendKeys(password);
		
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Edit your account information']")).isDisplayed());
		driver.quit();
	}
	
	@DataProvider(name="TestData1")
  public Object[][] testDataSupply() {
	  Object[][] data= {{"mahendrareddy2495@gmail.com","Reddy@123"},{"abcd@gmail.com","12345"},{"zxcv@gmail.com","qwer"}};
	  return data;
  }
}
