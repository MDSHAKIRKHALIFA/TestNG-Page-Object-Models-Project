package com.crm.qa.allTestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
	}
	
	@Test(priority = 1)
	public void login() {
		homepage = loginpage.login(proper.getProperty("username"), proper.getProperty("password"));
	}
	
	@AfterMethod
	public void closeDown() {
		driver.quit();
	}

}
