package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	//Page Factory or:
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up']")
	WebElement signUpBtn;
	
	@FindBy(xpath="//a[@class='brand-name']")
	WebElement crmLogo;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validatePageTitel() {
		return driver.getTitle();	
	}
	
	public boolean validateCRMimage() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pw) {
		email.sendKeys(un);
		password.sendKeys(pw);
		loginBtn.click();
		return new HomePage();
	}
	

}
