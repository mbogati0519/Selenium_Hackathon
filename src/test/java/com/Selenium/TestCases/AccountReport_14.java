package com.Selenium.TestCases;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountReport_14 extends BrowserUtilityMethods {

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
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(@class,'listRelatedObject accountBlock title')]"))));
		driver.findElement(By.xpath("//a[contains(@class,'listRelatedObject accountBlock title')]")).click();
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(text(),'Accounts with last activity > 30 days')]"))));
		driver.findElement(By.xpath("//a[contains(text(),'Accounts with last activity > 30 days')]")).click();
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@id='ext-gen49']"))));
		Thread.sleep(2000);
		
		//WebElement dateField = driver.findElement(By.xpath("//div[@id='ext-gen147']"));
		//Select dropDown10 = new Select(dateField);
		////dropDown10.selectByVisibleText("Created Date");
		Thread.sleep(2000);
		
		//driver.findElement(By.xpath("//input[@id='ext-comp-1042']")).clear();
		//Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='ext-comp-1042']")).sendKeys("04/26/2020");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='ext-comp-1045']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='ext-comp-1045']")).sendKeys("04/26/2020");
		Thread.sleep(1000);
		System.out.println("Qualified account list displayed");
		driver.findElement(By.xpath("//button[@id='ext-gen49']")).click();
		Thread.sleep(5000);
		
		//ArrayList <String> ReportTab = new ArrayList(driver.getWindowHandles());
		//System.out.println(ReportTab.size());
		//driver.switchTo().window(ReportTab.get(1));
		//Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//table[@id='saveReportDlgCancelBtn']//td[@class='x-btn-mc']"))));
		ReadingFile();
		driver.findElement(By.xpath("//input[@id='saveReportDlg_reportNameField']")).sendKeys(System.getProperty("ReportName"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='saveReportDlg_DeveloperName']")).sendKeys(System.getProperty("ReportUniqueName"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//table[@id='dlgSaveAndRun']")).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h2[contains(text(),'Report Options:')]"))));
		System.out.println("New account page is displayed wiht new details. Success");
		
		driver.quit();	
	}

}
