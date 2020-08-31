




package com.w2a.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Hashtable;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.w2a.base.page;

public class Utilities extends page{
	public static String screenshotName;
	public static void captureScreenShot()
	{
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			java.util.Date d=new java.util.Date();
		
		 screenshotName=d.toString().replace(" ", "_").replace(":","_")+".png";
		 FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\"+screenshotName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	//************************************************************************************************************************************//
	//DataProvider for all testcases 
	@DataProvider(name="dp")
	public Object[][] getData(Method m) throws IOException {
	
		
		String sheetName=m.getName();
		System.out.println(sheetName);
		int rows=excel.getRowCount(sheetName);
		System.out.println("rows "+rows);
		int cols=excel.getColumnCount(sheetName);
		System.out.println("cols"+cols);
		
		Object data[][]=new Object[rows-1][1];
		Hashtable<String,String> table=null;
		for(int rowNum=2;rowNum<=rows;rowNum++)
		{
			table=new Hashtable<String,String>();
			System.out.println("Inside outerloop");
			for(int colNum=0;colNum<cols;colNum++)
			{
				
				System.out.println("insde inside loop");
				table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
				data[rowNum-2][0]=table;
				
			}
		}
		
		return data;
	}


//************************************************************************************************************************************//
	//Method to Check the runmode of  testcases and returns true if runmode is 'y' and 
	//false if runmode is 'n'

public static boolean  isTestRunnable(String testcaseName)
{
	System.out.println("Inside isTestRunnable method");
	String sheetNAme="testSuite";
	int row=excel.getCellRowNum(sheetNAme, "TCID", testcaseName);
	System.out.println("row num"+row);
	String value=excel.getCellData(sheetNAme, "Runmode", row);
	System.out.println("Boolean value"+"for Testcase   "+testcaseName+value);
	
	if(value.equalsIgnoreCase("yes"))
		return true;
	else
		return false;
		
}
	
	
}
	