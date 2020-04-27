package com.Selenium.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DefaultView_22 extends BrowserUtilityMethods{

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
		System.out.println("Leads Home Page is displayed");
		
		WebElement viewLeads = driver.findElement(By.xpath("//select[@id='fcf']"));
		Select drop = new Select(viewLeads);
		drop.selectByIndex(1);
		Thread.sleep(1000);
		
		UserLoggedOut();
		Thread.sleep(3000);
		System.out.println("Login page is displayed");
		
		LaunchingBrowser();
		SalesforceHomePage();
		Thread.sleep(3000);
		LoginSalesforce();
		
		//WebDriverWait wait = new WebDriverWait (driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(text(),'Subscriptions')]"))));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[contains(@class,'allTabsArrow')]")).click();
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@class='listRelatedObject leadBlock title']"))));
		driver.findElement(By.xpath("//a[@class='listRelatedObject leadBlock title']")).click();
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h2[contains(@class,'pageDescription')]"))));
		System.out.println("Leads Home Page is displayed");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[@class='fBody']//input[@name='go']")).click();
		Thread.sleep(2000);
		
		if( driver.findElement(By.xpath("//option[contains(text(),'My Unread Leads')]")).isDisplayed())
		{
			System.out.println("Dafault view is selected and the view page is displayed");
			System.out.println("Success");
		}
			
		UserLoggedOut();
		
		
		
		
		
		
		
		
		
		
		
		
		
		UserLoggedOut();
		

	}

	private static void LeadLogin() {
		// TODO Auto-generated method stub
		
	}

}
