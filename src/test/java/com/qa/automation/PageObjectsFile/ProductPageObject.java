package com.qa.automation.PageObjectsFile;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;





public class ProductPageObject {
	
	private WebDriver driver;
	
	public ProductPageObject(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//Locators
	
	//Methods
	public void validateProdPageTitle(String prodPageTitle)
	{
		Assert.assertEquals(true, driver.getTitle().contains(prodPageTitle));
	}
	
	
	
	
	
	
	
	
	
	
	

}
