package com.learnautomation.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage {
	
	
	/*WebDriver driver;

	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	*/



	
	@FindBy(xpath="/html/body/div[3]/div/div[1]/div/div/div/ul/li[5]/a") WebElement wish;
	@FindBy(name="login[username]") WebElement uname;
	@FindBy(name="login[password]") WebElement upass;
	@FindBy(id="send2")WebElement submit;
	
	public void action(String username,String userpassword)
	{
		   try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
			
				e.printStackTrace();
			}
		
		wish.click();
		uname.sendKeys(username);
		upass.sendKeys(userpassword);
		submit.submit();
		
	}

	
	
	
	

}
