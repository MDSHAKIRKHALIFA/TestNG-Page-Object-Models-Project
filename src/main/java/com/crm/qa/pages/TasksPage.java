package com.crm.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.TestBase;
public class TasksPage extends TestBase{

	public TasksPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[contains(text(),'Tasks')]")
	WebElement tasksPageLevel;

	public boolean verifytasksPageLevel() {
		return tasksPageLevel.isDisplayed();
	}
}
//Shakir