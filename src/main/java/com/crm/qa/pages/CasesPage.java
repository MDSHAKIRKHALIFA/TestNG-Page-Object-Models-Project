package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class CasesPage extends TestBase{
	
	HomePage homepage;
	
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement casePage;
	
	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement newLink;
	
	@FindBy(xpath="//input[@name='title']")
	WebElement title;
	
	@FindBy(xpath="//div[@class='ui fluid selection dropdown']")
	WebElement assignedto;
	
	@FindBy(xpath="//div[@class='visible menu transition']//span[@class='text'][contains(text(),'Md Shakir')]")
	WebElement selectassigned;
	
	@FindBy(xpath="//div[@name='company']//input[@class='search']")
	WebElement companySearch;
	
	@FindBy(xpath="//div[@name='type']")
	WebElement type;
	
	@FindBy(xpath="//span[contains(text(),'General Support')]")
	WebElement typeoftype;
	
	@FindBy(xpath="//div[@class='two fields']//div[1]//div[1]//div[1]//div[1]//input[1]")
	WebElement closeDate;
	
	@FindBy(xpath="//div[@class='react-datepicker__day react-datepicker__day--026']")
	WebElement date;
	
	@FindBy(xpath="//li[contains(text(),'15:00')]")
	WebElement time;
	
	@FindBy(xpath="//textarea[@name='description']")
	WebElement discription;
	
	@FindBy(xpath="//div[@name='priority']")
	WebElement priority;
	
	@FindBy(xpath="//span[contains(text(),'Normal')]")
	WebElement typeofPriority;
	
	@FindBy(xpath="//input[@name='identifier']")
	WebElement identifier;
	
	@FindBy(xpath="//div[@name='contact']//input[@class='search']")
	WebElement contactSearch;
	
	@FindBy(xpath="//div[@name='deal']//input[@class='search']")
	WebElement dealSearch;
	
	@FindBy(xpath="//div[@class='ui fluid container main-content']//div[2]//div[1]//div[1]//div[1]//input[1]")
	WebElement deadLine;
	
	@FindBy(xpath="//div[@class='react-datepicker__day react-datepicker__day--029']")
	WebElement deadlinedate;
	
	@FindBy(xpath="//div[@class='ui fluid multiple search selection dropdown']")
	WebElement tags;
	
	@FindBy(xpath="//span[contains(text(),'Add')]")
	WebElement addtages;
	
	@FindBy(xpath="//div[@name='status']")
	WebElement status;
	
	@FindBy(xpath="//span[contains(text(),'Awaiting input')]")
	WebElement typeofStatus;
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement saveBtn;
	
	public CasesPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean iscasesdisplayed() {
		return casePage.isDisplayed();
	}
	
	public void createCases(String titleofTitle, String company, String discrioptions, String indentifiers, String contact, String deals, String tagss) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		newLink.click();
		title.sendKeys(titleofTitle);
		assignedto.click();
		selectassigned.click();
		companySearch.sendKeys(company);
		type.click();
		typeoftype.click();
		closeDate.click();
		date.click();
		time.click();
		discription.sendKeys(discrioptions);
		priority.click();
		typeofPriority.click();
		identifier.sendKeys(indentifiers);
		contactSearch.sendKeys(contact);
		dealSearch.sendKeys(deals);
		deadLine.click();
		deadlinedate.click();
		time.click();
		
		//The element wasn't intractable so we have to use actions class or JavascriptExecutor for that
		
		WebElement element = driver.findElement(By.xpath("//div[@class='ui fluid multiple search selection dropdown']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().sendKeys(tagss).perform();
		
//		OR
//		JavascriptExecutor jse = (JavascriptExecutor)driver;
//		jse.executeScript("scroll(250, 0)"); // if the element is on top.
//		jse.executeScript("scroll(0, 250)"); // if the element is on bottom.
//
//		OR
//		JavascriptExecutor jse = (JavascriptExecutor)driver;
//		jse.executeScript("arguments[0].scrollIntoView()", Webelement);
		
		//tags.sendKeys(tagss);
		//Thread.sleep(2000);
		//addtages.click();
		
		status.click();
		typeofStatus.click();
		saveBtn.click();
		
	}

}
