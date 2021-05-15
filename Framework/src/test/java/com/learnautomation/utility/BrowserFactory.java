package com.learnautomation.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
	
	public static WebDriver startapplication(WebDriver driver,String browsername,String url)
	{
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		
		else if(browsername.equals("firefox"))
		{
			
		}
		
		else if(browsername.equals("IE"))
		{
			
			
		}
		else
		{
			System.out.print("This is not a valid browser");
		}
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		return driver;
	}
	public static void Close(WebDriver driver)
	{
		driver.quit();
	
	}
	

}
