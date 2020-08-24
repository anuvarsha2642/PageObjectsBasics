package com.w2a.pages;

import java.sql.Time;

import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
WebDriver driver;
public static WebDriverWait wait;
public LoginPage(WebDriver driver) {
	super();
	this.driver = driver;
}
	
public void doSignIn() throws InterruptedException
{
	
	driver.findElement(By.id("login_id")).sendKeys("anuvarsha.susendra@gmail.com");
	driver.findElement(By.id("nextbtn")).click();
	WebElement passwd=driver.findElement(By.id("password"));
	Thread.sleep(1000);
	passwd.sendKeys("Happy123@wl");
	driver.findElement(By.id("nextbtn")).click();
	
}
	
}
