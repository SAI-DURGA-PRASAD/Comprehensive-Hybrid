package com.bigsmall.runner;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bigsmall.reusableComponents.BaseClass;
import com.relevantcodes.extentreports.LogStatus;

public class AddingItemtoCart extends BaseClass{

	
	@Test
	public void addingItemtoCart() throws InterruptedException {
		driver.get(config.getURL());
		homepage.getAllofit().click();
		
		allofit.getItem().click();
		items.getFirstItem().click();
		items.addToCart().click();
		Thread.sleep(3000);

		log.info("Total value of product is: "+items.totalValue().getText());
		if(items.totalValue().getText().equals("Rs. 799")){
			items.checkOut().click();
			Thread.sleep(5000);
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("excludeSwitches", "disable-popup-blocking");
			// This test will endup in getting to the chekout page
			test.log(LogStatus.PASS, "System added item to cart and entered into CheckoutPage");
			log.info("System added item to cart and entered into CheckoutPage");
		}
		else {
			test.log(LogStatus.FAIL, "System failed to add to cart & enter into CheckoutPage");
			log.info("System failed to add to cart & enter into CheckoutPage");
		}
		
		
		log.info("End of addingItemtoCart TestCase");
		
	}
}
