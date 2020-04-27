package com.Selenium.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyContactView_28 extends BrowserUtilityMethods {

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
		
		WebElement view = driver.findElement(By.xpath("//select[@id='fcf']"));
		Select drop = new Select(view);
		drop.selectByIndex(5);
		Thread.sleep(2000);
		
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[contains(@name,'newContact')]"))));
		WebElement lastAdded = driver.findElement(By.xpath("//div[@id='0035w000033oHeV_FULL_NAME']//span[contains(text(),'lastname')]"));
		if(lastAdded.getText().equals("lastname"))
		{
			System.out.println("Contacts view is displayed");
			System.out.println("Success");
		}
		else
		{
			System.out.println("Failure");
		}
		UserLoggedOut();

	}

}
