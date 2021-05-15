package com.learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	public static String Capturescreenshot(WebDriver driver)
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotpath=System.getProperty("user.dir")+"/Screenshots/"+CurrentDate()+"png";
		
		try {
			FileHandler.copy(src, new File(screenshotpath));
		} catch (Exception e) {
			System.out.println("Captured Screenshot");
		}
		return screenshotpath;
		
	}
	public static String CurrentDate()
	{
		DateFormat current= new SimpleDateFormat("MM_dd_yyy_HH_mm_ss");
		Date checkdate= new Date();
		return current.format(checkdate);
	}

}
