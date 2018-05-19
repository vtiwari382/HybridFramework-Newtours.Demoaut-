package com.newtour.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.newtour.qa.testbase.TestBase;

public class TestUtils extends TestBase {
	
	public static long PAGE_LOAD_TIME =20;
	public static long IMPLICIT_WAIT =20;
	public static String TESTDATA_SHEET_PATH = ".\\src\\main\\java\\com\\newtour\\qa\\testdata\\Demout_Tour.xlsx";
	
	public static Workbook book;
	public static Sheet sheet;
	
	
	public static Object[][] GetTestData(String SheetName) {
		FileInputStream file = null;
		try {
			 file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
		       book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	     sheet=book.getSheet(SheetName);
	Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	System.out.println("last row number is:" +sheet.getLastRowNum());
	System.out.println("get sheet.getRow(0).getLastCellNum() is : " +sheet.getRow(0).getLastCellNum());
	
	for(int i=0; i<sheet.getLastRowNum(); i++) {
		for(int j=0; j<sheet.getRow(0).getLastCellNum(); j++) {
			data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			System.out.println("value of data[i][j] is after each iteration :" +data[i][j]);
			
		}
		
	}return data;
	}
	
	public static void TakesScreenshotAtEndOfTheTest() throws Exception {
		File scr=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String filename =  new SimpleDateFormat("dd-MM-yyyy hh-mm-ss").format(new Date());
		String currentdir = System.getProperty("user.dir")+"/Screenshots/";
		File dest = new File(currentdir+ filename +".png");
		FileUtils.copyFile(scr, dest);
		
	}
	
	
	

}
