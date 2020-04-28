package com.crm.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.TestBase;

public class HomePage  extends TestBase{

	@FindBy(xpath="//span[@class='user-display']")
	WebElement userName;

	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactsLink;

	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement DealsLink;

	@FindBy(xpath="//span[contains(text(),'Tasks')]")
	WebElement TasksLink;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomepageTitle() {
		return driver.getTitle();	
	}

	public boolean verifyCorrectUserName() {
		return userName.isDisplayed();

	}

	public ContactsPage clickOnContactsLick() {
		contactsLink.click();
		return new ContactsPage();
	}

	public DealsPage clickOnDealsLick() {
		DealsLink.click();
		return new DealsPage();
	}

	public TasksPage clickOnTasksLick() {
		TasksLink.click();
		return new TasksPage();
	}
}
//Shakir