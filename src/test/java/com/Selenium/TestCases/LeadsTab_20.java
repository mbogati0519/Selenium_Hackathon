package com.Selenium.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeadsTab_20 extends BrowserUtilityMethods {

	public static void main(String[] args) throws Exception {
		
		LaunchingBrowser();
		SalesforceHomePage();
		Thread.sleep(3000);
		LoginSalesforce();
		
		WebDriverWait wait = new WebDriverWait (driver, 30);
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(text(),'Subscriptions')]"))));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[contains(@class,'allTabsArrow')]")).click();
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@class='listRelatedObject leadBlock title']"))));
		driver.findElement(By.xpath("//a[@class='listRelatedObject leadBlock title']")).click();
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h2[contains(@class,'pageDescription')]"))));
		String HomePage = driver.findElement(By.xpath("//h2[contains(@class,'pageDescription')]")).getText();
		if(HomePage.equals("Home"))
		{
			System.out.println(HomePage);
			System.out.println("Leads Home page is displayed. Success");
		}
		else
		{
			System.out.println("Failure");
		}
		
		UserLoggedOut();
	}

}
