package com.crm.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.TestBase;

public class DealsPage  extends TestBase{

	public DealsPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement dealLevel;

	public boolean validateDealPageLevel() {
		return dealLevel.isDisplayed();
	}

}
//Shakir
