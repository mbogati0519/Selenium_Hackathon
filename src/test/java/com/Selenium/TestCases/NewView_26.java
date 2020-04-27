package com.Selenium.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewView_26 extends BrowserUtilityMethods{

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
		
		driver.findElement(By.xpath("//a[contains(text(),'Create New View')]")).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h2[@class='pageDescription']"))));
		System.out.println("New view Page displayed");
		
		ReadingFile();
		driver.findElement(By.xpath("//input[@id='fname']")).sendKeys(System.getProperty("ViewName"));
		Thread.sleep(1000);
		System.out.println("View name displayed");
		driver.findElement(By.xpath("//input[@id='devname']")).sendKeys(System.getProperty("UniqueViewName"));
		Thread.sleep(1000);
		System.out.println("Unique view name entered");
		driver.findElement(By.xpath("//div[@class='pbHeader']//input[@name='save']")).click();
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[contains(@name,'newContact')]"))));
		System.out.println("Contact home page is displayed");
		
		WebElement viewName = driver.findElement(By.xpath("//option[contains(text(),'Mountain')]"));
		if(viewName.isDisplayed())
		{
			System.out.println("Created View Name is displayed");
			System.out.println("Success");
		}
		else
		{
			System.out.println("Failure");
		}
		UserLoggedOut();
	}

}
