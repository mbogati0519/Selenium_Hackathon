package com.Selenium.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ErrorMessage_30 extends BrowserUtilityMethods {

	public static void main(String[] args) throws Exception {
		
		UserLoggedIn();
		
		WebDriverWait wait = new WebDriverWait (driver, 30);
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(text(),'Subscriptions')]"))));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[contains(@class,'allTabsArrow')]")).click();
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@class='listRelatedObject contactBlock title']"))));
		driver.findElement(By.xpath("//a[@class='listRelatedObject contactBlock title']")).click();
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[contains(@name,'new')]"))));
		System.out.println("Contact home page is displayed");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Create New View')]")).click();
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='pbHeader']//input[@name='save']"))));
		driver.findElement(By.xpath("//input[@id='devname']")).sendKeys("EFGH");
		driver.findElement(By.xpath("//div[@class='pbHeader']//input[@name='save']")).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='pbHeader']//input[@name='save']"))));
		
		String actualerrorMsg = "Error: You must enter a value";
		String expectedMsg = driver.findElement(By.xpath("//div[contains(text(),'You must enter a value')]")).getText();
		if(actualerrorMsg.equals(expectedMsg))
		{
			System.out.println(expectedMsg);
			System.out.println("The validdation is successful");
		}
		else
		{
			System.out.println("Failure");
		}
		UserLoggedOut();

	}

}
