package com.Selenium.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactCheck_27 extends BrowserUtilityMethods{

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
		
		WebElement topdown = driver.findElement(By.xpath("//select[@id='hotlist_mode']"));
		Select drop = new Select(topdown);
		drop.selectByIndex(0);
		Thread.sleep(1000);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h3[contains(text(),'Recent Contacts')]"))));
		String recentlyCreated = "lastname";
		String displayed = driver.findElement(By.xpath("//tr[contains(@class,'dataRow even first')]//a[contains(text(),'lastname')]")).getText();
		if(displayed.equals(recentlyCreated))
		{
			System.out.println(displayed);
			System.out.println("Recently created contact is displayed");
		}
		else
		{
			System.out.println("Failure");
		}
		UserLoggedOut();
	}

}
