package com.cucumber.selenium.testng;

import java.util.List;


import org.openqa.selenium.By;
import org.testng.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MonthlyShoeDisplays_StepDefinitions extends TestBase{
	
String monthName = null;
	
	
	@cucumber.api.java.en.Given("^user navigates to \"([^\"]*)\" on \"([^\"]*)\"$")
	public void givenStatement(String url,String browserType)
	{
		System.out.println("url:"+url+",browser:"+browserType);
		initialize();
		openBrowser(CONFIG.getProperty(browserType));
		driver.get(CONFIG.getProperty(url));
	}

	@When("^user clicks on the month name \"([^\"]*)\"$")
	public void user_clicks_on_the_month_name(String MonthName)
	{
		System.out.println("monthname:"+MonthName);
		monthName = MonthName;
		
		driver.findElement(By.linkText(MonthName)).click();
		
	}
	
	@Then("^corresponding shoe data should be displayed$")
	public void verifyShoeData()
	{
		try{
		List<org.openqa.selenium.WebElement> listElms = driver.findElements(By.xpath("//ul[@id='shoe_list']/li"));
	    
	    System.out.println("Number of shoes displayed:"+listElms.size());
	    
	    if(listElms.size() > 0)
	    {
		    for(int i=0;i<listElms.size();i++)
		    {
		    	
		    	String brand = driver.findElement(By.xpath("//ul[@id='shoe_list']/li"+"["+(i+1)+"]"+"/div/table/tbody/tr[1]/td[2]")).getText();
		    	String name = driver.findElement(By.xpath("//ul[@id='shoe_list']/li"+"["+(i+1)+"]"+"/div/table/tbody/tr[2]/td[2]")).getText();
		    	String price = driver.findElement(By.xpath("//ul[@id='shoe_list']/li"+"["+(i+1)+"]"+"/div/table/tbody/tr[3]/td[2]")).getText();
		    	String desc = driver.findElement(By.xpath("//ul[@id='shoe_list']/li"+"["+(i+1)+"]"+"/div/table/tbody/tr[4]/td[2]")).getText();
		    	String month = driver.findElement(By.xpath("//ul[@id='shoe_list']/li"+"["+(i+1)+"]"+"/div/table/tbody/tr[5]/td[2]")).getText();
		    	
		    	System.out.println("brand:"+brand);
		    	
		    	System.out.println("name:"+name);
		    	
		    	System.out.println("price:"+ price);
		    	
		    	System.out.println("desc:"+desc);
		    	
		    	System.out.println("month:"+month);
		    	
		    				    	
		    			    	
		    	Assert.assertTrue( brand.length()>0,"There is no Brand of the shoe");
		    	
		    	
		    	Assert.assertTrue(name.length()>0,"There is no name of the shoe");
		    	
		    	
		    	Assert.assertTrue(price.length()>0,"There is no price of the shoe");
		    	
		    	
		    	Assert.assertTrue(desc.length()>0,"There is no description of the shoe");
		    	
		    	
		    	Assert.assertTrue(month.length()>0,"There is no release month of the shoe");
		    	
		    	
		    	org.openqa.selenium.WebElement imgTd = driver.findElement(By.xpath("//ul[@id='shoe_list']/li"+"["+(i+1)+"]"+"/div/table/tbody/tr[6]/td[1]"));
		    	
		    	List<org.openqa.selenium.WebElement> imgElms = imgTd.findElements(By.tagName("img"));
		    	
		    	System.out.println("Image Elements:"+imgElms.size());
		    	
		    	Assert.assertTrue(imgElms.size()>0,"There is no Shoe Image");
		    	
		    	String imgSrc = imgElms.get(0).getAttribute("src");
		    	
		    	System.out.println("image source:"+imgSrc);
		    	
		    	Assert.assertTrue(imgSrc.length()>0,"Image src is null.No Image to display.");
		    	
		      
		    }
		    	
	    }
	    else{
	    	
	        System.out.println("There are no records to display...");
	    	Assert.assertTrue(true);
	    }
	}catch(Exception ex)
	{
		Assert.fail("Shoes are not displayed properly for the test month-"+monthName+"->"+ex.getMessage());
	}


	}
	
	

}
