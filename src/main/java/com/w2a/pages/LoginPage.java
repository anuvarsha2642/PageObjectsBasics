package com.w2a.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.w2a.base.page;

public class LoginPage extends page{


public ZohoHomePage doSignIn() throws InterruptedException
{
	System.out.println("tRYING TO LOG IN");
	Thread.sleep(1000);
	System.out.println(driver.getTitle());
	type("Email_ID","anuvarsha.susendra@gmail.com");
	System.out.println("Name entered");
	Thread.sleep(1000);
	click("SignBtn_CSS");
	Thread.sleep(1000);
	type("Passwd_ID","Happy123@wl");
	click("SignBtn_CSS");
	return new ZohoHomePage();
	
}
	
}
