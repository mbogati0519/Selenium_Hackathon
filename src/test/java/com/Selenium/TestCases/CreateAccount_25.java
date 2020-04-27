package com.Selenium.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccount_25 extends BrowserUtilityMethods{

	public static void main(String[] args) throws Exception {
		
		LaunchingBrowser();
		SalesforceHomePage();
		Thread.sleep(3000);
		LoginSalesforce();
		
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
		driver.findElement(By.xpath("//input[contains(@name,'new')]")).click();
		Thread.sleep(2000);
		
		ReadingFile();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='name_lastcon2']")).sendKeys(System.getProperty("AccountLastName"));
		Thread.sleep(1000);
		System.out.println("Last name displayed");
		driver.findElement(By.xpath("//input[@id='con4']")).sendKeys(System.getProperty("AccountName"));
		Thread.sleep(1000);
		System.out.println("Account name displayed");
		driver.findElement(By.xpath("//div[contains(@class,'pbHeader')]//input[1]")).click();
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h2[contains(@class,'topName')]"))));
		String name = driver.findElement(By.xpath("//h2[contains(@class,'topName')]")).getText();
		System.out.println("New contact is created.");
		System.out.println("New contact: "+name);
		System.out.println("Success");
		
		UserLoggedOut();
		
	}

}
