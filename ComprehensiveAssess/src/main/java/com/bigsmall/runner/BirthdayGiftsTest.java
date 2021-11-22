package com.bigsmall.runner;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bigsmall.reusableComponents.BaseClass;
import com.relevantcodes.extentreports.LogStatus;

public class BirthdayGiftsTest extends BaseClass{

	@Test
	public void BirthdayGifts() {
		driver.get(config.getURL());
		
		Actions action = new Actions(driver);
		action.moveToElement(homepage.gifts()).perform();
		homepage.birthdayGifts().click();
		
		try {
//			Thread.sleep(5000);
			Assert.assertEquals(driver.getTitle(), "Unique Birthday Gifts - Buy Best Gifts for Bday Online in India– Bigsmall.in");
			test.log(LogStatus.PASS, "System successully opened birthdayGifts page");
			log.info("System successully opened birthdayGifts page");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "System failed to open birthdayGifts page");
			log.info("System failed to open birthdayGifts page");
		}

		log.info("End of BirthdayGifts Testcase");
	}
}
