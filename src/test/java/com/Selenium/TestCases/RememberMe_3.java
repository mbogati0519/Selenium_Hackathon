package com.Selenium.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RememberMe_3 extends BrowserUtilityMethods{

	public static void main(String[] args) throws Exception {
		
		LaunchingBrowser();
		SalesforceHomePage();
		Thread.sleep(3000);
		LoginSalesforce();
		
		WebDriverWait wait = new WebDriverWait (driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@id='userNavLabel']"))));
		
		driver.findElement(By.xpath("//span[@id='userNavLabel']")).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(text(),'Logout')]"))));
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		
		Thread.sleep(3000);
		String actual_username = "milan.b@salesforce.com";
		String expected_username = driver.findElement(By.xpath("//span[@id='idcard-identity']")).getText();
		
		if(expected_username.equals(actual_username))
		{
			System.out.println(expected_username);
			System.out.println("\nThe username is validated. Success");
		}
		else
		{
			System.out.println("Failure");
		}
		
		driver.quit();
	}

}
