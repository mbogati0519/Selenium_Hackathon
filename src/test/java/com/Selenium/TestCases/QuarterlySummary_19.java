package com.Selenium.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QuarterlySummary_19 extends BrowserUtilityMethods{

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
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@class='listRelatedObject opportunityBlock title']"))));
		driver.findElement(By.xpath("//a[@class='listRelatedObject opportunityBlock title']")).click();
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(text(),'Opportunity Pipeline')]"))));
		System.out.println("Opportunity Home Page dispalyed");
		
		WebElement interval = driver.findElement(By.xpath("//select[@id='quarter_q']"));
		Select drop1 = new Select(interval);
		drop1.selectByIndex(5);
		Thread.sleep(1000);
		
		WebElement include = driver.findElement(By.xpath("//select[@id='open']"));
		Select drop2 = new Select(include);
		drop2.selectByIndex(1);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//table[@class='opportunitySummary']//input[@name='go']")).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[contains(@class,'noSecondHeader pageType')]"))));
		
		System.out.println(driver.findElement(By.xpath("//strong[contains(text(),'Grand Totals (13 records)')]")).getText());
		System.out.println("Records found. Success");
		
		driver.quit();	

	}

}
