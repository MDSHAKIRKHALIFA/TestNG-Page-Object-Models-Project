package com.crm.qa.pages;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{

	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactsLevel;

	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement cteateNewContacts;

	@FindBy(name="first_name")
	WebElement firstName;

	@FindBy(xpath="//input[@name='last_name']")
	WebElement lastName;

	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement saveBtn;

	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyContactsPageLevel() {
		return contactsLevel.isDisplayed();
	}

	public void ClickcreatNewContact() throws InterruptedException{
		cteateNewContacts.click();
		driver.navigate().refresh();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		firstName.sendKeys("Md");
		lastName.sendKeys("Shakir");
		saveBtn.click();
	}
}
//Shakir