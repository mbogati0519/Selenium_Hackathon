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

public class LoginTo_Salesforce_2{

	public static void main(String[] args) throws Exception {
		String sPath = System.getProperty("user.dir")+"/UsersData.properties";
		
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
		username_field.sendKeys(System.getProperty("username"));//retrieving username from UserData.properties file
		
		WebElement password_field = driver.findElement(By.xpath("//input[@id='password']"));
		password_field.sendKeys(System.getProperty("password"));//retrieving password from UserData.properties file
		
		WebElement login_field = driver.findElement(By.xpath("//input[@id='Login']"));
		login_field.click();
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h2[@id='header']"))));
		WebElement text = driver.findElement(By.xpath("//h2[@id='header']"));
		if(text.getText().equals("Register Your Mobile Phone"))
		{
			System.out.println("Home page is displayed\nThe test is Success");
		}
		else
		{
			System.out.println("The test is a failure");
		}
		driver.quit();
	}

}
