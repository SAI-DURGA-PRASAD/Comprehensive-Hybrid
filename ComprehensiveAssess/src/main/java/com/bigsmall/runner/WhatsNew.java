package com.bigsmall.runner;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.bigsmall.reusableComponents.BaseClass;
import com.relevantcodes.extentreports.LogStatus;

public class WhatsNew extends BaseClass{

	//To access the What's new page from homepage
	@Test
	public void whatsNew() throws InterruptedException {
		driver.get(config.getURL());
		homepage.whatsNew().click();
		boolean flag = false;
		List<WebElement> list = newUniqueGifts.items();
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getText().equalsIgnoreCase("Handmade Buddha Diary")) {
				log.info("Desired item found in Whats new page");
//				System.out.println(list.get(i).getText());
				list.get(i).click();
				Thread.sleep(5000);
				flag =true;
				test.log(LogStatus.PASS,"System opened the desired item");
				log.info("System opened the desired item");
				break;
			}
		}
		if(!flag) {
			test.log(LogStatus.FAIL, "System unable to find the desired item");
			log.info("System unable to find the desired item");
		}
		
		log.info("End of whatsNew TestCase");
	}
	
}
