package com.bigsmall.runner;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bigsmall.reusableComponents.BaseClass;
import com.bigsmall.utilities.ExcelReader;
import com.relevantcodes.extentreports.LogStatus;

public class LoginTest extends BaseClass{

	//To Login into the page
	@Test(dataProvider="loginData")
	public void signInTest(String username,String password) {
		driver.get(config.getURL());
		log.info("Driver open URL and entered into Landing Page");
		homepage.signIn().click();
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	    ChromeOptions options  = new ChromeOptions();
	    options.setExperimentalOption("excludeSwitches", "disable-popup-blocking");
	    
		login.email().sendKeys(username);
		login.password().sendKeys(password);
		login.submit().click();
		
		test.log(LogStatus.PASS,"System successfully entered login details");
		log.info("System successfully entered login details");
		
		log.info("End of signInTest TestCase");
	}
	
	@DataProvider(name="loginData")
	public Object[][] loginDataProvider() throws IOException {
		HashMap<String,String> data = ExcelReader.getTestData("login_details");
		int size = data.size();
		Object[][] obj = new Object[size][2];
		
		Iterator iter = data.entrySet().iterator();
		int index = 0;
		while(iter.hasNext()) {
			Map.Entry mapElement = (Map.Entry)iter.next();
			obj[index][0] = mapElement.getKey();
			obj[index][1] = mapElement.getValue();
			index++;
		}
		return obj;
	}
}
