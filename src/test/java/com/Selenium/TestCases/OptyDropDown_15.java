package com.Selenium.TestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OptyDropDown_15 extends BrowserUtilityMethods{

	public static void main(String[] args) throws Exception {
		
		LaunchingBrowser();
		SalesforceHomePage();
		Thread.sleep(3000);
		LoginSalesforce();
		
		WebDriverWait wait = new WebDriverWait (driver, 30);
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//img[contains(@class,'allTabsArrow')]"))));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[contains(@class,'allTabsArrow')]")).click();
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@class='listRelatedObject opportunityBlock title']"))));
		driver.findElement(By.xpath("//a[@class='listRelatedObject opportunityBlock title']")).click();
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//select[@id='fcf']"))));
		
		WebElement a = driver.findElement(By.xpath("//option[contains(text(),'Closing This Month')]"));
		WebElement b = driver.findElement(By.xpath("//option[contains(text(),'All Opportunities')]"));
		WebElement c = driver.findElement(By.xpath("//option[contains(text(),'Closing Next Month')]"));
		WebElement d = driver.findElement(By.xpath("//option[contains(text(),'My Opportunities')]"));
		WebElement e = driver.findElement(By.xpath("//option[contains(text(),'New Last Week')]"));
		WebElement f = driver.findElement(By.xpath("//option[contains(text(),'New This Week')]"));
		WebElement g = driver.findElement(By.xpath("//option[contains(text(),'Opportunity Pipeline')]"));
		WebElement h = driver.findElement(By.xpath("//option[contains(text(),'Opportunity Pipeline')]"));
		WebElement i = driver.findElement(By.xpath("//option[contains(text(),'Recently Viewed Opportunities')]"));
		WebElement j = driver.findElement(By.xpath("//option[contains(text(),'Won')]"));
		if(a!=null && b!=null && c!=null && d!=null && e!=null && f!=null && g!=null && h!=null && i!=null && j!=null)
		{
			System.out.println("All elements are Present. They are");
		}
		else
		{
			System.out.println("Failure");
		}
		List <WebElement> optylist = driver.findElements(By.xpath("//select[@id='fcf']"));
		for (int count = 0; count < optylist.size(); count++)
		{
			System.out.println(optylist.get(count).getText());
		}
		Thread.sleep(2000);
		
		driver.quit();
	}

}
