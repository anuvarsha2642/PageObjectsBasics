package com.w2a.testcases;

import org.testng.annotations.Test;

import com.w2a.base.page;
import com.w2a.pages.HomePage;
import com.w2a.pages.LoginPage;
import com.w2a.pages.ZohoHomePage;
import com.w2a.pages.Products.CRM.Accounts.CRMAccountsPage;
import com.w2a.pages.Products.CRM.Accounts.CreateAccountPage;
import com.w2a.utilities.ClosingBrowser;

public class LoginTest {

	
	@Test
	public void loginTest()  throws InterruptedException
	{
		 HomePage homePage=new HomePage(); 
		 LoginPage loginPage=homePage.userLogin();
		 ZohoHomePage zohoHomePage =loginPage.doSignIn(); 
		 zohoHomePage.gotToCRM(); 
		 CRMAccountsPage crmAccountsPage=page.topMenu.goToAccount(); 
		 CreateAccountPage  createAccountPage=crmAccountsPage.goTocreateAccount();
		 createAccountPage.enterAccountName();
		 ClosingBrowser cp=new ClosingBrowser();
		 cp.tearDown();
		 
		 
	}
	
}
