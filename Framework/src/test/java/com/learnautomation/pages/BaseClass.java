package com.learnautomation.pages;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ConfigDataProvider;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;

public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;

	
	
	@BeforeSuite
	public void setupexcel()
	{
		excel= new ExcelDataProvider();
		config= new ConfigDataProvider();
		
		ExtentHtmlReporter extend= new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/Methven"+Helper.CurrentDate()+".html"));
		report=new ExtentReports();
		report.attachReporter(extend);
	}
	
	@BeforeClass
	public void setup()
	{
	driver=BrowserFactory.startapplication(driver, config.getbrowser(), config.geturl());

}
	@AfterClass
	public void teardown()
	{
		BrowserFactory.Close(driver);
	}
	
	@AfterMethod
	public void screen(ITestResult result) throws IOException
	{
		if (result.getStatus()==ITestResult.FAILURE)
		{
			Helper.Capturescreenshot(driver);
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.Capturescreenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.Capturescreenshot(driver)).build());
		}
		report.flush();
	}
	
}

