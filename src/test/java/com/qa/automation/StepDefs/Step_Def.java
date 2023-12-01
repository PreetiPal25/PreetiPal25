package com.qa.automation.StepDefs;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.automation.PageObjectsFile.HeaderSectionPageObject;
import com.qa.automation.PageObjectsFile.LandingPageObject;
import com.qa.automation.PageObjectsFile.ProductPageObject;
import com.qa.automation.PageObjectsFile.SignUpOrLoginPageObject;
import com.qa.automation.ReusableUtilitties.WebDriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Step_Def {
	
	private static final Logger logger = LogManager.getLogger(Step_Def.class);
	
	private WebDriver driver;
	Scenario scn;
	LandingPageObject landingPageObject;
	ProductPageObject productPageObject;
	HeaderSectionPageObject headerSectionPageObject;
	SignUpOrLoginPageObject signUpOrLoginPageObject;
	
	
	
	@Before
	public void setUp(Scenario scn) throws Exception
	{
		this.scn = scn;
		String browserName = WebDriverFactory.getBrowserName();
		driver = WebDriverFactory.setUpBrowser(browserName);
		scn.log("browser get invoked");
		landingPageObject = new LandingPageObject(driver);
		productPageObject = new ProductPageObject(driver);
		headerSectionPageObject = new HeaderSectionPageObject(driver);
		signUpOrLoginPageObject = new SignUpOrLoginPageObject(driver);
		
		
	}
	
	@After(order=1)
	public void cleanUp()
	{
		WebDriverFactory.quitDriver();
		scn.log("browser get closed");
	}
	
	@After(order=2)
	public void takescreenshot()
	{
		WebDriverFactory.failedScnScreenshot(scn);	
	}
	

	@Given("user navigate to the home application url {string}")
	public void user_navigate_to_the_home_application_url(String url)
	{
	   WebDriverFactory.setURL(url);
	   scn.log("user navigate to url" +" - "+ url);
	}

	@Then("User Verify that home page is visible successfully")
	public void user_verify_that_home_page_is_visible_successfully() 
	{
		landingPageObject.homePageTitle();
		scn.log("user veriy the home page title");
		logger.info("user verify the home page title");
	}
		
	@Given("User Click on product button")
	public void user_click_on_product_button()
	{
	   landingPageObject.clickProductsBtn();
	   logger.info("user click on product button");
	}
	
	@When("User redirected to product page with title as {string}")
	public void user_redirected_to_product_page_with_title_as(String prodPageTitle) 
	{
		 productPageObject.validateProdPageTitle(prodPageTitle);
		 scn.log("user verify product page title" +" - "+ prodPageTitle );
		 logger.info("user verify the product page title");
	}
	
	@When("User click on cart button")
	public void user_click_on_cart_button() 
	{
	   landingPageObject.clickCartBtn();
	   logger.info("user click on cart button");
	}
	
	@When("User redirected to cart page with title as {string}")
	public void user_redirected_to_cart_page_with_title_as(String cartPageTitle) 
	{
		headerSectionPageObject.verifycartPageTitle(cartPageTitle);
		scn.log("user verify cart page title" +" - "+ cartPageTitle );
		logger.info("user verify the cart page title");
	}
	
	@When("User click on signup\\/login button")
	public void user_click_on_signup_login_button() 
	{
	   landingPageObject.clickSignUpOrLoginBtn();
	   logger.info("user click on signup/login button");
	}

	@When("User redirect to the signup\\/login page with title as {string}")
	public void user_redirect_to_the_signup_login_page_with_title_as(String signUpPageTitle) 
	{
	    signUpOrLoginPageObject.verifySignUpPageTitle(signUpPageTitle);
	    scn.log("user verify signup page title" +" - "+ signUpPageTitle);
	    logger.info("user verify the signup page title");
	}
	
	@When("User Click on test cases button")
	public void user_click_on_test_cases_button() 
	{
	    landingPageObject.clickTestCasesBtn();
	    logger.info("user click on test cases button");
	}
	
	@Then("User verify Test page url {string}")
	public void user_verify_test_page_url(String testCasePageURL) 
	{
	    headerSectionPageObject.verifyTestCasesPage(testCasePageURL);
	    scn.log("user verify the test case page url" +" - "+ testCasePageURL);
	    logger.info("user verify the test cases page url");
	}
	
	@When("User click on API Testing button")
	public void user_click_on_api_testing_button() 
	{
	  landingPageObject.clickAPITestingBtn();
	  logger.info("user click on API testing button");
	}
	
	@Then("User verify {string} text is visible")
	public void user_verify_text_is_visible(String apiTestingList) 
	{
	    headerSectionPageObject.verifyAPITestingPage(apiTestingList);
	    scn.log("user verify" + apiTestingList + "text is available");
	    logger.info("user verify" + apiTestingList + "text is available");
	}
	
	@When("User cilck on Video Tutorials button")
	public void user_cilck_on_video_tutorials_button() 
	{
	   landingPageObject.clickOnVideoTutorialBtn();
	   logger.info("user click on video tutorial button");
	}
	
	@When("User redirected to you tube video page with url as  {string}")
	public void user_redirected_to_you_tube_video_page_with_url_as(String videoTutorialPageUrl) 
	{
	   headerSectionPageObject.verifyVideoTutorialPageURL(videoTutorialPageUrl);
	   logger.info("user verify you tube video page title");
	}
	
	@When("User click on contact us button of the header section")
	public void user_click_on_contact_us_button_of_the_header_section() 
	{
	  landingPageObject.clickContactUsBtn();
	  logger.info("user click on contact us button");
	}
	
	@Then("User verify the page title {string}")
	public void user_verify_the_page_title(String contactUsPageTitle) 
	{
	   headerSectionPageObject.verifycontactUsPageTitle(contactUsPageTitle);
	   scn.log("user verify contact us page title" +" - "+ contactUsPageTitle);
	   logger.info("user verify contact us page title");
	}
	
	@Given("User Scroll down to footer of the page")
	public void user_scroll_down_to_footer_of_the_page() 
	{
	   landingPageObject.userscrollDownPage();
	   logger.info("user scroll down the page");
	}

	@When("After scrooling down user is able to see {string} keyword")
	public void after_scrooling_down_user_is_able_to_see_keyword(String SUBSCRIPTION) 
	{
      landingPageObject.verifySubscriptionTxt(SUBSCRIPTION);
      scn.log("user verify text" +" - "+ SUBSCRIPTION  );
      logger.info("user verify the SUBSCRIPTION text");

	}
	
	@When("User enter email address {string} in input")
	public void user_enter_email_address_in_input(String emailForSubscription)
	{
	    landingPageObject.enterEmailForSubscription(emailForSubscription);
	    scn.log("user enter email" +" - "+ emailForSubscription);
	    logger.info("user enter email for subscription");
	}
	
	@When("User click on arrow button")
	public void user_click_on_arrow_button() 
	{
	   landingPageObject.clickArrowBtn();
	   logger.info("user click on arrow button");
	}
	
	@Then("User Verify success message {string} is visible")
	public void user_verify_success_message_is_visible(String subscriptionsuccessMsg)
	{
	   landingPageObject.verifySubscriptionSuccessMsg(subscriptionsuccessMsg);
	   scn.log("user verify success msg" +" - "+ subscriptionsuccessMsg);
	   logger.info("user verify the subscription success msg");
	}
	
	@When("user able to see {string} section on login page")
	public void user_able_to_see_section_on_login_page(String loginToAcc) 
	{
	    signUpOrLoginPageObject.verifyloginToYourAccText(loginToAcc);
	    scn.log("user able to see " + loginToAcc + "on login page");
	    logger.info("user able to see " + loginToAcc + "on login page");
	}

	@When("User enter {string} and {string}")
	public void user_enter_and(String EmailId, String Password) 
	{
		signUpOrLoginPageObject.enterInvalidLoginEmailIdAndPassword(EmailId, Password);
		scn.log("user enter email and password - "+EmailId+" , "+Password);
		logger.info("user enter email and password - "+EmailId+" , "+Password);
	}
	
	@When("User click on login button")
	public void user_click_on_login_button() 
	{
	    signUpOrLoginPageObject.clickOnLoginBtn();
	    logger.info("user click on login button");
	}
	
	@Then("User verify the error message {string}")
	public void user_verify_the_error_message(String errorMsg) 
	{
	    signUpOrLoginPageObject.verifyLoginInvalidMsg(errorMsg);
	    scn.log("user verify error msg - "+errorMsg);
	    logger.info("user verify error msg - "+errorMsg);
	}

	@When("User enter valid {string} and {string} for login")
	public void user_enter_valid_and_for_login(String ValidEmailId, String ValidPassword)
	{
	   signUpOrLoginPageObject.enterValidEmailIdAndPassword(ValidEmailId, ValidPassword);
	   scn.log("user enter valid email and password- "+ValidEmailId+" , "+ValidPassword);
	   logger.info("user enter valid email and password- "+ValidEmailId+" , "+ValidPassword);
	}

	@Then("User verify with {string} just after Logged in as button")
	public void user_verify_with_just_after_logged_in_as_button(String username) 
	{
	   signUpOrLoginPageObject.userNameAfterLoggedIn(username);
	   scn.log("user verify username after logged in - "+username);
	   logger.info("user verify username after logged in - "+username);
	}
	
	@Then("User click on logout button")
	public void user_click_on_logout_button() 
	{
	   signUpOrLoginPageObject.clickOnLogoutBtn();
	   logger.info("user click on logout button");
	}
	
	
}
