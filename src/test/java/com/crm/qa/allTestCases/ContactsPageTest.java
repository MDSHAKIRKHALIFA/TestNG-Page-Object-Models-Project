package com.crm.qa.allTestCases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.Testutil;

public class ContactsPageTest extends TestBase{

	ContactsPage contactsPage;
	HomePage homepage;
	LoginPage loginpage;
	Testutil testUtil;

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		contactsPage = new ContactsPage();
		testUtil = new Testutil();
		homepage = loginpage.login(proper.getProperty("username"), proper.getProperty("password"));
		homepage.clickOnContactsLick();
	}

	@Test(priority = 1)
	public void varifyContactsPageTitleTest() {
		Assert.assertTrue(contactsPage.verifyContactsPageLevel(), "Contacts level is misssting from the page");
	}

	@Test(priority = 2)
	public void CreateNewContacts() throws InterruptedException{
		contactsPage.ClickcreatNewContact();	
	}	

	@AfterMethod
	public void closeDown() {
		driver.quit();
	}
}
//Shakir