package com.w2a.utilities;

import org.testng.annotations.AfterSuite;

import com.w2a.base.page;

public class ClosingBrowser extends page{

	@AfterSuite
	public void tearDown()
	{
		driver.quit();
	}
}
