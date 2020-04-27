package com.Selenium.TestCases;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyProfile_06 extends BrowserUtilityMethods{

	public static void main(String[] args) throws Exception {
		
		LaunchingBrowser();
		SalesforceHomePage();
		Thread.sleep(3000);
		LoginSalesforce();
		
		WebDriverWait wait = new WebDriverWait (driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='userNav-arrow']"))));
		
		driver.findElement(By.xpath("//div[@id='userNav-arrow']")).click();
		Thread.sleep(2000);
		System.out.println("All dropdown elements are displayed: ");
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"))));
		driver.findElement(By.xpath("//a[contains(text(),'My Profile')]")).click();
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@id='profileTab_sfdc.ProfilePlatformFeed']"))));
		driver.findElement(By.xpath("//a[@id='moderatorMutton']//b[@class='zen-selectArrow']")).click();
		Thread.sleep(2000);
		System.out.println("Profile page is displayed");
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(text(),'Edit Profile')]"))));
		driver.findElement(By.xpath("//a[contains(text(),'Edit Profile')]")).click();
		Thread.sleep(2000);
		
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h2[@id='aboutMeTitle']"))));
		//ArrayList <String> editProfile = new ArrayList(driver.getWindowHandles());
		//System.out.println(editProfile.size());
		//driver.switchTo().window(editProfile.get(1));
		//Thread.sleep(2000);
		
		ReadingFile();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='aboutMeContentId']")));
		driver.findElement(By.xpath("//input[@id='lastName']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(System.getProperty("lastName"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@class,'zen-btn zen-primaryBtn zen-pas')]")).click();
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[contains(@class,'publisherattachtext')][contains(text(),'Post')]"))));
		System.out.println(driver.findElement(By.xpath("//span[@id='tailBreadcrumbNode']")).getText());
		System.out.println("Profile Page with last name is displayed");
		
		//driver.findElement(By.xpath("//span[contains(@class,'publisherattachtext')][contains(text(),'Post')]")).click();
		//Thread.sleep(2000);
		
		ReadingFile();
		//driver.switchTo().defaultContent();
		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
		//driver.findElement(By.xpath("//body[@class='chatterPublisherRTE cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']//p")).sendKeys(System.getProperty("postToShare"));
		
		driver.findElement(By.xpath("//span[contains(@class,'publisherattachtext')][contains(text(),'File')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@id='chatterUploadFileAction']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='chatterFile']")).sendKeys(System.getProperty("fileToShare"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='publishersharebutton']")).click();
		Thread.sleep(10000);
		System.out.println("The selected file is posted");
		Thread.sleep(1000);
		
		WebElement addPhoto = driver.findElement(By.xpath("//a[@id='uploadLink']"));
		Actions act = new Actions (driver);
		act.moveToElement(addPhoto).build().perform();
		addPhoto.click();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='uploadPhotoContentId']")));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='j_id0:uploadFileForm:uploadInputFile']")).sendKeys(System.getProperty("fileToShare"));
		Thread.sleep(5000);
		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='uploadPhotoContentId']")));
		driver.findElement(By.xpath("//input[@id='j_id0:uploadFileForm:save']")).click();
		Thread.sleep(10000);

		//input[@id='j_id0:uploadFileForm:save']
		
		
		
		driver.quit();
		
		
		
		
		
	}

}
