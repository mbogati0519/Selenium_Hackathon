package com.Selenium.TestCases;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginErrorMessage_4B extends BrowserUtilityMethods{

	public static void main(String[] args) throws Exception {
		
		LaunchingBrowser();
		SalesforceHomePage();
		Thread.sleep(2000);
		String sPath = System.getProperty("user.dir")+"/UsersData.properties";
		
		try {
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(sPath);
		prop.load(file);
		System.getProperties().putAll(prop);
		}catch (Exception a) {
		System.out.println(a);	
		}
		
		WebElement username_field = driver.findElement(By.xpath("//input[@id='username']"));
		username_field.sendKeys(System.getProperty("WrongUserName"));
		
		WebElement password_field = driver.findElement(By.xpath("//input[@id='password']"));
		password_field.sendKeys(System.getProperty("WrongPassword"));
		Thread.sleep(2000);
		//WebElement remember_me =driver.findElement(By.xpath("//input[@id='rememberUn']"));
		//remember_me.click();
		
		WebElement login_field = driver.findElement(By.xpath("//input[@id='Login']"));
		login_field.click();
		
		WebDriverWait wait = new WebDriverWait (driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='Login']"))));
		
		String expected_errorMessage = "Please check your username and password. If you still can't "
				+ "log in, contact your Salesforce administrator.";
		String actual_errorMessage = driver.findElement(By.xpath("//div[@id='error']")).getText();
		if(actual_errorMessage.equals(expected_errorMessage))
		{
			System.out.println(actual_errorMessage);
			System.out.println("Success");
		}
		else
		{
			System.out.println("Failure");
		}
		driver.quit();
	}

}
