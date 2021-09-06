package saucedemoPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


@Test
public class locked_user_saucedemo 
{

	WebDriver driver;
	public void browseURl() throws Exception
	{
		
		System.setProperty("webdriver.chrome.driver", "/Users/apple/SeleniumProject/com.seleniumTestProject/chromedriver 2");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(3,TimeUnit.SECONDS);
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
	}
	public void login() throws Exception {
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("locked_out_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		String text=driver.findElement(By.xpath("//h3[@data-test=\"error\"]")).getText();
		System.out.println(text);
	
		
	}
	@AfterTest
	public void close() throws Exception
	{
		
		driver.close();
	}

}
