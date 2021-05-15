package com.learnautomation.testcases;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.LoginPage;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ExcelDataProvider;


public class LoginTest extends BaseClass{

	
	
	@Test
	
	
	public void App()
	{  
   
   logger=report.createTest("Login into the site");
    
	LoginPage loginpage= PageFactory.initElements(driver, LoginPage.class);
	logger.info("Start test");
	
	loginpage.action(excel.getstringvalue("Login",0, 0),excel.getstringvalue("Login",0, 1));
	logger.pass("Login Success");
	
	}
	
}
