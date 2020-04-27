package com.Selenium.TestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CancelButton_31 extends BrowserUtilityMethods{

	public static void main(String[] args) throws Exception {
		
		UserLoggedIn();
		
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
		
		driver.findElement(By.xpath("//a[contains(text(),'Create New View')]")).click();
		System.out.println("Create View Page is displayed");
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='pbHeader']//input[@name='save']"))));
		driver.findElement(By.xpath("//input[@id='fname']")).sendKeys("ABCD");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='devname']")).sendKeys("EFGH");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='pbHeader']//input[@name='cancel']")).click();
		Thread.sleep(1000);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[contains(@name,'new')]"))));
		System.out.println(driver.findElement(By.xpath("//h2[contains(@class,'pageDescription')]")).getText());
		System.out.println("Contacts Homa Page is displayed");
		
		List <WebElement> viewList = driver.findElements(By.xpath("//select[@id='fcf']"));
		for(int count = 0; count < viewList.size(); count++)
		{
			if(viewList.get(count).getText().contains("ABCD"))
			{
				System.out.println("Failure. Shouldn't contain");
			}
			else
			{
				System.out.println(viewList.get(count).getText());
				System.out.println("View ABCD is not created. Success");
			}
		}
		
		UserLoggedOut();	
	}
	

}
