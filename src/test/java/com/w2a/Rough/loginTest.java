package com.w2a.Rough;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.w2a.pages.HomePage;
import com.w2a.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class loginTest {

public static void main(String args[])
{
	login();
}





	public static void login()
	{
		WebDriver driver;
		WebDriverManager.chromiumdriver().setup();
		 driver = new ChromeDriver();
		driver.get("https://help.zoho.com/portal/en/home");
		driver.manage().window().maximize();
		driver.manage().timeouts().setScriptTimeout(1000, TimeUnit.SECONDS);
		HomePage homePage=new HomePage(driver);
		try {
			homePage.goToSignin();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LoginPage loginPage=new LoginPage(driver);
		try {
			loginPage.doSignIn();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}

