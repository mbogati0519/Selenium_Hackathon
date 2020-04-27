package com.Selenium.TestCases;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DevelopersConsole_08 extends BrowserUtilityMethods{

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
		driver.findElement(By.xpath("//a[@class='debugLogLink menuButtonMenuLink']")).click();
		
		ArrayList <String> windowTabs = new ArrayList(driver.getWindowHandles());
		System.out.println(windowTabs.size());
		driver.switchTo().window(windowTabs.get(1));
		
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@id='editorMenuEntry-btnInnerEl']"))));
		Thread.sleep(3000);
		driver.close();
	
		driver.switchTo().window(windowTabs.get(0));
		windowTabs = new ArrayList(driver.getWindowHandles());
		Thread.sleep(3000);
		if(windowTabs.size()==1)
		{
			System.out.println(windowTabs.size());
			System.out.println("\nThe developer console window is closed. Success");
		}
		else
		{
			System.out.println("Failure");
		}
		driver.quit();		

	}

}
