package com.crm.qa.allTestCases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.Testutil;

public class DealsPageTest extends Testutil{

	HomePage homepage;
	LoginPage loginpage;
	Testutil testUtil;
	DealsPage dealPage;

	public DealsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginpage = new LoginPage();
		testUtil = new Testutil();
		dealPage = new DealsPage();
		homepage = loginpage.login(proper.getProperty("username"), proper.getProperty("password"));
		homepage.clickOnDealsLick();
		Thread.sleep(4000);
	}


	@Test(priority = 1)
	public void varifyContactsPageTitleTest() {
		Assert.assertTrue(dealPage.validateDealPageLevel(), "Deals level is misssing from the page");
	}

	@AfterMethod
	public void closeDown() {
		driver.quit();
	}
}
//Shakir