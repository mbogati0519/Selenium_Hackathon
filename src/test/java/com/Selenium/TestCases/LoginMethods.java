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

public class LoginMethods {

		public static WebDriver driver = null;
		
		public static void UserLoggedIn()
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(); //It will launch the google chrome browser
			driver.manage().window().maximize(); //maximize the window
			
			driver.get("https://www.salesforce.com/"); // launching salesforce.com website
			
			WebDriverWait wait = new WebDriverWait (driver, 30);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(text(),'Login')]"))));
			
			driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
			String sPath = System.getProperty("user.dir")+"/UsersData.properties";
			
			try {
			Properties prop = new Properties();
			FileInputStream file = new FileInputStream(sPath);
			prop.load(file);
			System.getProperties().putAll(prop);
			}catch (Exception a) {
			System.out.println(a);	
			}
			//WebDriverWait wait = new WebDriverWait (driver, 30);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='username']"))));
			
			WebElement username_field = driver.findElement(By.xpath("//input[@id='username']"));
			username_field.sendKeys(System.getProperty("username"));
			
			WebElement password_field = driver.findElement(By.xpath("//input[@id='password']"));
			password_field.sendKeys(System.getProperty("password"));
			
			WebElement remember_me =driver.findElement(By.xpath("//input[@id='rememberUn']"));
			remember_me.click();
			
			WebElement login_field = driver.findElement(By.xpath("//input[@id='Login']"));
			login_field.click();
			System.out.println("User Login Successful.");
			
		}
		public static void UserLoggedOut()
		{
			driver.findElement(By.xpath("//span[@id='userNavLabel']")).click();
			try {
			Thread.sleep(1000);
			}catch (Exception a){
				System.out.println(a);
			}
			WebDriverWait wait = new WebDriverWait (driver, 30);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(text(),'Logout')]"))));
			driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
			System.out.println("User Logout Successful");
			driver.quit();
			
		}
	}


