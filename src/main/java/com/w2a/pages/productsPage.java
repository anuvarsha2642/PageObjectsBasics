package com.w2a.pages;

import org.openqa.selenium.By;

import com.w2a.base.page;

public class productsPage extends page{
	public void goToCRM()
	{
		driver.findElement(By.cssSelector(".zc-crm")).click();
	}
}
