package com.Selenium.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewContact_29 extends BrowserUtilityMethods{

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
		Thread.sleep(2000);
		
		String contactListName = driver.findElement(By.xpath("//tr[contains(@class,'dataRow even first')]//a[contains(text(),'lastname')]")).getText();
		System.out.println(contactListName);
		driver.findElement(By.xpath("//tr[contains(@class,'dataRow even first')]//a[contains(text(),'lastname')]")).click();
		Thread.sleep(1000);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h2[contains(@class,'topName')]"))));
		String pageName =driver.findElement(By.xpath("//h2[contains(@class,'topName')]")).getText();
		System.out.println(pageName);
		
		if(contactListName.equals(pageName))
		{
			System.out.println(contactListName);
			System.out.println("Contact Page with contact name is displayed");
			System.out.println("All information about the contact is displayed");
		}
		else
		{
			System.out.println("Failure");
		}
		UserLoggedOut();
	}

}
