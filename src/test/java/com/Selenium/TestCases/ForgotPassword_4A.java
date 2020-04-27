package com.Selenium.TestCases;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPassword_4A extends BrowserUtilityMethods{

	public static void main(String[] args) throws Exception {
		
		LaunchingBrowser() ;
		SalesforceHomePage();
		
		WebDriverWait wait = new WebDriverWait (driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@id='forgot_password_link']"))));
		
		driver.findElement(By.xpath("//a[@id='forgot_password_link']")).click();
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='continue']"))));
		String sPath = System.getProperty("user.dir")+"/UsersData.properties";
		
		try {
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(sPath);
		prop.load(file);
		System.getProperties().putAll(prop);
		}catch (Exception a) {
		System.out.println(a);	
		}
		
		WebElement usernamefield1 = driver.findElement(By.xpath("//input[@id='un']"));
		usernamefield1.sendKeys(System.getProperty("username"));
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@class='primary button wide mb16']"))));
		
		String actualtext = "Check Your Email";		
		String expectedtext = driver.findElement(By.xpath("//h2[@id='header']")).getText();
		if(expectedtext.equals(actualtext))
		{
			System.out.println(expectedtext);
			System.out.println("\nSuccess");
		}
		else
		{
			System.out.println("Failure");
		}
		driver.quit();
		
	}

}
