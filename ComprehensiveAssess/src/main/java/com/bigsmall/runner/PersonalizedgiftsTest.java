package com.bigsmall.runner;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bigsmall.reusableComponents.BaseClass;
import com.relevantcodes.extentreports.LogStatus;

public class PersonalizedgiftsTest extends BaseClass{

	@Test
	public void personalizedGifts() {
		driver.get(config.getURL());
		
		homepage.personalizedGifts().click();
		personalizedGifts.sort().click();
		personalizedGifts.bestSelling().click();
		
		try {
			Assert.assertEquals(personalizedGifts.firstBook().getText(), "Personalized Moon Lamp - COD Not Available");
			log.info("System shown the bestselling product");
			test.log(LogStatus.PASS, "System shown the bestselling product");
		}
		catch(Exception e) {
			test.log(LogStatus.FAIL, "System unable to show the bestselling product");
			log.info("System unable to show the bestselling product: "+e.getMessage());
		}
		
		log.info("End of personalizedGifts TestCase");
	}
}
