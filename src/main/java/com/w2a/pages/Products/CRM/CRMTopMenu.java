package com.w2a.pages.Products.CRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.w2a.base.page;
import com.w2a.pages.Products.CRM.Accounts.CRMAccountsPage;

public class CRMTopMenu {

	
	private static WebDriver driver;
	public CRMTopMenu(WebDriver driver) {
		System.out.println("Inside CRMTopmenu");
		this.driver=driver;
	}

	public void goToLead()
	{
		
	}
	
	public void goToCompaign()
	{
		
	}
	public void goToQuote()
	{
		
	}
	public void goToSalesOrder()
	{
		
	}
	public void goToPurchaseOrder()
	{
		
	}
	public void goToVendor()
	{
		
	}
	public  CRMAccountsPage goToAccount()
	{
		driver.findElement(By.xpath("//div[@data-value='Accounts']")).click();
		return new CRMAccountsPage();
	}
}
