package com.actitime.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class FWUtils {

	public static String getXLdata(String path,String sheet,int row,int cell) {
		String value="";
	
	{
		try{
			Workbook wk = WorkbookFactory.create(new File(path));
			value=wk.getSheet(sheet).getRow(row).getCell(cell).toString();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return value;
	}
	}
	
	public static void setXLdata(String path, String sheet,int row,int cell,String value) {
		try {
			FileInputStream fis =new FileInputStream(new File(path));
			Workbook wk = WorkbookFactory.create(fis);
			Sheet sh = wk.getSheet(sheet);
			Row r = sh.getRow(row);
			if (r==null)
				r=sh.createRow(row);
			Cell c = r.getCell(cell);
			if (c==null)
				c=r.createCell(cell);
				c.setCellValue(value);
				FileOutputStream fos = new FileOutputStream(new File(path));
				wk.write(fos);
				fos.close();
				wk.close();
				fis.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	public static void getSnapshot(WebDriver driver,String path) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File scr = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(path);
		
		try {
			FileUtils.copyFile(scr, dest);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
			
	}
	
	public static int getLastRownumber(String path,String sheet) {
		int value=0;
		try {
			Workbook wk = WorkbookFactory.create(new File(path));
			value=wk.getSheet(sheet).getLastRowNum();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return value;
		}
	public static int getlastCellnumber(String path,String sheet,int row) {
		int value1=0;
		try {
			Workbook wk = WorkbookFactory.create(new File(path));
			value1=wk.getSheet(sheet).getRow(row).getLastCellNum();
	} catch (Exception e) {
			
			e.printStackTrace();
		}
		return value1;
		}
	
	
	
	
	public static void varifyTile(WebDriver driver,String expectedTitle) {
		String actualtile = driver.getTitle();
		Assert.assertEquals(actualtile, expectedTitle);
	}

	

	
}
	

