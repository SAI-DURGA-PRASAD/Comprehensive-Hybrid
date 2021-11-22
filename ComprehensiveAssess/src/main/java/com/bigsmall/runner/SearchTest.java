package com.bigsmall.runner;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bigsmall.reusableComponents.BaseClass;
import com.relevantcodes.extentreports.LogStatus;

public class SearchTest extends BaseClass{

	@Test
	public void searchItem() {
		driver.get(config.getURL());
		homepage.getSearch().sendKeys(config.getSearchText());
		
		homepage.getSearch().sendKeys(Keys.ENTER);
		
		//After searching.. we check for one item in page to verify searching item 
		
		try {
			Assert.assertEquals(homepage.getFirstItem().getText(), "Harry Potter Plush Soft Toy");
			log.info("System shown the first book as mentioned");
			test.log(LogStatus.PASS, "System shown the first book as mentioned");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			log.info("System unable to show the first book as mentioned: "+e.getMessage());
			test.log(LogStatus.FAIL, "System unable to show the first book as mentioned");
		}
		
		log.info("End of searchItem TestCase");
	}
}
