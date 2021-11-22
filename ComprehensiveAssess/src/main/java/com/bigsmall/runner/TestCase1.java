package com.bigsmall.runner;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bigsmall.reusableComponents.BaseClass;
import com.relevantcodes.extentreports.LogStatus;



public class TestCase1 extends BaseClass{

	//To validate the title of the Landing Page
	@Test
	public void titleValidation() {
		driver.get(config.getURL());	// To open URL
		log.info("Driver open URL and entered into Landing Page");
//		System.out.println(driver.getTitle());
		try{
			Assert.assertEquals(driver.getTitle(),"Gifts Online - Send Unique, Unusual Gifts in India, Buy Gifts– Bigsmall.in");
			test.log(LogStatus.PASS,"Homepage title is validated");
			log.info("Homepage title is validated");
		}
		catch(Exception e) {
			test.log(LogStatus.FAIL,"System failed to load Homepage");
			log.info("System failed to load Homepage");
		}
		
		log.info("End of titleValidation TestCase");
	}

}
