package com.Selenium.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserMenu_05 extends BrowserUtilityMethods{

	public static void main(String[] args){
		
		LaunchingBrowser();
		SalesforceHomePage();
		LoginSalesforce();
				
		WebDriverWait wait = new WebDriverWait (driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='userNav-arrow']"))));
		
		driver.findElement(By.xpath("//div[@id='userNav-arrow']")).click();
		//Thread.sleep(5000);
		
		boolean a = driver.findElement(By.xpath("//a[contains(text(),'My Profile')]")).isDisplayed();
		boolean b = driver.findElement(By.xpath("//a[contains(text(),'My Settings')]")).isDisplayed();
		boolean c = driver.findElement(By.xpath("//a[@class='debugLogLink menuButtonMenuLink']")).isDisplayed();
		boolean d = driver.findElement(By.xpath("//a[@class='menuButtonMenuLink'][2]")).isDisplayed();
		boolean e = driver.findElement(By.xpath("//a[@class='menuButtonMenuLink'][3]")).isDisplayed();
		
		if(a==true && b==true && c==true && d==true && e==true) {
			System.out.println("All elements are displayed. The Test is SUCCESS");
		}
		else {
			System.out.println("Failure");
		}
		
		driver.quit();		

	}

}
