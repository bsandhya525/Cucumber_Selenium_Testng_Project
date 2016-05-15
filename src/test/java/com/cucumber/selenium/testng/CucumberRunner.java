package com.cucumber.selenium.testng;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@RunWith(cucumber.api.junit.Cucumber.class)
@CucumberOptions(format={"pretty","html:reports/test-report"},tags="@monthlyshoedisplaysTest,@EmailSubscriptionTest")
public class CucumberRunner extends AbstractTestNGCucumberTests{
	
	
}
