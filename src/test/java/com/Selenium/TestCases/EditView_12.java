package com.Selenium.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.service.DriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditView_12 extends BrowserUtilityMethods {

	public static void main(String[] args) throws Exception {
		
		LaunchingBrowser();
		SalesforceHomePage();
		Thread.sleep(3000);
		LoginSalesforce();
		
		WebDriverWait wait = new WebDriverWait (driver, 30);
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//img[contains(@class,'allTabsArrow')]"))));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[contains(@class,'allTabsArrow')]")).click();
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(@class,'listRelatedObject accountBlock title')]"))));
		driver.findElement(By.xpath("//a[contains(@class,'listRelatedObject accountBlock title')]")).click();
		System.out.println("Account page is displayed");
		Thread.sleep(2000);
		
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[contains(@class,'fFooter')]//a[contains(text(),'Edit')]"))));
		//Thread.sleep(2000);
		
		WebElement ViewEdit = driver.findElement(By.xpath("//select[@id='fcf']"));
		Select dropDown3 = new Select(ViewEdit);
		dropDown3.selectByIndex(5);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[contains(@class,'fFooter')]//a[contains(text(),'Edit')]")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h3[contains(text(),'Step 1. Enter View Name')]"))));
		Thread.sleep(1000);
		
		ReadingFile();
		driver.findElement(By.xpath("//input[@id='fname']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='fname']")).sendKeys(System.getProperty("NewViewName"));
		Thread.sleep(2000);
		
		WebElement field = driver.findElement(By.xpath("//select[@id='fcol1']"));
		Select dropDown4 = new Select(field);
		dropDown4.selectByVisibleText("Account Name");
		Thread.sleep(1000);
		
		WebElement operator = driver.findElement(By.xpath("//select[@id='fop1']"));
		Select dropDown5 = new Select(operator);
		dropDown5.selectByVisibleText("contains");
		Thread.sleep(1000);
		
		WebElement value = driver.findElement(By.xpath("//input[@id='fval1']"));
		value.sendKeys("a");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[3]//table[1]//tbody[1]//tr[1]//td[2]//input[1]")).click();
		Thread.sleep(2000);
		
		if(driver.findElement(By.xpath("//option[contains(text(),'New view name')]")).isDisplayed())
		{
			System.out.println(driver.findElement(By.xpath("//option[contains(text(),'New view name')]")).getText());
			System.out.println("View Page with new name is displayed in dropdown");
		}
		else
		{
			System.out.println("Failure");
		}
		
		Thread.sleep(2000);
		
		driver.quit();

	}

}
