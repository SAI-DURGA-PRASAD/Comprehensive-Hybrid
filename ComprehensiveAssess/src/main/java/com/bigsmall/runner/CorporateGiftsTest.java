package com.bigsmall.runner;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bigsmall.reusableComponents.BaseClass;
import com.relevantcodes.extentreports.LogStatus;

public class CorporateGiftsTest extends BaseClass{


	@Test
	public void CorporateGifts() {
		driver.get(config.getURL());
		homepage.corporateGifts().click();
		
		corporateGifts.fullName().sendKeys("fullname1");
		corporateGifts.email().sendKeys("email@email.com");
		corporateGifts.phoneNumber().sendKeys("12345678");
		corporateGifts.enquiry().sendKeys("Sample enquiry message");
		corporateGifts.submit().click();
		try {
			Assert.assertEquals(corporateGifts.robotCheckNote().getText(),"To continue, let us know you're not a robot.");
			test.log(LogStatus.PASS, "System successfully entered the details shown robotCheckNote");
			log.info("System successfully entered the details shown robotCheckNote");
		}
		catch(Exception e){
			test.log(LogStatus.FAIL, "System failed to show robotCheckNote");
			log.info("System failed to show robotCheckNote: "+e);
		}
//		log.info("This page will redirect to Captha");
		log.info("End of CorporateGifts TestCase");
	}
}
