package com.qa.automation.TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="classpath:features",
        glue="com.qa.automation.StepDefs", 
        tags="", 
        plugin = {"pretty", 
            "html:target/html/web_ui_automation_report.html",
            "json:target/json/file.json",
            "junit:target/cucumberXML.xml",
            "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		    "timeline:test-output-thread/"
           },
        monochrome = true,
        publish=true,
        dryRun= false
        )


  public class Test_Runner
  {
	
	
	
   }
