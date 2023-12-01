package com.qa.automation.PageObjectsFile;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.automation.ReusableUtilitties.JavaScriptExecutorUtil;

import io.cucumber.java.Scenario;

public class LandingPageObject {
	
	
	 private WebDriver driver;
	 private WebDriverWait wait;
	 Scenario scn;
	 JavaScriptExecutorUtil javaScriptExecutorUtil;
	
	public LandingPageObject(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver,15);
		javaScriptExecutorUtil = new JavaScriptExecutorUtil(driver);
	}
	
	//Private Locators
	 private By prodBtn = By.xpath("//a[text()=' Products']");
	 private By cartBtn = By.xpath("//a[text()=' Cart']");
	 private By testCasesBtn = By.xpath("//a[text()=' Test Cases']");
	 private By signUpBtn = By.xpath("//a[text()=' Signup / Login']");
	 private By APITestingBtn = By.xpath("//a[text()=' API Testing']");
	 private By VideoTutorialBtn = By.xpath("//a[text()=' Video Tutorials']");
	 private By ContactUsBtn = By.xpath(" //a[text()=' Contact us']");
	 private By subscriptionText = By.xpath("//h2[text()='Subscription']");
	 private By emailSubscription = By.xpath("//input[@id='susbscribe_email']");
	 private By arrowBtn = By.xpath("//button[@id='subscribe']");
	 private By successTxt = By.xpath("//div[text()='You have been successfully subscribed!']");//div[@class='alert-success alert']
	
	//Public Methods
	 public void homePageTitle()
	 {
		 String expectedTitle = "Automation Exercise";
		   String actualTitle = driver.getTitle();
		   Assert.assertEquals(expectedTitle, actualTitle);
	 }
	 
	 public void clickProductsBtn()
	 {
		 WebElement prodBtnEle = driver.findElement(prodBtn);
		 wait.until(ExpectedConditions.visibilityOf(prodBtnEle));
		 prodBtnEle.click();
	 }
	 
	 public void clickCartBtn()
	 {
		 WebElement cartBtnEle = driver.findElement(cartBtn);
		 wait.until(ExpectedConditions.visibilityOf(cartBtnEle));
		 cartBtnEle.click();
	 }
	 
	 public void clickSignUpOrLoginBtn()
	 {
		 WebElement signupBtnEle = driver.findElement(signUpBtn);
		 signupBtnEle.click();
	 }
	 
	 public void clickTestCasesBtn()
	 {
		 WebElement testCasesBtnEle = driver.findElement(testCasesBtn);
		 testCasesBtnEle.click();
	 }
	 
	 public void clickAPITestingBtn()
	 {
		 WebElement APITestingBtnEle = driver.findElement(APITestingBtn);
		 APITestingBtnEle.click();
	 }
	 
	 public void clickOnVideoTutorialBtn()
	 {
		 WebElement VideoTutorialBtnEle = driver.findElement(VideoTutorialBtn);
		 VideoTutorialBtnEle.click();
	 }
	 
	 public void clickContactUsBtn()
	 {
		 WebElement ContactUsBtnEle = driver.findElement(ContactUsBtn);
		 ContactUsBtnEle.click();
	 }
	 
	 public void userscrollDownPage()
	 {
			javaScriptExecutorUtil.scrollPageDown();
	 }
	 
	 public void verifySubscriptionTxt(String SUBSCRIPTION)
	 {
			WebElement subscriptionTxtEle = driver.findElement(subscriptionText);
			wait.until(ExpectedConditions.visibilityOf(subscriptionTxtEle));
			Assert.assertEquals(SUBSCRIPTION, subscriptionTxtEle.getText());
	 }
	 
	 public void enterEmailForSubscription(String emailForSubscription)
	 {
			WebElement EmailForSubscriptionEle = driver.findElement(emailSubscription);
			EmailForSubscriptionEle.sendKeys(emailForSubscription);
	 }
	 

	 public void clickArrowBtn()
	 {
			WebElement arrowBtnEle = driver.findElement(arrowBtn);
			arrowBtnEle.click();
	 }
		
	 public void verifySubscriptionSuccessMsg(String subscriptionsuccessMsg)
	 {
			WebElement successMsgEle = driver.findElement(successTxt);
			Assert.assertEquals(subscriptionsuccessMsg, successMsgEle.getText());
	 }
	 
	 public void verifyHeaderSectionEle(List<String> headerElement)
	 {
		 
		 List<WebElement> headerSectionEle = driver.findElements(By.xpath("//ul[@class='nav navbar-nav']//li"));
		 for(int i = 0;i<headerSectionEle.size();i++)
		 {
			 Assert.assertEquals(headerElement.get(i), headerSectionEle.get(i).getText().trim());
		 }
	 }
	
	 

}
