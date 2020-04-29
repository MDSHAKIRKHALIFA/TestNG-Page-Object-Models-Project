package com.crm.qa.pages;
import java.util.concurrent.TimeUnit;





import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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

	
	@FindBy(xpath="//div[@name='month']")
	String selectMonth;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyContactsPageLevel() {
		return contactsLevel.isDisplayed();
	}

	public void ClickcreatNewContact(String fName, String lName){
		cteateNewContacts.click();
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		
//		Select select = new Select(driver.findElement(By.xpath(selectMonth)));
//		select.selectByVisibleText(month);
		
		saveBtn.click();
	}
}
//Shakir