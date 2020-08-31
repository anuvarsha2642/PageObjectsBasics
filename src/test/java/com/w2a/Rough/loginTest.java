package com.w2a.Rough;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.w2a.base.page;
import com.w2a.pages.HomePage;
import com.w2a.pages.LoginPage;
import com.w2a.pages.ZohoHomePage;
import com.w2a.pages.bundlesPage;
import com.w2a.pages.productsPage;
import com.w2a.pages.Products.CRM.CRMHomePage;
import com.w2a.pages.Products.CRM.CRMTopMenu;
import com.w2a.pages.Products.CRM.Accounts.CRMAccountsPage;
import com.w2a.pages.Products.CRM.Accounts.CreateAccountPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class loginTest{

	public static void main(String args[]) throws InterruptedException {
		login();
	}

	public static void login() throws InterruptedException
	{
		
		
		  HomePage homePage=new HomePage(); LoginPage loginPage=homePage.userLogin();
		  ZohoHomePage zohoHomePage=loginPage.doSignIn(); zohoHomePage.gotToCRM();
		  CRMAccountsPage crmAccountsPage=page.topMenu.goToAccount(); CreateAccountPage
		  createAccountPage=crmAccountsPage.goTocreateAccount();
		  createAccountPage.enterAccountName();
		 
		System.out.println(System.getProperty("user.dir"));
		
	}

	
}
