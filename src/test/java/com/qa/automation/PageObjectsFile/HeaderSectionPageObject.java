package com.qa.automation.PageObjectsFile;

import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class HeaderSectionPageObject {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public HeaderSectionPageObject(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver,15);
	}
	
	//Locators
	private By apiList = By.xpath("//b[text()='APIs List for practice']");
	
	//Methods
	public void verifycartPageTitle(String cartPageTitle)
	{
		Assert.assertEquals(true, driver.getTitle().contains(cartPageTitle));
	}
	
	public void verifyTestCasesPage(String testCasePageURL)
	{
		Assert.assertEquals(true, driver.getCurrentUrl().contains(testCasePageURL));
	}
	
	public void verifyAPITestingPage(String apiTestingList)
	{
		WebElement apiListEle = driver.findElement(apiList);
		Assert.assertEquals(apiTestingList, apiListEle.getText());
	}

	public void verifyVideoTutorialPageURL(String videoTutorialPageUrl)
	{	
		Assert.assertEquals(true, driver.getCurrentUrl().contains(videoTutorialPageUrl));
	}
	
	public void verifycontactUsPageTitle(String contactUsPageTitle)
	{
		Assert.assertEquals(true, driver.getTitle().contains(contactUsPageTitle));
	}
	
	
	
	
	
	
	
	
	
	
	
}
