package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.commons.io.FileUtils;
//import org.apache.poi.hslf.model.Sheet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {
	public static long PAGE_LOAD_TIMEOUT = 35;
	public static long IMPLICIT_WAIT = 15;
	public static String TESTDATA_SHEET_PATH = "C:\\Users\\SUKHMANI\\Desktop\\Eclipse Workspace"
			+ "\\Free_CRM_Test_AMRIT\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCrmTestdataa.xlsx";
	static Workbook book;
	static Sheet sheet;

	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}

//GET DATA FROM EXCEL
//****************************************************//
	public static Object[][] getTestData(String sheetName)
      {
    	  FileInputStream file=null;
    	  try {
    		  file=new FileInputStream(TESTDATA_SHEET_PATH);
    	  }
    	  catch(FileNotFoundException e)
    	  {
    		  e.printStackTrace();
    	  }
    	  try {
    		  book= WorkbookFactory.create(file);
    	  }
    	  catch(InvalidFormatException e)
    	  {
    		  e.printStackTrace();
    	  }
    	  catch(IOException e)
    	  {
    		  e.printStackTrace();
    	  }
    	  sheet=  book.getSheet(sheetName); 
    	  Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
    	  for(int i=0;i<sheet.getLastRowNum();i++)
    	  {
    		  for(int k=0;k<sheet.getRow(0).getLastCellNum();k++)
    		  {
    			  data[i][k] = sheet.getRow(i+1).getCell(k).toString();
    		  }
    	  }
    	  return data;
      }

//SCREENSHOT METHOD*****************************************//
	
	  public static void takeScreenshotAtEndOfTest() throws IOException
	  {
		  String currentDir = System.getProperty("user.dir");
		  File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(srcFile, new File(currentDir + "/sscreenshotsssss/" + System.currentTimeMillis() + ".png"));
		  
	  }

}