package com.Selenium.TestCases;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MySetting_07 extends BrowserUtilityMethods{

	public static void main(String[] args) throws Exception {
		
		LaunchingBrowser();
		SalesforceHomePage();
		Thread.sleep(3000);
		LoginSalesforce();
		
		WebDriverWait wait = new WebDriverWait (driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='userNav-arrow']"))));
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[@id='userNav-arrow']")).click();
		Thread.sleep(2000);
		System.out.println("All dropdown elements are displayed: ");
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(text(),'My Settings')]"))));
		driver.findElement(By.xpath("//a[contains(text(),'My Settings')]")).click();
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[contains(text(),'My Settings')]"))));
		System.out.println("My setting page is displayed");
		
		driver.findElement(By.xpath("//div[@id='PersonalInfo']")).click();
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@id='LoginHistory_font']"))));
		driver.findElement(By.xpath("//a[@id='LoginHistory_font']")).click();
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h3[@id='RelatedUserLoginHistoryList_title']"))));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'Download login history')]")).click();
		System.out.println("Data is Downloading");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[@id='DisplayAndLayout']")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@id='CustomizeTabs_font']"))));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='CustomizeTabs_font']")).click();
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//label[contains(text(),'Custom App:')]"))));
		
		WebElement customApp = driver.findElement(By.xpath("//select[@id='p4']"));
		Select dropDown1 = new Select(customApp);
		dropDown1.selectByVisibleText("Salesforce Chatter");
		Thread.sleep(2000);
		
		WebElement availableTabs = driver.findElement(By.xpath("//option[contains(text(),'Reports')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", availableTabs);
		Thread.sleep(2000);
		availableTabs.click();
		driver.findElement(By.xpath("//img[@class='rightArrowIcon']")).click();
		System.out.println("Reports field added");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@id='EmailSetup']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@id='EmailSettings_font']")).click();
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h3[contains(text(),'Outgoing Email Settings')]"))));
		Thread.sleep(2000);
		
		ReadingFile();
		driver.findElement(By.xpath("//input[@id='sender_name']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='sender_name']")).sendKeys(System.getProperty("emailName"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='sender_email']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='sender_email']")).sendKeys(System.getProperty("email"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='save']")).click();
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h3[contains(text(),'Outgoing Email Settings')]"))));
		System.out.println("Email saved");
		System.out.println("My setting Page is displayed");
		
		driver.findElement(By.xpath("//span[@id='CalendarAndReminders_font']")).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@id='Reminders_font']"))));
		driver.findElement(By.xpath("//span[@id='Reminders_font']")).click();
	
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='testbtn']"))));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='testbtn']")).click();
		Thread.sleep(2000);
		
		ArrayList <String> popWindow = new ArrayList(driver.getWindowHandles());
		System.out.println(popWindow.size());
		driver.switchTo().window(popWindow.get(1));
		Thread.sleep(2000);
		
		String popUp = driver.findElement(By.xpath("//span[contains(text(),'Start Time:')]")).getText();
		if(popUp.equals("Start Time:"))
		{
			System.out.println(popUp);
			System.out.println("Pop Up window is displayed and the test is Success");
		}
		else
		{
			System.out.println("Failure");
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='dismiss_all']")).click();
		driver.switchTo().window(popWindow.get(0));
		popWindow = new ArrayList(driver.getWindowHandles());
		System.out.println(popWindow.size());
		Thread.sleep(2000);
		
		driver.quit();		

	}

}
