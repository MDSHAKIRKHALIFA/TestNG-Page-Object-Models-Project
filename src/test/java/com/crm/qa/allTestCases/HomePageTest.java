package com.crm.qa.allTestCases;
import static org.testng.Assert.assertEquals;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactsPage;
	public HomePageTest() {
		super();
	}

	//test cases should be separated --- independent with each other
	//before every test cases launch the browser and do login
	//@test-- execute test cases 
	//after each test cases close the browser
	//the reason for all that is not to put load on the browser and delete all cookies

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		contactsPage = new ContactsPage();
		homepage = loginpage.login(proper.getProperty("username"), proper.getProperty("password"));
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homepage.verifyHomepageTitle();
		assertEquals(homePageTitle, "Cogmento CRM","Home page Title Not Matched");
	}

	@Test(priority = 2)
	public void verifyUserNameTest() {
		Assert.assertTrue(homepage.verifyCorrectUserName());
	}

	@Test(priority = 3)
	public void verifyContactLinkTest() {
		contactsPage = homepage.clickOnContactsLick();
	}

	@AfterMethod
	public void closeDown() {
		driver.quit();
	}
}
//Shakir