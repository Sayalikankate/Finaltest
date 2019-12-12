package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {
	
	public static long IMPLICIT_WAIT = 10;
	public static long PAGE_LOAD_TIMEOUT= 20;
	public static String EXCEL_PATH= "C:\\Users\\sayali.sunil.kankate\\eclipse-workspace\\TestNG_POM\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCRMTestData.xlsx";
	static Workbook book;
	static Sheet sheet;
	
	
	public static Object[][] getTestData(String sheetname) {
		
	//	System.getProperty();
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(EXCEL_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			book= WorkbookFactory.create(fis);
		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetname);
		Object [][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0; i< sheet.getLastRowNum(); i++) {
			for(int j=0; j< sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j]= sheet.getRow(i+1).getCell(j).toString();
			}
		}
		
		return data;
	}


	public static void takeScreenshotAtEndOfTest() {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String dir = System.getProperty("user.dir");
		try {
			FileUtils.copyFile(src, new File(dir+"/screenshots/"+System.currentTimeMillis()+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void scrollfunction() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,400)");
	}
	
	public static void waitfunction() {
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}

}
