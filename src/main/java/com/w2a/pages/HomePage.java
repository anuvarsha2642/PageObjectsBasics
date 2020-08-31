package com.w2a.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.w2a.base.page;

public class HomePage extends page {


	public LoginPage userLogin()
	{
		System.out.println("Inside userlogin function");
		driver.findElement(By.cssSelector(".zh-login")).click();
		return new LoginPage();
	}
	public void goToKnowledgeBase()
	{
		
		
	}
	
	public void goToCommunity()
	{
		
	}

	public void goToSignin() throws InterruptedException
	{
		System.out.println("Inside homePage");
		driver.findElement(By.xpath("//*[@id=\"logoutDetails\"]/ul/li/div/div[1]/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"logoutDetails\"]/ul/li/div/div[2]/div/a[1]/span")).click();
	}

	public void goToLanguages()
	{
		
	}

	public void validateFooterLinks()
{
	
}
}

