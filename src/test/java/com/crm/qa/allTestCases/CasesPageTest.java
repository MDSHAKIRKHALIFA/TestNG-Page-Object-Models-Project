package com.crm.qa.allTestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CasesPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.Testutil;

public class CasesPageTest extends TestBase{
	
	public CasesPageTest() {
		super();
	}

	CasesPage casepage;
	HomePage homepage;
	LoginPage loginpage;
	Testutil testUtil;
	String sheetName= "Cases";
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		testUtil = new Testutil();
		homepage = loginpage.login(proper.getProperty("username"), proper.getProperty("password"));
		casepage = homepage.clickonCases();
	}
	
	@Test(priority = 1)
	public void verifycasesPage() {
		Assert.assertTrue(casepage.iscasesdisplayed(), "Cases Page header is missing");
	}
	
	@Test(priority = 2)
	public void createCase() throws InterruptedException {
		driver.navigate().refresh();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.navigate().refresh();
		casepage.createCases("Case1", "Google", "Case of QA engineer", "Qa", "Md", "401k", "aaaa");
	}
	
	@DataProvider
	public Object[][]getCasesTestData(){
		Object[][] data = Testutil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority = 3, dataProvider = "getCasesTestData")
	public void createCases(String titleofTitle, String company , String discrioptions, String indentifiers, String contact, String deals, String tagss) throws InterruptedException {
		homepage.clickonCases();
		driver.navigate().refresh();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.navigate().refresh();
		casepage.createCases(titleofTitle, company, discrioptions, indentifiers, contact, deals, tagss);
	}
	
	@AfterMethod
	public void closeDown() {
		driver.quit();
	}
	
}
