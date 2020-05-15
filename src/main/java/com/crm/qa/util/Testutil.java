package com.crm.qa.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.crm.qa.base.TestBase;

public class Testutil extends TestBase{
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	
	public static Workbook book;
	public static Sheet sheet;
	public static String TestData_Sheet_Path = "/Users/shakir/eclipse-workspace2/My_TestNG/src/main/java/com/crm/qa/testData/FreeCRMTestData.xlsx";

	public static Object[][] getTestData(String sheetName){
		
		FileInputStream file = null;
		try {
			file = new FileInputStream(TestData_Sheet_Path);
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
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		//System.out.println(sheet.getLastRowNum()+"-------------"
		//sheet.getRow(0).getLastCellNum());
		for(int i=0;i<sheet.getLastRowNum();i++) {
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
				//System.out.println(data[i][j]);
			}
		}
		return data;
	}
	
//	public void switchToFrame() {
//		driver.switchTo().frame(" ");
//	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
}
	
	
	
//	public void afterScenarioEnd(Scenario scenario) {
//
//		if (scenario.isFailed()) {
//			try {
//				// Casting
//				byte[] screenshot = ((TakesScreenshot) testHelper.getDriver()).getScreenshotAs(OutputType.BYTES);
//				scenario.embed(screenshot, "image/png");
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//
//		System.out.println("Scenario Ended... ");
//		testHelper.getDriver().close();
//	}
//}
//Shakir