package com.Selenium.TestCases;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginError_Message_1{

	public static void main(String[] args) throws Exception {
		String sPath = System.getProperty("user.dir")+"/UsersData.properties";//file path
		
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(sPath);
		prop.load(file);
		System.getProperties().putAll(prop);
		
		WebDriver driver = null;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); //It will launch the google chrome browser
		driver.manage().window().maximize(); //maximize the window
		driver.get("https://www.salesforce.com/"); // launching salesforce.com website
		
		WebDriverWait wait = new WebDriverWait (driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(text(),'Login')]"))));	
		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='username']"))));
		
		WebElement username_field = driver.findElement(By.xpath("//input[@id='username']"));
		username_field.sendKeys(System.getProperty("username"));//retrieving username from UsersData.properties file
		
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		
		String actual = "Please enter your password.";
		WebElement errorMsg = driver.findElement(By.xpath("//div[@id='error']"));
		if(errorMsg.getText().equals(actual))
		{
			System.out.println(errorMsg.getText());
			System.out.println("The test case is Success");
		}
		else {
			System.out.println("The test case is a failure");
		}
		Thread.sleep(2000);
		
		driver.quit();
	}

}
