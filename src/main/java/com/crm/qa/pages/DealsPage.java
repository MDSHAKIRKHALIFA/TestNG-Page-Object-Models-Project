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
	
	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement NewDealBtn;
	
	@FindBy(name="title")
	WebElement NewDealTitle;
	
	@FindBy(xpath="//input[@name='probability']")
	WebElement probabilityLink;
	
	@FindBy(name="next_step")
	WebElement nestStepLink;
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement DealsSave;

	public boolean validateDealPageLevel() {
		return dealLevel.isDisplayed();
	}
	
	public void creatNewDeals(String title, String probability, String nextstep) {
		NewDealBtn.click();
		NewDealTitle.sendKeys(title);
		probabilityLink.sendKeys(probability);
		nestStepLink.sendKeys(nextstep);
		DealsSave.click();
	}

}
//Shakir
