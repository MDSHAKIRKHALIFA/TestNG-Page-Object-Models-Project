package com.crm.qa.allTestCases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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
	String sheetsName = "Contacts";

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
		contactsPage = homepage.clickOnContactsLick();
	}

	@Test(priority = 1)
	public void varifyContactsPageTitleTest() {
		Assert.assertTrue(contactsPage.verifyContactsPageLevel(), "Contacts level is misssting from the page");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = Testutil.getTestData(sheetsName);
		return data;
	}

	@Test(priority = 2, dataProvider="getCRMTestData")
	public void CreateNewContacts(String FirstName, String LastName){
		//contactsPage.ClickcreatNewContact("Md", "Shakir");
		homepage.clickOnContactsLick();
		driver.navigate().refresh();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.navigate().refresh();
		contactsPage.ClickcreatNewContact(FirstName, LastName);
	}
	
	@AfterMethod
	public void closeDown() {
		driver.quit();
	}
}
//Shakir