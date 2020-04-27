package com.Selenium.TestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeadSelectView_21 extends BrowserUtilityMethods{

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
		
		WebElement a = driver.findElement(By.xpath("//option[contains(text(),'All Open Leads')]"));
		WebElement b = driver.findElement(By.xpath("//option[contains(text(),'My Unread Leads')]"));
		WebElement c = driver.findElement(By.xpath("//option[contains(text(),'Recently Viewed Leads')]"));
		WebElement d = driver.findElement(By.xpath("//option[contains(text(),\"Today's Leads\")]"));
		WebElement e = driver.findElement(By.xpath("//option[contains(text(),'View - Custom 1')]"));
		//Select drop1 = new Select(leadView);
		if(a!=null && b!=null && c!=null && d!=null && e!=null)
		{
			System.out.println("All elements are Present. They are");
			
		}
		else
		{
			System.out.println("Failure");
		}
		List <WebElement> leadViewlists = driver.findElements(By.xpath("//select[@id='fcf']"));
		for (int count = 0; count <leadViewlists.size(); count++)
		{
			String str = leadViewlists.get(count).getText();
			System.out.println(str);	
		}
		
			UserLoggedOut();	
			
}
}
		
		
		
		
		
		
		
		
		 



