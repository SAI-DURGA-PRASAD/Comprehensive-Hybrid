package com.bigsmall.runner;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bigsmall.reusableComponents.BaseClass;
import com.relevantcodes.extentreports.LogStatus;

public class GiftCardTest extends BaseClass{

	@Test
	public void giftCardTest() throws InterruptedException {
		driver.get(config.getURL());
		homepage.giftCard().click();
		Thread.sleep(10000);
		giftCard.thousand().click();
		giftCard.addToCart().click();
		Thread.sleep(4000);
		try {
			Assert.assertEquals(giftCard.giftCardValue().getText(), "Rs. 1,000");
			test.log(LogStatus.PASS, "System clicked on same GiftCard Value as mentioned");
			log.info("System clicked on same GiftCard Value as mentioned");
		}
		catch(Exception e) {
			test.log(LogStatus.PASS, "System not clicked on same GiftCard Value as mentioned");
			log.info("System not clicked on same GiftCard Value as mentioned");
		}
		
	}
}
