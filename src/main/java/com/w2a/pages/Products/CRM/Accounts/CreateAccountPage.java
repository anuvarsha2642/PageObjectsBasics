package com.w2a.pages.Products.CRM.Accounts;

import org.openqa.selenium.By;

import com.w2a.base.page;

public class CreateAccountPage extends page{

	public void enterAccountName()
	{
		driver.findElement(By.cssSelector("#Crm_Accounts_ACCOUNTNAME")).clear();
		driver.findElement(By.cssSelector("#Crm_Accounts_ACCOUNTNAME")).sendKeys("Ramn");
		
	}
}
