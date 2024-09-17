package tests;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Register {
	@Test
	public void verifyRegisterWithAllFields() {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.get("https://tutorialsninja.com/demo/");
		
		WebElement myaccountDropMenu = driver.findElement(By.xpath("//span[text()='My Account']"));
		myaccountDropMenu.click();
		
		WebElement register = driver.findElement(By.xpath("//a[text()='Register']/parent::li"));
		register.click();
		
		
		WebElement firstName=driver.findElement(By.xpath("//input[@id='input-firstname']"));
		firstName.sendKeys("abcd");
		
		WebElement lastName=driver.findElement(By.xpath("//input[@id='input-lastname']"));
		lastName.sendKeys("efgh");
		
		WebElement email=driver.findElement(By.xpath("//input[@id='input-email']"));
		
		email.sendKeys(generatedEmailWithTimeStam());
		
		WebElement telephone=driver.findElement(By.xpath("//input[@id='input-telephone]"));
		
		telephone.sendKeys("12345678090");
		
		
		
		WebElement password=driver.findElement(By.xpath("//input[@id='input-password']"));
		password.sendKeys("12345");
		
		WebElement passwordcnfm=driver.findElement(By.xpath("//input[@id='input-confirm']"));
		passwordcnfm.sendKeys("12345");
		
		WebElement Newsletter = driver.findElement(By.xpath("//input[@value='0']"));
		Newsletter.click();
		
		WebElement agreeBox = driver.findElement(By.xpath("//input[@name='agree']"));
		agreeBox.click();
		
		
		WebElement continueFriend = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueFriend.click();
		
		
	}
	
	
	public String generatedEmailWithTimeStam() {
		
		Date date=new Date();
		
		return date.toString().replace(" ", "_").replace(":", "_")+"@gmail.com";
		
	}

}
