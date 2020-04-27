package com.Selenium.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogOut_09 extends BrowserUtilityMethods{

	public static void main(String[] args) throws Exception {
		
		LaunchingBrowser();
		SalesforceHomePage();
		Thread.sleep(3000);
		LoginSalesforce();
		
		WebDriverWait wait = new WebDriverWait (driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='userNav-arrow']"))));
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[@id='userNav-arrow']")).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(text(),'Logout')]"))));
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='Login']"))));
		Thread.sleep(2000);
		
		boolean loginPage = driver.findElement(By.xpath("//input[@id='Login']")).isDisplayed();
		if(loginPage==true)
		{
			System.out.println("Login Page is displayed. Success");
		}
		else
		{
			System.out.println("Failure");
		}
		driver.quit();

	}

}
