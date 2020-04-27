package com.Selenium.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckSaveButtons_32 extends BrowserUtilityMethods{

	public static void main(String[] args) throws Exception {
		
		UserLoggedIn();
		
		WebDriverWait wait = new WebDriverWait (driver, 30);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[contains(@class,'allTabsArrow')]")).click();
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@class='listRelatedObject contactBlock title']"))));
		driver.findElement(By.xpath("//a[@class='listRelatedObject contactBlock title']")).click();
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[contains(@name,'new')]"))));
		System.out.println("Contact home page is displayed");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[contains(@name,'new')]")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@name='save']"))));
		System.out.println("Contact Edit page is displayed");
		
		driver.findElement(By.xpath("//input[@id='name_lastcon2']")).sendKeys("Indian");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='con4']")).sendKeys("Global Media");
		Thread.sleep(1000);
		System.out.println("Last name and account name is entered");
		
		driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@name='save_new']")).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@name='save_new']"))));
		String errormsg= "Error: Invalid Data. Review all error messages below to correct your data.";
		String msg = driver.findElement(By.xpath("//div[@id='errorDiv_ep']")).getText();
		if(msg.contains("Error"))
		{
			System.out.println(msg);
			System.out.println("Page not displayed. Failure");
		}
		else
		{
		System.out.println(msg);
		System.out.println("Success");
		
		}
		UserLoggedOut();
	}

}
