package com.Selenium.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccount_10 extends BrowserUtilityMethods{

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
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[contains(@name,'new')]"))));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[contains(@name,'new')]")).click();
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='acc2']"))));
		
		ReadingFile();
		driver.findElement(By.xpath("//input[@id='acc2']")).sendKeys(System.getProperty("accountName"));
		Thread.sleep(1000);
		
		WebElement type = driver.findElement(By.xpath("//select[@id='acc6']"));
		Select dropDown2 = new Select(type);
		dropDown2.selectByVisibleText("Technology Partner");
		Thread.sleep(2000);
		
		WebElement priority = driver.findElement(By.xpath("//select[@id='00N5w00000HeVTv']"));
		Select dropDown3 = new Select(priority);
		dropDown3.selectByVisibleText("High");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[@name='save']")).click();
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h2[contains(text(),'Account Detail')]"))));
		String accountDetail =driver.findElement(By.xpath("//h2[contains(text(),'Account Detail')]")).getText();
		if(accountDetail.equals("Account Detail"))
		{
			System.out.println(accountDetail);
			System.out.println("The account page is displayed. Success");
		}
		else
		{
			System.out.println("Failure");
		}
		
		driver.quit();
	}
	

}
