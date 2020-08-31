package com.w2a.pages.Products.CRM.Accounts;

import org.openqa.selenium.By;

import com.w2a.base.page;

public class CRMAccountsPage extends page  {

	public CreateAccountPage goTocreateAccount()
	{
		driver.findElement(By.cssSelector("button[data-zcqa='cv_createbtn']")).click();
		return new CreateAccountPage();
	}
	
}
