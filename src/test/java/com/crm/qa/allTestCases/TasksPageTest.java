package com.crm.qa.allTestCases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.Testutil;

public class TasksPageTest extends TestBase{

	HomePage  homepage;
	LoginPage loginpage;
	Testutil  testUtil;
	TasksPage tasksPage;

	public TasksPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginpage = new LoginPage();
		testUtil = new Testutil();
		tasksPage = new TasksPage();
		homepage = loginpage.login(proper.getProperty("username"), proper.getProperty("password"));
		homepage.clickOnDealsLick();
	}

	@Test
	public void verifytaskslevel() {
		Assert.assertTrue(tasksPage.verifytasksPageLevel());
	}
	
	@Test
	public void createNewTask() throws InterruptedException {
		homepage.clickOnTasksLick();
		
		driver.navigate().refresh();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.navigate().refresh();
		tasksPage.creatNewTask("New Task");
	}

	@AfterMethod
	public void closeDown() {
		driver.quit();
	}

}
//Shakir