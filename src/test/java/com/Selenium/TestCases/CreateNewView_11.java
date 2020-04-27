package com.Selenium.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateNewView_11 extends BrowserUtilityMethods{

	public static void main(String[] args) throws Exception {
		
		LaunchingBrowser();
		SalesforceHomePage();
		Thread.sleep(3000);
		LoginSalesforce();
		
		WebDriverWait wait = new WebDriverWait (driver, 30);
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//img[contains(@class,'allTabsArrow')]"))));
		driver.findElement(By.xpath("//img[contains(@class,'allTabsArrow')]")).click();
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(@class,'listRelatedObject accountBlock title')]"))));
		driver.findElement(By.xpath("//a[contains(@class,'listRelatedObject accountBlock title')]")).click();
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"))));
		driver.findElement(By.xpath("//a[contains(text(),'Create New View')]")).click();
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='fname']"))));
		ReadingFile();
		driver.findElement(By.xpath("//input[@id='fname']")).sendKeys(System.getProperty("ViewName"));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='devname']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='devname']")).sendKeys(System.getProperty("ViewUniqueName"));
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@class='pbHeader']//input[@name='save']")).click();
		Thread.sleep(2000);
		
		System.out.println("The view is displayed. Success");
		driver.quit();
	}

}
