package com.Selenium.TestCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MergeAccount_13 extends BrowserUtilityMethods {

	public static void main(String[] args) throws InterruptedException {
		
		LaunchingBrowser();
		SalesforceHomePage();
		Thread.sleep(3000);
		LoginSalesforce();
		

		WebDriverWait wait = new WebDriverWait (driver, 30);
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//img[contains(@class,'allTabsArrow')]"))));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[contains(@class,'allTabsArrow')]")).click();
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(@class,'listRelatedObject accountBlock title')]"))));
		driver.findElement(By.xpath("//a[contains(@class,'listRelatedObject accountBlock title')]")).click();
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(text(),'Merge Accounts')]"))));
		driver.findElement(By.xpath("//a[contains(text(),'Merge Accounts')]")).click();
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='srch']"))));
		driver.findElement(By.xpath("//input[@id='srch']")).sendKeys("Milan Raj Bogati");
		driver.findElement(By.xpath("//input[contains(@name,'srchbutton')]")).click();
		driver.findElement(By.xpath("//input[@id='srch']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='srch']")).sendKeys("milanbogati");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(@class,'pbWizardBody')]//input[contains(@name,'srchbutton')]")).click();
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='cid0']"))));
		driver.findElement(By.xpath("//input[@id='cid0']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='cid1']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(@class,'pbBottomButtons')]//input[contains(@name,'goNext')]")).click();
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(@class,'pbBottomButtons')]//input[contains(@name,'save')]"))));
		System.out.println("Merge BY account page is displayed");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(@class,'pbBottomButtons')]//input[contains(@name,'save')]")).click();
		Thread.sleep(2000);
		
		Alert al = driver.switchTo().alert();
		System.out.println(al.getText());
		System.out.println("Pop Up window is displayed");
		al.accept();
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//th[contains(text(),'Account Name')]"))));
		WebElement View = driver.findElement(By.xpath("//select[@id='fcf']"));
		Select dropDown7 = new Select(View);
		dropDown7.selectByVisibleText("Recently Viewed Accounts");
		Thread.sleep(2000);
		
		
		
	
		
		driver.quit();

	}

}
