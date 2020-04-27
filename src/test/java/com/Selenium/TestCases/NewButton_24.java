package com.Selenium.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewButton_24 extends BrowserUtilityMethods{

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
		
		driver.findElement(By.xpath("//input[@name='new']")).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(@class,'pbHeader')]//input[1]"))));
		
		ReadingFile();
		driver.findElement(By.xpath("//input[@id='name_lastlea2']")).sendKeys(System.getProperty("LastName"));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='lea3']")).sendKeys(System.getProperty("CompanyName"));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(@class,'pbHeader')]//input[1]")).click();
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h2[contains(text(),'Lead Detail')]"))));
		System.out.println("Newly created view page is displayed");
		String str = driver.findElement(By.xpath("//h2[@class='topName']")).getText();
		System.out.println("Newly saved lead is: "+str);
		System.out.println("Success");
		
		UserLoggedOut();
		
		
	}

}
