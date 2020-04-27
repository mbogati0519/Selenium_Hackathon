package com.Selenium.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateNewOpty_16 extends BrowserUtilityMethods{

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
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='new']"))));
		System.out.println("Opportunity Home Page dispalyed");
		
		driver.findElement(By.xpath("//input[@name='new']")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//label[contains(text(),'Opportunity Name')]"))));
		Thread.sleep(2000);
		
		ReadingFile();
		driver.findElement(By.xpath("//input[@id='opp3']")).sendKeys(System.getProperty("OpportunityName"));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='opp4']")).sendKeys(System.getProperty("AccountName"));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='opp9']")).sendKeys(System.getProperty("CloseDate"));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='opp12']")).sendKeys(System.getProperty("Probability"));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='opp17']")).sendKeys(System.getProperty("PrimaryCampaignSource"));
		Thread.sleep(1000);
		
		WebElement leadSource = driver.findElement(By.xpath("//select[@id='opp6']"));
		Select drop1 = new Select(leadSource);
		drop1.selectByIndex(4);
		Thread.sleep(2000);
		
		WebElement stage = driver.findElement(By.xpath("//select[@id='opp11']"));
		Select drop2 = new Select(stage);
		drop2.selectByIndex(3);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[contains(@class,'pbBottomButtons')]//input[1]")).click();
		Thread.sleep(2000);
		
		String errorMsg = driver.findElement(By.xpath("//div[@id='errorDiv_ep']")).getText();
		System.out.println(errorMsg);
		System.out.println("Failure");
		
		driver.quit();
		

	}

}
