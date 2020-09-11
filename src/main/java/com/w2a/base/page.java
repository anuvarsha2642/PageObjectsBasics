package com.w2a.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.w2a.pages.Products.CRM.CRMTopMenu;
import com.w2a.utilities.ExcelReader;
import com.w2a.utilities.ExtentManager;


import io.github.bonigarcia.wdm.WebDriverManager;

public class page {

public static WebDriver driver;
	public static 	Properties configProp=new Properties();
	public static 	Properties pageObjectsProp=new Properties();
	public static FileInputStream fis;
	public static Logger log=Logger.getLogger("devpinoyLogger");
	public static WebDriverWait wait;
	public static ExtentReports rep=ExtentManager.getInstance();
	public static ExtentTest test;
	public static ExcelReader excel=new ExcelReader(System.getProperty("user.dir")+"//src//test//resources//excel//TestData.xlsx");
	public static CRMTopMenu topMenu;

	
	public page()
	{
		if(driver==null) {
			
		
			  System.out.println("Driver is null"); 
			  try {
				fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Configurations.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  log.info("opening config file"); 
			  
			  try {
				configProp.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			  log.debug("Configuration file loaded");
			  try {
					fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\PageObjects.properties");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  log.info("opening Page Object properties  file"); 
				  
				  try {
					  pageObjectsProp.load(fis);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  log.debug("Page object  file loaded");
				 
			
		String browserName=configProp.getProperty("browser");
			System.out.println("The browser name is "+browserName);
			
			//String browserName="Chrome";		
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			System.out.println("Inside page constructor as driver is null");
			
			 ChromeOptions options;
			 HashMap<String,Object> hashMap=new HashMap<String,Object>();
			 hashMap.put("profile.default_content_setting_values.notifications", 2);
			 hashMap.put("credentials_enable_service",false);
			 hashMap.put("profile.password_manager_enabled",false);

			 options=new ChromeOptions(); 
			 options.setExperimentalOption("prefs", hashMap);
			 options.addArguments("-disable-extensions");
			  options.addArguments("-disable-infobars");
			  WebDriverManager.chromiumdriver().setup(); 
			  driver = new  ChromeDriver(options);
			  driver.get("https://www.zoho.com/");
			  driver.manage().window().maximize();
			  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			topMenu=new CRMTopMenu(driver);
			
		}
	
	}
	}		
		

	public void click(String locator)
	{
		System.out.println(locator);
		if(locator.endsWith("_CSS"))
			{
			driver.findElement(By.cssSelector((pageObjectsProp.getProperty(locator)))).click();
			test.log(LogStatus.INFO, "Clicking on :"+locator);
			}
			
		else if(locator.endsWith("_XPATH"))
		{
			driver.findElement(By.xpath((pageObjectsProp.getProperty(locator)))).click();
			test.log(LogStatus.INFO, "Clicking on :"+locator);
		}
		else if(locator.endsWith("_ID"))
		{
			System.out.println("Inside click with ID");
			WebElement element=driver.findElement(By.id((pageObjectsProp.getProperty(locator))));
			System.out.println("Element to click is " +element);
			element.click();
			test.log(LogStatus.INFO, "Clicking on :"+locator);
		}
	}
	//************************************************************************************************************************************//
	//Method to type in values in  webelements
	public void type(String locator,String value)
	{
		System.out.println(locator +" " +value);
		if(locator.endsWith("_CSS"))
		{
			System.out.println("Inside type with css selector "+locator.toString());
			driver.findElement(By.cssSelector((pageObjectsProp.getProperty(locator)))).sendKeys(value);
			test.log(LogStatus.INFO, "Sending values to :"+locator);
		}
		else if(locator.endsWith("_XPATH"))
		{
			System.out.println("Inside type with XPATH");
			driver.findElement(By.xpath((pageObjectsProp.getProperty(locator)))).sendKeys(value);
			
			test.log(LogStatus.INFO, "Sending values to :"+locator);
		}
			
		else if(locator.endsWith("_ID"))
		{	
			System.out.println("Inside type with ID");
			WebElement element=driver.findElement(By.id((pageObjectsProp.getProperty(locator))));
			System.out.println(element);
			element.sendKeys(value);
			test.log(LogStatus.INFO, "Sending values to :"+locator);
		}
	}

	//************************************************************************************************************************************//
	//Method to select dropdown box and select  values in  it
	static WebElement dropDown ;
	public void selectDropDown(String locator,String value)
	{
		System.out.println("Inside select method");
		System.out.println(locator);
		System.out.println(value);
		if(locator.endsWith("_CSS"))
			{
			System.out.println("Inside CSS");
			dropDown=driver.findElement(By.cssSelector((pageObjectsProp.getProperty(locator))));
			test.log(LogStatus.INFO, "Selecting on :"+locator +"Entering values"+value);
			}
			
		else if(locator.endsWith("_XPATH"))
		{
			System.out.println("Inside XPATH");
			dropDown=driver.findElement(By.xpath((pageObjectsProp.getProperty(locator))));
			test.log(LogStatus.INFO, "Selecting on :"+locator +"Entering values"+value);
		}
		else if(locator.endsWith("_ID"))
		{
			System.out.println("Inside ID");
			dropDown=driver.findElement(By.id((pageObjectsProp.getProperty(locator))));
			test.log(LogStatus.INFO, "Selecting on :"+locator +"Entering values"+value);
		}
		
		Select select=new Select(dropDown);
		select.selectByVisibleText(value);
	}



}
