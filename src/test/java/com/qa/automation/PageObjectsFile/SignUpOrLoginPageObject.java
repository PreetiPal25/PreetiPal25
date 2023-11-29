package com.qa.automation.PageObjectsFile;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.Scenario;


public class SignUpOrLoginPageObject {
	
	private WebDriver driver;
	Scenario scn;
	
	public SignUpOrLoginPageObject(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//Locators
	
	//Methods
	public void verifySignUpPageTitle(String signUpPageTitle)
	{
		Assert.assertEquals(true, driver.getTitle().contains(signUpPageTitle));
	}

}
