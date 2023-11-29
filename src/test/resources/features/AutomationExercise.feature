@AutoExerciseHealthCheck

Feature: E-commerce Application Website Health Checkup

Background: Navigate to the base URL of application and verify home page
Given user navigate to the home application url "http://automationexercise.com"
Then  User Verify that home page is visible successfully

@ValidateHeaderSection
Scenario: User is able to open the browser, navigate to the url and validate the header section elements of webpage
Given User Click on product button
When User redirected to product page with title as "Automation Exercise - All Products" 
And  User click on cart button 
And  User redirected to cart page with title as "Automation Exercise - Checkout"
And  User click on signup/login button
And  User over the signup/login page with title as "Automation Exercise - Signup / Login"
And  User Click on test cases button
Then User verify Test page url "https://automationexercise.com/test_cases"
When User click on API Testing button
Then User verify "APIS LIST FOR PRACTICE" text is visible
#When User cilck on Video Tutorials button
#And  User redirected to you tube video page with url as  "https://www.youtube.com/c/AutomationExercise"
And  User click on contact us button of the header section
Then User verify the page title "Automation Exercise - Contact Us" 

@subscriptionInHomePage
Scenario: User is able to open the browser, navigate to the url and verify subsciption in home page
Given User Scroll down to footer of the page
When  After scrooling down user is able to see "SUBSCRIPTION" keyword 
And  User enter email address "nirmalpooja0597@gmail.com" in input 
And  User click on arrow button
Then User Verify success message "You have been successfully subscribed!" is visible








