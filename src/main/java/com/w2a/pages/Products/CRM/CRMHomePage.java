package com.w2a.pages.Products.CRM;

import org.openqa.selenium.By;

import com.w2a.base.page;

public class CRMHomePage extends page{

	public void goToaccessZohoCRM()
	{
		driver.findElement(By.cssSelector(".access_btn_sec")).click();
	}

	
	

	
}
