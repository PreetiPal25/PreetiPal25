package com.qa.automation.PageObjectsFile;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.Scenario;


public class SignUpOrLoginPageObject {
	
	private WebDriver driver;
	Scenario scn;
	
	public SignUpOrLoginPageObject(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//Locators
	private By loginToYourText = By.xpath("//h2[text()='Login to your account']");
	private By loginEmailAddress = By.xpath("//input[@data-qa='login-email']");
	private By loginPassword = By.xpath("//input[@data-qa='login-password']");
	private By loginBtn = By.xpath("//button[@data-qa='login-button']");
	private By loginErrorMsg = By.xpath("//p[text()='Your email or password is incorrect!']");
	private By loggedInUserNameTxt = By.xpath("//a[text()= ' Logged in as ']/b");
	private By logoutBtn = By.xpath("//a[text()=' Logout']");
	
	//Methods
	public void verifySignUpPageTitle(String signUpPageTitle)
	{
		Assert.assertEquals(true, driver.getTitle().contains(signUpPageTitle));
	}
	
	public void verifyloginToYourAccText(String loginToAcc)
	{
		WebElement loginToAccTextEle = driver.findElement(loginToYourText);
		Assert.assertEquals(loginToAcc, loginToAccTextEle.getText());
	}
	
	public void enterInvalidLoginEmailIdAndPassword(String EmailId,String Password)
	{
		WebElement EmailIdEle = driver.findElement(loginEmailAddress);
		EmailIdEle.sendKeys(EmailId);
		
		WebElement passwordEle = driver.findElement(loginPassword);
		passwordEle.sendKeys(Password);
	}
	
	public void clickOnLoginBtn()
	{
		WebElement loginBtnEle = driver.findElement(loginBtn);
		loginBtnEle.click();
	}
	
	public void verifyLoginInvalidMsg(String errorMsg)
	{
		WebElement errorMsgEle = driver.findElement(loginErrorMsg);
		Assert.assertEquals(errorMsg, errorMsgEle.getText());
	}
	
	public void enterValidEmailIdAndPassword(String ValidEmailId,String ValidPassword)
	{
		WebElement EmailIdEle = driver.findElement(loginEmailAddress);
		EmailIdEle.sendKeys(ValidEmailId);
		
		WebElement passwordEle = driver.findElement(loginPassword);
		passwordEle.sendKeys(ValidPassword);
	}
	
	 public void userNameAfterLoggedIn(String username)
	 {
		 WebElement loggedInUserNameTxtEle = driver.findElement(loggedInUserNameTxt);
			Assert.assertEquals(username, loggedInUserNameTxtEle.getText());
	 }
	 
	 public void clickOnLogoutBtn()
	 {
		 WebElement logoutBtnEle = driver.findElement(logoutBtn);
		 logoutBtnEle.click();
	 }

}
